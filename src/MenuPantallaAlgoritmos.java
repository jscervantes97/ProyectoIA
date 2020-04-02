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
    public static String nombreAlgoritmo = "Ninguno";
    private JPanel panelPrincipal ;
    private JComboBox comboBoxOrigen ;
    private JComboBox comboBoxDestino ;
    private JComboBox comboBoxComparacion;
    private JTextArea consola;
    private JScrollPane scroll;
    private JLabel labelComparar,muestraResultados;
    JRadioButton radio1,radio2,radio3,radio4,radio5;
    private JButton botonViajar,botonComparar;
    private Integer Opcion = 0 ;
    private Graph grafo1 = MapBuilder.getGraph();

    public MenuPantallaAlgoritmos(){
        super("Algoritmos de Busqueda");
        setLayout(null);
        setBounds(400,100,600,500);
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
        JLabel label = new JLabel("Comparar con: ");
        label.setBounds(10,80,100,30);
        add(label);
        comboBoxComparacion = new JComboBox();
        comboBoxComparacion.setBounds(110,80,150,30);
        comboBoxComparacion.addItem("NINGUNO");
        comboBoxComparacion.addItemListener(this);
        add(comboBoxComparacion);
        botonViajar = new JButton("Realizar Recorrido");
        botonViajar.setBounds(280,80,150,30);
        botonViajar.addActionListener(this);
        add(botonViajar);
    }

    public void crearConsola(){
        JLabel label = new JLabel("Resultados:");
        label.setBounds(10,110,200,30);
        add(label);
        labelComparar = new JLabel("Algoritmo Seleccionado: " + nombreAlgoritmo);
        labelComparar.setBounds(10,130,600,30);
        muestraResultados = new JLabel("");
        muestraResultados.setBounds(10,150,600,30);
        add(muestraResultados);
        add(labelComparar);
        label = new JLabel("Consola de resultados");
        label.setBounds(10,170,200,30);
        add(label);
        consola = new JTextArea();
        scroll = new JScrollPane(consola);
        scroll.setBounds(10,210,570,250);
        add(scroll);
    }

    public void setOpcionesAlgoritos(){
        ButtonGroup bg=new ButtonGroup();
        radio1=new JRadioButton("Algoritmo BFS");
        radio1.addChangeListener(this);
        radio1.setBounds(10,1,120,20);
        add(radio1);
        radio5=new JRadioButton("Algoritmo BFS Mejorado");
        radio5.addChangeListener(this);
        radio5.setBounds(10,20,180,20);
        add(radio5);
        radio2=new JRadioButton("Algoritmo DFS");
        radio2.addChangeListener(this);
        radio2.setBounds(130,1,120,20);
        add(radio2);
        radio3=new JRadioButton("Algoritmo Branch And Bound");
        radio3.addChangeListener(this);
        radio3.setBounds(250,1,200,20);
        add(radio3);
        radio4=new JRadioButton("Algoritmo Dikjstra");
        radio4.addChangeListener(this);
        radio4.setBounds(450,1,250,20);
        add(radio4);
        radio2.addChangeListener(this);
        radio3.addChangeListener(this);
        radio4.addChangeListener(this);
        radio5.addChangeListener(this);
        bg.add(radio1);
        bg.add(radio2);
        bg.add(radio3);
        bg.add(radio4);
        bg.add(radio5);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==botonViajar){
            String origen=(String)comboBoxOrigen.getSelectedItem();
            String destino=(String)comboBoxDestino.getSelectedItem();
            String comparar=(String)comboBoxComparacion.getSelectedItem();
            MapBuilder.distancia = 0;
            long tiempoInicio=System.currentTimeMillis();
            if(opcionComparar == 1){
                System.out.print(MapBuilder.distancia);
                Boolean llego = MapBuilder.hasPathBfs(origen,destino);
                List<String> lista = new ArrayList<>();
                String Texto = "";
                lista.add("Total de Ciudades Visitadas: " + (MapBuilder.ciudadesRecorridas.size()-1));
                for(String recorrido : MapBuilder.ciudadesRecorridas){
                    lista.add(recorrido);
                }
                lista.add("Total de KM recorridos: " + MapBuilder.distancia);
                for(String impresion : lista){
                    Texto += impresion + "\n";
                }
                System.out.println(llego);
                consola.setText(Texto);
                muestraResultados.setText(imprimeResultados(nombreAlgoritmo,comparar,origen,destino,MapBuilder.distancia));
            }
            else if(opcionComparar == 2){
                System.out.print(MapBuilder.distancia);
                Boolean llego = MapBuilder.hasPathDfs(origen,destino);
                List<String> lista = new ArrayList<>();
                String Texto = "";
                lista.add("Total de Ciudades Visitadas: " + (MapBuilder.ciudadesRecorridas.size()-1));
                for(String recorrido : MapBuilder.ciudadesRecorridas){
                    lista.add(recorrido);
                }
                lista.add("Total de KM recorridos: " + MapBuilder.distancia);
                for(String impresion : lista){
                    Texto += impresion + "\n";
                }
                System.out.println(llego);
                consola.setText(Texto);
                muestraResultados.setText(imprimeResultados(nombreAlgoritmo,comparar,origen,destino,MapBuilder.distancia));
            }
            else if(opcionComparar == 5){
                //System.out.print(MapBuilder.distancia);
                MapBuilder.aux = MapBuilder.instance;
                MapBuilder.instance.ordenarRutas();
                Boolean llego = MapBuilder.hasPathBfsMejorado(origen,destino);
                List<String> lista = new ArrayList<>();
                String Texto = "";
                lista.add("Total de Ciudades Visitadas: " + (MapBuilder.ciudadesRecorridas.size()-1));
                for(String recorrido : MapBuilder.ciudadesRecorridas){
                    lista.add(recorrido);
                }
                MapBuilder.instance = MapBuilder.getGraph();
                lista.add("Total de KM recorridos: " + MapBuilder.distancia);
                for(String impresion : lista){
                    Texto += impresion + "\n";
                }
                System.out.println(llego);
                consola.setText(Texto);
                muestraResultados.setText(imprimeResultados(nombreAlgoritmo,comparar,origen,destino,MapBuilder.distancia));
            }
            else if(opcionComparar == 0)
            {
                //JOptionPane.showMessageDialog(null,"Selecciona un algoritmo","A caso usted mastica awa?",JOptionPane.WARNING_MESSAGE);
                JOptionPane.showMessageDialog(null,"Selecciona un algoritmo","A caso usted mastica awa?",JOptionPane.WARNING_MESSAGE);
            }
            long tiempoTermino=System.currentTimeMillis();
            consola.setText(consola.getText() + "\n Duracion de la ejecucion: " + (tiempoTermino - tiempoInicio) + "milidegundos");
        }
    }

    public String imprimeResultados(String nombreAlgoritmo,String nombreAlgoritmoComparar,String origen,String destino,Double distanciaOriginal){
        String resultados = "";
        switch (nombreAlgoritmoComparar){
            case "NINGUNO":
                resultados = "Distancia Recorrida por: " + nombreAlgoritmo + " " + MapBuilder.distancia + "Km";
            break;
            case "BFS":
                MapBuilder.distancia = 0 ;
                MapBuilder.hasPathBfs(origen,destino);
                resultados = "Distancia Recorrida por: " + nombreAlgoritmo + " " + distanciaOriginal + "Km Distancia Recorrida por: " + nombreAlgoritmoComparar + " " + MapBuilder.distancia + " Km";
            break;
            case "DFS":
                MapBuilder.distancia = 0 ;
                MapBuilder.hasPathDfs(origen,destino);
                resultados = "Distancia Recorrida por: " + nombreAlgoritmo + " " + distanciaOriginal + "Km Distancia Recorrida por: " + nombreAlgoritmoComparar + " " + MapBuilder.distancia + " Km";
            break;
        }
        return resultados ;
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
        /*
        if(itemEvent.getSource() == comboBoxComparacion){
            String seleccionado=(String)comboBoxComparacion.getSelectedItem();
            if(!seleccionado.equals("NINGUNO"))
            labelComparar.setText("Algoritmo Seleccionado: " + nombreAlgoritmo + " Comparar con: " + seleccionado);
        }
         */
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        if(radio1.isSelected()){
            opcionComparar = 1 ;
            nombreAlgoritmo = "BFS";
            labelComparar.setText("Algoritmo Seleccionado: " + nombreAlgoritmo);
            comboBoxComparacion.removeAllItems();
            comboBoxComparacion.addItem("NINGUNO");
            comboBoxComparacion.addItem("DFS");
            comboBoxComparacion.addItem("BRANCH AND BOUND");
            comboBoxComparacion.addItem("DIJKSTRA");
            comboBoxComparacion.addItem("BFS MEJORADO");
        }
        if(radio2.isSelected()){
            opcionComparar = 2 ;
            nombreAlgoritmo = "DFS";
            labelComparar.setText("Algoritmo Seleccionado: " + nombreAlgoritmo);
            comboBoxComparacion.removeAllItems();
            comboBoxComparacion.addItem("NINGUNO");
            comboBoxComparacion.addItem("BFS");
            comboBoxComparacion.addItem("BRANCH AND BOUND");
            comboBoxComparacion.addItem("DIJKSTRA");
            comboBoxComparacion.addItem("BFS MEJORADO");
        }
        if(radio3.isSelected()){
            opcionComparar = 3 ;
            nombreAlgoritmo = "BRANCH AND BOUND";
            labelComparar.setText("Algoritmo Seleccionado: " + nombreAlgoritmo);
            comboBoxComparacion.removeAllItems();
            comboBoxComparacion.addItem("NINGUNO");
            comboBoxComparacion.addItem("BFS");
            comboBoxComparacion.addItem("DFS");
            comboBoxComparacion.addItem("DIJKSTRA");
            comboBoxComparacion.addItem("BFS MEJORADO");
        }
        if(radio4.isSelected()) {
            opcionComparar = 4;
            nombreAlgoritmo = "DIJKSTRA";
            labelComparar.setText("Algoritmo Seleccionado: " + nombreAlgoritmo);
            comboBoxComparacion.removeAllItems();
            comboBoxComparacion.addItem("NINGUNO");
            comboBoxComparacion.addItem("BFS");
            comboBoxComparacion.addItem("DFS");
            comboBoxComparacion.addItem("BRANCH AND BOUND");
            comboBoxComparacion.addItem("BFS MEJORADO");
        }
        if(radio5.isSelected()) {
            opcionComparar = 5;
            nombreAlgoritmo = "BFS MEJORADO";
            labelComparar.setText("Algoritmo Seleccionado: " + nombreAlgoritmo);
            comboBoxComparacion.removeAllItems();
            comboBoxComparacion.addItem("NINGUNO");
            comboBoxComparacion.addItem("BFS");
            comboBoxComparacion.addItem("DFS");
            comboBoxComparacion.addItem("BRANCH AND BOUND");
            comboBoxComparacion.addItem("DIJKSTRA");
        }
    }

    public static void main(String args[]){
        new MenuPantallaAlgoritmos();
    }
}
