import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddUser extends JFrame implements ActionListener {
    JPanel panel;
    JLabel l1,l11,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JPasswordField p1,p2;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    JComboBox comboBox,comboBox1,comboBox2;
    Random rand = new Random();

    int rand_int1 = rand.nextInt(1000);
    int rand_int2 = rand.nextInt(1000000000);
    AddUser(){
        setTitle("Add Student");
        JPanel panel = new JPanel();
        setContentPane(panel);

        JLabel l1= new JLabel("Student ID");
        l1.setBounds(100,50,100,20);
        panel.add(l1);

        t1 = new JTextField(""+rand_int1,15);
        t1.setBounds(200, 50, 150, 20);
        panel.add(t1);

        JLabel l2= new JLabel("Name");
        l2.setBounds(100,75,100,20);
        panel.add(l2);

        t2 = new JTextField(15);
        t2.setBounds(200, 75, 150, 20);
        panel.add(t2);

        JLabel l10= new JLabel("UserName");
        l10.setBounds(100,100,100,20);
        panel.add(l10);

        t5 = new JTextField(15);
        t5.setBounds(200, 100, 150, 20);
        panel.add(t5);

        JLabel l3= new JLabel("Phone No.:");
        l3.setBounds(100,125,100,20);
        panel.add(l3);

        t3 = new JTextField(""+rand_int2,15);
        t3.setBounds(200, 125, 150, 20);
        panel.add(t3);

        JLabel l4= new JLabel("Course");
        l4.setBounds(100,150,100,20);
        panel.add(l4);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"B.E","B.Tech","M.Tech","MBA","BSc","Diploma"}));
        comboBox.setBounds(200,150,150,20);
        panel.add(comboBox);

        JLabel l5= new JLabel("Semester");
        l5.setBounds(100,175,100,20);
        panel.add(l5);

        comboBox1 = new JComboBox();
        comboBox1.setModel(new DefaultComboBoxModel(new String[]{"1","2","3","4","5","6","7","8"}));
        comboBox1.setBounds(200,175,150,20);
        panel.add(comboBox1);

        JLabel l6= new JLabel("Password");
        l6.setBounds(100,200,100,20);
        panel.add(l6);

        p1 = new JPasswordField(15);
        p1.setBounds(200, 200, 150, 20);
        panel.add(p1);

        JLabel l7= new JLabel("Confirm Password");
        l7.setBounds(50,225,150,20);
        panel.add(l7);

        p2 = new JPasswordField(15);
        p2.setBounds(200, 225, 150, 20);
        panel.add(p2);

        JLabel l8= new JLabel("Security Question");
        l8.setBounds(50,250,150,20);
        panel.add(l8);

        comboBox2 = new JComboBox();
        comboBox2.setModel(new DefaultComboBoxModel(new String[]{"Your Favourite Hero?","Your Nickname?","Your first pet?","Your HomeTown?"}));
        comboBox2.setBounds(200,250,150,20);
        panel.add(comboBox2);

        JLabel l9= new JLabel("Answer");
        l9.setBounds(100,275,100,20);
        panel.add(l9);

        t4 = new JTextField(15);
        t4.setBounds(200, 275, 150, 20);
        panel.add(t4);

        b1 = new JButton("Add");
        b1.setBounds(150,305,100,25);
        panel.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Back");
        b2.setBounds(275,305,100,25);
        panel.add(b2);
        b2.addActionListener(this);
        JPanel p1 = new JPanel();
        p1.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 3),"Add User",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(71,96,114)));
        p1.setBounds(5, 5, 495, 335);
        p1.setBackground(new Color(171, 201, 222));
        panel.add(p1);



        setBounds(550,200,525,400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setBackground(new Color(171, 201, 222));

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e5) {
        try{
            if(e5.getSource()==b1){//Add
                setVisible(false);
                Connection1 c1 = new Connection1();
                String g1=t1.getText();
                String n =t2.getText();
                String n1=t5.getText();
                String i = t3.getText();
                String c2= (String) comboBox.getSelectedItem();
                String c3= (String) comboBox1.getSelectedItem();
                String i1 = p1.getText();
                String c4= (String) comboBox2.getSelectedItem();
                String i2 = t4.getText();
                String s2 = "insert into student(student_id,name2,username,phone,course,semester,password2,securityq,securityans) values('"+g1+"','"+n+"','"+n1+"','"+i+"','"+c2+"','"+c3+"','"+i1+"','"+c4+"','"+i2+"');";
                int rs1=c1.st.executeUpdate(s2);
                if(rs1>0){JOptionPane.showMessageDialog(null,"Susscessfully Added!!!");
                new LoginUser1().setVisible(true);}
                else{JOptionPane.showMessageDialog(null,"Error");
                new ForgotPass().setVisible(true);}
            }
            else if(e5.getSource()==b2){
                setVisible(false);
                new Page1().setVisible(true);
            }
        }
        catch (Exception e){e.printStackTrace();}

    }
    public static void main(String[] args) {
        new AddUser();
    }

}
