import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PantallaAlgoritmos extends JFrame implements ActionListener, ChangeListener, ItemListener {
    public static Integer opcionComparar = 0;
    private JComboBox comboBoxOrigen ;
    private JComboBox comboBoxDestino ;
    private TextArea consola;
    JRadioButton radio1,radio2,radio3,radio4;
    private JButton botonViajar,botonComparar;
    private Integer Opcion = 0 ;
    private Graph grafo1 = MapBuilder.getGraph();
    public PantallaAlgoritmos(){
        super("Algoritmos de Busqueda");
        setBounds(300,300,500,500);
        setLayout(new BorderLayout());
        creaNorte();
        creaCentro();
        //creaConsola();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void creaNorte(){
        JPanel container = new JPanel();
        container.setLayout(new GridLayout(1,4));
        ButtonGroup bg=new ButtonGroup();
        radio1=new JRadioButton("Algoritmo BFS");
        radio1.addChangeListener(this);
        container.add(radio1);
        radio2=new JRadioButton("Algoritmo DFS");
        container.add(radio2);
        radio3=new JRadioButton("Algoritmo Branch And Bound");
        container.add(radio3);
        radio4=new JRadioButton("Algoritmo Dikjstra");
        container.add(radio4);
        radio2.addChangeListener(this);
        radio3.addChangeListener(this);
        radio4.addChangeListener(this);
        bg.add(radio1);
        bg.add(radio2);
        bg.add(radio3);
        bg.add(radio4);
        add(container,BorderLayout.NORTH);
    }

    public void creaCentro(){
        JPanel container = new JPanel();
        container.setLayout(new GridLayout(5,2));
        container.add(new JLabel("Ciudad Origen:"));
        comboBoxOrigen = new JComboBox();
        grafo1.getNodes().forEach(item ->{
                comboBoxOrigen.addItem(item.getCity());
        });
        comboBoxOrigen.addItemListener(this);
        container.add(comboBoxOrigen);
        container.add(new JLabel("Ciudad Destino:"));
        comboBoxDestino = new JComboBox();
        container.add(comboBoxDestino);
        botonComparar = new JButton("Comparar Con");
        botonComparar.addActionListener(this);
        container.add(botonComparar);
        botonViajar = new JButton("Viajar");
        botonViajar.addActionListener(this);
        //container.add(botonViajar);
        container.add(creaConsola());
        //container.setPreferredSize(container.getMaximumSize());
        add(container,BorderLayout.CENTER);
    }

    public JPanel creaConsola(){
        JPanel container2 = new JPanel();
        container2.setLayout(new GridLayout(3,0));
        container2.add(new JLabel("Consola de Resultados: "));
        consola = new TextArea();
        container2.add(consola);
        container2.add(new JLabel("Hola ---- aqui pondre alguna wea"));
        //container2.setPreferredSize(container2.getPreferredSize());
        //container.setPreferredSize(container);
        //add(container2,BorderLayout.SOUTH);
        return container2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        if(radio1.isSelected()){
            Opcion = 1 ;
        }
        else if(radio2.isSelected()){
            Opcion = 2 ;
        }
        else if(radio3.isSelected()){
            Opcion = 3 ;
        }
        else if(radio4.isSelected()){
            Opcion = 4 ;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        if (itemEvent.getSource()==comboBoxOrigen) {
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
    }
}
