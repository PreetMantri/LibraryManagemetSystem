import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;


public class AddBooks extends JFrame implements ActionListener {
    JPanel panel;
    JLabel l1,l11,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4;
    JButton b1,b2,b3;
    JComboBox comboBox;
    Random rand = new Random();
    int rand_int1 = rand.nextInt(1000);
    int rand_int2 = rand.nextInt(10000);
    AddBooks(){

        setTitle("Add Books");
        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setBackground(new Color(171, 201, 222));
        panel.setLayout(null);

        JLabel l11 = new JLabel("Book Details");
        l11.setBounds(120,30,300,35);
        l11.setForeground(new Color(71,96,114));
        l11.setFont(new Font("MV Boli",Font.BOLD,35));
        panel.add(l11);
        JLabel l1= new JLabel("Book ID");
        l1.setBounds(100,75,100,20);
        panel.add(l1);

        t1 = new JTextField(""+rand_int1,15);
        t1.setBounds(200, 75, 150, 20);
        panel.add(t1);

        JLabel l2= new JLabel("Name");
        l2.setBounds(100,100,100,20);
        panel.add(l2);

        t2 = new JTextField(20);
        t2.setBounds(200, 100, 150, 20);
        panel.add(t2);

        JLabel l3= new JLabel("ISBN");
        l3.setBounds(100,125,100,20);
        panel.add(l3);

        t3 = new JTextField(""+rand_int2,15);
        t3.setBounds(200, 125, 150, 20);
        panel.add(t3);

        JLabel l4= new JLabel("Author");
        l4.setBounds(100,150,100,20);
        panel.add(l4);

        t4 = new JTextField(15);
        t4.setBounds(200, 150, 150, 20);
        panel.add(t4);

        JLabel l5= new JLabel("Category");
        l5.setBounds(100,175,100,20);
        panel.add(l5);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Action & Adventure","Detective & Mystery","Science FIction","Biographies","Computers & Tech"}));
        comboBox.setBounds(200,175,190,20);
        panel.add(comboBox);
        b1 = new JButton("Add");
        b1.setBounds(150,200,100,25);
        panel.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Back");
        b2.setBounds(275,200,100,25);
        panel.add(b2);
        b2.addActionListener(this);

        JPanel p1 = new JPanel();
        p1.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 3),"Add Books",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(71,96,114)));
        p1.setBounds(5, 5, 495, 300);
        p1.setBackground(new Color(171, 201, 222));
        panel.add(p1);

        setBounds(550,200,525,345);

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new AddBooks().setVisible(true);
    }

    public void actionPerformed(ActionEvent e2) {
        try{
            if(e2.getSource()==b1){
                Connection1 c1 = new Connection1();
                String g1=t1.getText();
                String n =t2.getText();
                String i = t3.getText();
                String i1 = t4.getText();
                String c3= (String) comboBox.getSelectedItem();
                String s1 = "insert into book(book_id,name1,isbn,Author,Category) values('"+g1+"','"+n+"','"+i+"','"+i1+"','"+c3+"')";
                int rs=c1.st.executeUpdate(s1);
                if(rs>0){JOptionPane.showMessageDialog(null,"Successfully Added!!!");}
                else{JOptionPane.showMessageDialog(null,"Error");}



            }
            else if(e2.getSource()==b2){
                this.setVisible(false);
                new Page1().setVisible(true);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
