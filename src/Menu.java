import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem mi1,mi2,mi3;

    public Menu(){
        setLayout(new BorderLayout());
        mb=new JMenuBar();
        setJMenuBar(mb);
        menu1=new JMenu("Algoritmos de Busqueda");
        mb.add(menu1);
        mi1=new JMenuItem("Ir");
        mi1.addActionListener(this);
        menu1.add(mi1);
        JPanel container = new JPanel();
        container.setLayout(new GridLayout(6,0));
        JLabel label1 = new JLabel("Proyecto de Algoritmos de Busqueda",SwingConstants.CENTER);
        container.add(label1);
        container.add(new JLabel("Integrantes del equipo",SwingConstants.CENTER));
        container.add(new JLabel("Jesus Alberto Cervantes Medina",SwingConstants.CENTER));
        container.add(new JLabel("Luis Alfredo Esparragoza Elenes",SwingConstants.CENTER));
        container.add(new JLabel("Rosita del Carmen Guerrero Vazquez",SwingConstants.CENTER));
        add(container,BorderLayout.CENTER);
        add(new JLabel("    "),BorderLayout.EAST);
        add(new JLabel("    "),BorderLayout.WEST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Container f=this.getContentPane();
        if (e.getSource()==mi1) {
            new PantallaAlgoritmos();
            this.dispose();
        }
    }

    public static void main(String[] ar) {
        Menu formulario1=new Menu();
        formulario1.setTitle("Proyecto de Inteligencia Artificial");
        formulario1.setBounds(10,20,500,200);
        formulario1.setVisible(true);
        formulario1.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
