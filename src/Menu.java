import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem mi1,mi2,mi3;

    public Menu(){
        setLayout(null);
        mb=new JMenuBar();
        setJMenuBar(mb);
        menu1=new JMenu("Algoritmos de Busqueda");
        mb.add(menu1);
        mi1=new JMenuItem("BFS");
        mi1.addActionListener(this);
        menu1.add(mi1);
        mi2=new JMenuItem("DFS");
        mi2.addActionListener(this);
        menu1.add(mi2);
        mi3=new JMenuItem("Branch and Bound");
        mi3.addActionListener(this);
        menu1.add(mi3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Container f=this.getContentPane();
        if (e.getSource()==mi1) {
            //f.setBackground(new Color(255,0,0));
        }
        if (e.getSource()==mi2) {
            //f.setBackground(new Color(0,255,0));
        }
        if (e.getSource()==mi3) {
            //f.setBackground(new Color(0,0,255));
        }
    }

    public static void main(String[] ar) {
        Menu formulario1=new Menu();
        formulario1.setTitle("Proyecto de Inteligencia Artificial");
        formulario1.setBounds(10,20,300,200);
        formulario1.setVisible(true);
        formulario1.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
