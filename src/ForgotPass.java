import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ForgotPass extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5;
    JTextField t11,t1,t2,t3,t4,t5;
    JPanel p1;
    JPasswordField pf1;
    JButton b1,b2,b3,b4;

    ForgotPass(){
        setTitle("Forgot Password");
        JPanel p1= new JPanel();
        setContentPane(p1);

        p1.setBackground(new Color(171, 201, 222));


        JLabel l11= new JLabel("Username");
        l11.setBounds(50,25,100,20);
        p1.add(l11);

        t11 = new JTextField(15);
        t11.setBounds(200, 25, 150, 20);
        p1.add(t11);

        JLabel l1= new JLabel("Student ID");
        l1.setBounds(50,60,100,20);
        p1.add(l1);

        t1 = new JTextField(15);
        t1.setBounds(200, 60, 150, 20);
        p1.add(t1);

        JLabel l2= new JLabel("Name");
        l2.setBounds(50,95,100,20);
        p1.add(l2);

        t2 = new JTextField(15);
        t2.setBounds(200, 95, 150, 20);
        t2.setEditable(false);
        t2.setBackground(Color.lightGray);
        p1.add(t2);

        JLabel l3= new JLabel("Your Security Question");
        l3.setBounds(50,130,200,20);
        p1.add(l3);

        t3 = new JTextField(15);
        t3.setBounds(200, 130, 150, 20);
        t3.setEditable(false);
        t3.setBackground(Color.lightGray);
        p1.add(t3);

        JLabel l4= new JLabel("Answer");
        l4.setBounds(50,165,100,20);
        p1.add(l4);

        t4 = new JTextField(15);
        t4.setBounds(200, 165, 150, 20);
        p1.add(t4);

        JLabel l5= new JLabel("Password");
        l5.setBounds(50,195,150,20);
        p1.add(l5);

        t5 = new JTextField(15);
        t5.setBounds(200, 195, 150, 20);
        p1.add(t5);

        b1 = new JButton("Change");
        b1.setBounds(80,225,80,25);
        b1.setBackground(new Color(125, 237, 255));
        b1.setFont(new Font("MV Boli",Font.PLAIN,14));
        p1.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Clear");
        b2.setBounds(170,225,80,25);
        b2.setBackground(new Color(125, 237, 255));
        b2.setFont(new Font("MV Boli",Font.PLAIN,14));
        p1.add(b2);
        b2.addActionListener(this);

        b3 = new JButton("Back");
        b3.setBounds(150,260,80,25);
        b3.setBackground(new Color(125, 237, 255));
        b3.setFont(new Font("MV Boli",Font.PLAIN,14));
        p1.add(b3);
        b3.addActionListener(this);

        b4 = new JButton("Search");
        b4.setBounds(260,225,80,25);
        b4.setBackground(new Color(125, 237, 255));
        b4.setFont(new Font("MV Boli",Font.PLAIN,14));
        p1.add(b4);
        b4.addActionListener(this);

        JPanel p2 = new JPanel();
        p2.setBorder(new TitledBorder(new LineBorder(new Color(124, 50, 253), 3)));
        p2.setBounds(5, 5, 375, 335);
//        p2.setBackground(new Color(50,130,200));
        p1.add(p2);



        setLayout(null);
        setBounds(600,200,400,390);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ForgotPass();
    }


    public void actionPerformed(ActionEvent e7) {
        try {Connection1 c1 = new Connection1();
            if(e7.getSource()==b4){

                String s3 = "SELECT * from student where student_id=? or username=?";
                PreparedStatement st = Connection1.connect1.prepareStatement(s3);
                st.setString(1,t1.getText());
                st.setString(2,t11.getText());
//                String u1=t1.getText();
//                String s3="SELECT * from student where username ='"+u1+"';";
                ResultSet rs3 = st.executeQuery();

                while (rs3.next()){
                    t2.setText(rs3.getString("name2"));
                    t3.setText(rs3.getString("securityq"));
                    t1.setText(rs3.getString("student_id"));
                    t11.setText(rs3.getString("username"));
                }

            }
            if(e7.getSource()==b2){
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t11.setText("");




            }
            if (e7.getSource()==b1){
                try {
                    String s31 = "UPDATE student SET password2=? where student_id=? and securityans=?";
                    PreparedStatement st = Connection1.connect1.prepareStatement(s31);
                    st.setString(1, t5.getText());
                    st.setString(2, t1.getText());
                    st.setString(3, t4.getText());
                    int rs5 = st.executeUpdate();
                    if (rs5 > 0) {
                        JOptionPane.showMessageDialog(null, "Password Changed!!!");
                        setVisible(false);
                        LoginUser1 log1 = new LoginUser1();
                        log1.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error!!!");
                    }
                }
                catch (Exception e){e.printStackTrace();}



//                    String s32 = "UPDATE student SET password1=? where student_id=?;";
//                    PreparedStatement st1 = Connection1.connect1.prepareStatement(s31);
//                    st.setString(1,t5.getText());
//                    st.setString(2,t1.getText());
//                    int rs6=st1.executeUpdate();
//
            }

            if(e7.getSource()==b3){
                setVisible(false);
                new LoginUser1().setVisible(true);
            }
        }
        catch (Exception e){e.printStackTrace();}
    }
}
