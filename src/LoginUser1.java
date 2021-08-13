import com.mysql.jdbc.log.Log;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;
import java.sql.ResultSet;

public class LoginUser1 extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l11, l12;
    JPanel contentpanel;
    JTextField t1;
    JPasswordField p1;
    JButton b1, b2, b3;

    LoginUser1() {
        setTitle("Login");

        contentpanel = new JPanel();
        setContentPane(contentpanel);
        contentpanel.setBackground(new Color(171, 201, 222));
        contentpanel.setLayout(null);
        contentpanel.setBorder(new EmptyBorder(5, 5, 5, 5));


        l1 = new JLabel("Username");
        l1.setBounds(80, 95, 100, 20);
        l1.setFont(new Font("Verdana", Font.BOLD, 15));
        contentpanel.add(l1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login12.png"));
        Image i2 = i1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(65, 20, 60, 60);
//        l11.setForeground(new Color(15,82,186));
        contentpanel.add(l11);
        l12 = new JLabel("Library v1.1");
        l12.setBounds(140, 30, 270, 40);
        l12.setFont(new Font("MV Boli", Font.BOLD, 40));
//        l12.setForeground(new Color(44, 27, 156));
        contentpanel.add(l12);
        t1 = new JTextField(15);
        t1.setBounds(180, 95, 150, 20);
        contentpanel.add(t1);

        l2 = new JLabel("Password");
        l2.setFont(new Font("Verdana", Font.BOLD, 15));
        l2.setBounds(80, 125, 150, 20);
        contentpanel.add(l2);

        p1 = new JPasswordField(15);
        p1.setBounds(180, 125, 150, 20);
        contentpanel.add(p1);

        b1 = new JButton("Log in");
        b1.setBounds(140, 160, 100, 30);
        b1.setFont(new Font("Verdana", Font.BOLD, 11));
        contentpanel.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Sign Up");
        b2.setBounds(250, 160, 100, 30);
        b2.setFont(new Font("Verdana", Font.BOLD, 11));
        contentpanel.add(b2);
        b2.addActionListener(this);

        b3 = new JButton("Forget Password");
        b3.setBounds(165, 200, 140, 30);
        b3.setFont(new Font("Verdana", Font.BOLD, 11));
        contentpanel.add(b3);
        b3.addActionListener(this);

        JPanel panel = new JPanel();

        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2)));
        panel.setBackground(new Color(171, 201, 222));
        panel.setBounds(5, 5, 420, 245);
        contentpanel.add(panel);


        setLayout(null);
        setBounds(600, 200, 445, 295);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) {
        new LoginUser1().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e1) {
        try {
            if (e1.getSource() == b1) {
                Connection1 c1 = new Connection1();
                String u1 = t1.getText();
                String pf1 = p1.getText();
                String q = "select * from student where username='" + u1 + "' and password2='" + pf1 + "'";
                ResultSet rs = c1.st.executeQuery(q); // query execute
//                String q = "Select * from login1 where username=? and password=?";
//                PreparedStatement st1=Connection1.c1.
                if (rs.next()) {
                    setVisible(false);
                    new Loading().setVisible(true);
//                    new Page1().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                }
            }
            if (e1.getSource() == b2) {
                setVisible(true);
                new AddUser().setVisible(true);

            }
            if(e1.getSource()==b3){
                setVisible(false);
                new ForgotPass().setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}