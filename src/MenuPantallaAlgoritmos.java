import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuPantallaAlgoritmos extends JFrame implements ActionListener, ChangeListener, ItemListener {
    public static Integer opcionComparar = 0;
    private JPanel panelPrincipal ;
    private JComboBox comboBoxOrigen ;
    private JComboBox comboBoxDestino ;
    private JComboBox comboBoxComparacion;
    private JTextArea consola;
    private JScrollPane scroll;
    JRadioButton radio1,radio2,radio3,radio4;
    private JButton botonViajar,botonComparar;
    private Integer Opcion = 0 ;
    private Graph grafo1 = MapBuilder.getGraph();

    public MenuPantallaAlgoritmos(){
        setLayout(null);
        setBounds(400,400,600,500);
        creaMenuInteractivo();
        crearConsola();
        setOpcionesAlgoritos();

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void creaMenuInteractivo()
    {
        JLabel labelCiudadOrigen = new JLabel("Ciudad Origen");
        labelCiudadOrigen.setBounds(10,30,100,50);
        add(labelCiudadOrigen);
        comboBoxOrigen = new JComboBox();
        comboBoxOrigen.setBounds(110,45,150,20);
        comboBoxDestino = new JComboBox();
        comboBoxDestino.setBounds(430,45,150,20);
        grafo1.getNodes().forEach(item ->{
            comboBoxOrigen.addItem(item.getCity());
            comboBoxDestino.addItem(item.getCity());
        });
        comboBoxOrigen.addItemListener(this);
        add(comboBoxOrigen);
        JLabel labelDestino = new JLabel("Ciudad Destino");
        labelDestino.setBounds(330,30,100,50);
        add(labelDestino);
        add(comboBoxDestino);
        comboBoxComparacion = new JComboBox();
        comboBoxComparacion.setBounds(10,80,140,30);
        comboBoxComparacion.addItem("Ninguno");
        comboBoxComparacion.addItem("BFS");
        comboBoxComparacion.addItem("DFS");
        comboBoxComparacion.addItem("Branch and Bounding");
        comboBoxComparacion.addItem("Dijkstra");
        comboBoxComparacion.addItem("A*");
        add(comboBoxComparacion);
        botonViajar = new JButton("Realizar Recorrido");
        botonViajar.setBounds(180,80,150,30);
        botonViajar.addActionListener(this);
        add(botonViajar);
    }

    public void crearConsola(){
        JLabel label = new JLabel("Consola de resultados 7u7");
        label.setBounds(10,110,200,30);
        add(label);
        consola = new JTextArea();
        scroll = new JScrollPane(consola);
        scroll.setBounds(10,140,570,250);
        add(scroll);
    }

    public void setOpcionesAlgoritos(){
        ButtonGroup bg=new ButtonGroup();
        radio1=new JRadioButton("Algoritmo BFS");
        radio1.addChangeListener(this);
        radio1.setBounds(10,10,120,20);
        add(radio1);
        radio2=new JRadioButton("Algoritmo DFS");
        radio2.addChangeListener(this);
        radio2.setBounds(130,10,120,20);
        add(radio2);
        radio3=new JRadioButton("Algoritmo Branch And Bound");
        radio3.addChangeListener(this);
        radio3.setBounds(250,10,200,20);
        add(radio3);
        radio4=new JRadioButton("Algoritmo Dikjstra");
        radio4.addChangeListener(this);
        radio4.setBounds(450,10,250,20);
        add(radio4);
        radio2.addChangeListener(this);
        radio3.addChangeListener(this);
        radio4.addChangeListener(this);
        bg.add(radio1);
        bg.add(radio2);
        bg.add(radio3);
        bg.add(radio4);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==botonViajar){
            if(opcionComparar == 1){
                String origen=(String)comboBoxOrigen.getSelectedItem();
                String destino=(String)comboBoxDestino.getSelectedItem();
                MapBuilder.hasPathBfs(origen,destino);
                List<String> lista = new ArrayList<>();
                String Texto = "";
                lista.add("Total de Ciudades Visitadas" + (MapBuilder.ciudadesRecorridas.size()-1));
                for(String recorrido : MapBuilder.ciudadesRecorridas){
                    lista.add(recorrido);
                }
                for(String impresion : lista){
                    Texto += impresion + "\n";
                }
                consola.setText(Texto);
            }
            else
            {
                //JOptionPane.showMessageDialog(null,"Selecciona un algoritmo","A caso usted mastica awa?",JOptionPane.WARNING_MESSAGE);
                JOptionPane.showMessageDialog(null,"Selecciona un algoritmo","A caso usted mastica awa?",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        /*if (itemEvent.getSource()==comboBoxOrigen) {
            String seleccionado=(String)comboBoxOrigen.getSelectedItem();
            for (Node node : grafo1.getNodes()) {
                if (node.getCity().equals(seleccionado)) {
                    comboBoxDestino.removeAllItems();
                    node.getAdjacents().forEach(var_iterator ->{
                        comboBoxDestino.addItem(var_iterator.getDestination().getCity());
                    });
                }
            }
        }

         */
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        if(radio1.isSelected()){
            opcionComparar = 1 ;
        }
        if(radio2.isSelected()){
            opcionComparar = 2 ;
        }
        if(radio3.isSelected()){
            opcionComparar = 3 ;
        }
        if(radio4.isSelected()) {
            opcionComparar = 4;
        }
    }

    public static void main(String args[]){
        new MenuPantallaAlgoritmos();
    }
}
