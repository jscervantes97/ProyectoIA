import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaAlgoritmos extends JFrame implements ActionListener, ChangeListener {

    private JComboBox comboBoxOrigen ;
    private JComboBox comboBoxDestino ;
    private JButton boton1;
    public PantallaAlgoritmos(){
        super("Algoritmos de Busqueda");
        setBounds(300,300,500,500);
        setLayout(new BorderLayout());
        creaNorte();
        creaCentro();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void creaNorte(){
        JPanel container = new JPanel();
        container.setLayout(new GridLayout(1,4));
        ButtonGroup bg=new ButtonGroup();
        JRadioButton radio1=new JRadioButton("Algoritmo BFS");
        radio1.addChangeListener(this);
        container.add(radio1);
        JRadioButton radio2=new JRadioButton("Algoritmo DFS");
        container.add(radio2);
        JRadioButton radio3=new JRadioButton("Algoritmo Branch And Bound");
        container.add(radio3);
        JRadioButton radio4=new JRadioButton("Algoritmo Dikjstra");
        container.add(radio4);
        bg.add(radio1);
        bg.add(radio2);
        bg.add(radio3);
        bg.add(radio4);
        add(container,BorderLayout.NORTH);
    }

    public void creaCentro(){
        JPanel container = new JPanel();
        container.setLayout(new GridLayout(5,2));
        container.add(new JLabel("Ciudad Origen"));
        comboBoxOrigen = new JComboBox();
        Graph grafo1 = MapBuilder.getGraph();
        grafo1.getNodes().forEach(item ->{
                comboBoxOrigen.addItem(item.getCity());
        });
        container.add(comboBoxOrigen);
        container.add(new JLabel("Ciudad Destino"));
        comboBoxDestino = new JComboBox();
        container.add(comboBoxDestino);
        boton1 = new JButton("Viajar");
        boton1.addActionListener(this);
        container.add(boton1);
        container.add(new JLabel("    "));
        add(container,BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {

    }
}
