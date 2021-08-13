import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JLabel l1,l2;
    JButton b1;
    JPanel pane;

    Home(){
        setBounds(300,75,900,700);
        setLayout(null);
        JPanel pane = new JPanel();
        setContentPane(pane);
        setLayout(null);
        JLabel l1= new JLabel();
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,650, Image.SCALE_FAST);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0,0,900,650);
        pane.add(l2);

        JLabel l3 = new JLabel("Library");
        l3.setBounds(350, 80, 500, 100);
        l3.setFont(new Font("MV Boli", Font.BOLD, 100));
//        l1.setForeground(Color.WHITE);
        l3.setForeground(Color.ORANGE);
        l2.add(l3);

        JLabel l4 = new JLabel("Management");
        l4.setBounds(150, 230, 700, 100);
        l4.setFont(new Font("MV Boli", Font.BOLD, 100));
//        l1.setForeground(Color.WHITE);
        l4.setForeground(Color.ORANGE);
        l2.add(l4);

        JLabel l5 = new JLabel("System");
        l5.setBounds(350, 380, 400, 100);
        l5.setFont(new Font("MV Boli", Font.BOLD, 100));
//
        l5.setForeground(Color.ORANGE);
        l2.add(l5);


        b1 = new JButton("Next");
        b1.setFont(new Font("Verdana",Font.PLAIN,25));
        b1.setBounds(360,530,180,35);
        pane.add(b1);
        b1.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Home().setVisible(true);
    }


    public void actionPerformed(ActionEvent e1) {
        try {
            if(e1.getSource()==b1){
                new LoginUser1().setVisible(true);
                this.setVisible(false);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
