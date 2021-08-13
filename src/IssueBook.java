import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IssueBook extends JFrame implements ActionListener {
     JPanel contentPane;
     JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
     JDateChooser dateChooser;
     JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
     JButton b1,b2,b3,b4;

     public IssueBook(){
         setTitle("Issue Books");
         setBounds(350,200,910,450);
         contentPane = new JPanel();
         setContentPane(contentPane);
         contentPane.setLayout(null);

         JLabel l1 = new JLabel("Book ID");
         l1.setBounds(50,70,100,25);
         contentPane.add(l1);

         t1 = new JTextField(20);
         t1.setBounds(145,70,130,25);
         contentPane.add(t1);

         JLabel l2 = new JLabel("Name");
         l2.setBounds(50,100,100,25);
         contentPane.add(l2);

         t2 = new JTextField(20);
         t2.setBounds(145,100,130,25);
         contentPane.add(t2);

         JLabel l3 = new JLabel("ISBN");
         l3.setBounds(50,130,100,25);
         contentPane.add(l3);

         t3 = new JTextField(20);
         t3.setBounds(145,130,130,25);
         contentPane.add(t3);

         JLabel l4 = new JLabel("Author");
         l4.setBounds(50,160,100,25);
         contentPane.add(l4);

         t4 = new JTextField(15);
         t4.setBounds(145,160,130,25);
         contentPane.add(t4);

         JLabel l5 = new JLabel("Category");
         l5.setBounds(50,190,100,25);
         contentPane.add(l5);

         t5 = new JTextField(15);
         t5.setBounds(145,190,130,25);
         contentPane.add(t5);

         b1 = new JButton("Search");
         b1.setBounds(300,70,100,30);
         b1.setBackground(Color.BLUE);
         b1.setForeground(Color.WHITE);
         contentPane.add(b1);
         b1.addActionListener(this);

         JPanel p1 = new JPanel();
         p1.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 200), 3),"Book Details",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(71,96,114)));
         p1.setBounds(10,20,400,225);
         p1.setBackground(new Color(171, 201, 222));
         contentPane.add(p1);

         JLabel l6 = new JLabel("Student ID");
         l6.setBounds(500,70,100,25);
         contentPane.add(l6);

         t6 = new JTextField(20);
         t6.setBounds(620,70,130,25);
         contentPane.add(t6);

         JLabel l7 = new JLabel("Name");
         l7.setBounds(500,100,100,25);
         contentPane.add(l7);

         t7 = new JTextField(20);
         t7.setBounds(620,100,130,25);
         contentPane.add(t7);

         JLabel l8 = new JLabel("Phone No");
         l8.setBounds(500,130,100,25);
         contentPane.add(l8);

         t8 = new JTextField(20);
         t8.setBounds(620,130,130,25);
         contentPane.add(t8);

         JLabel l9 = new JLabel("Course");
         l9.setBounds(500,160,100,25);
         contentPane.add(l9);

         t9 = new JTextField(20);
         t9.setBounds(620,160,130,25);
         contentPane.add(t9);

         JLabel l10 = new JLabel("Semester");
         l10.setBounds(500,190,100,25);
         contentPane.add(l10);

         t10 = new JTextField(20);
         t10.setBounds(620,190,130,25);
         contentPane.add(t10);

         b2 = new JButton("Search");
         b2.setBounds(775,70,100,30);
         b2.setBackground(Color.BLUE);
         b2.setForeground(Color.WHITE);
         contentPane.add(b2);
         b2.addActionListener(this);

         JPanel p2 = new JPanel();
         p2.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 200), 3),"Student Details",TitledBorder.TRAILING,TitledBorder.BOTTOM,null,new Color(71,96,114)));
         p2.setBounds(425,20,460,225);
         p2.setBackground(new Color(171, 201, 222));
         contentPane.add(p2);

         JLabel l11 = new JLabel("Date of Issue");
         l11.setBounds(290,270,100,25);
         l11.setFont(new Font("Verdana",Font.BOLD,13));
         contentPane.add(l11);

         dateChooser = new JDateChooser();
         dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
         dateChooser.setForeground(new Color(105, 105, 105));
         dateChooser.setBounds(400, 267, 200, 29);
         contentPane.add(dateChooser);

         b3 = new JButton("Issue");
         b3.setBounds(325,325,100,30);
         b3.setFont(new Font("Verdana",Font.PLAIN,14));
         b3.setBackground(Color.BLUE);
         b3.setForeground(Color.WHITE);
         contentPane.add(b3);
         b3.addActionListener(this);

         b4 = new JButton("Back");
         b4.setBounds(450,325,100,30);
         b4.setBackground(Color.BLUE);
         b4.setForeground(Color.WHITE);
         contentPane.add(b4);
         b4.addActionListener(this);

         setLayout(null);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         contentPane.setBackground(new Color(171, 201, 222));
     }
    public void actionPerformed(ActionEvent e8) {
        try {
            Connection1 c1 = new Connection1();
            if(e8.getSource()==b4){
                this.setVisible(false);
                new Page1().setVisible(true);
            }
            if(e8.getSource()==b1){
                String s4 = "SELECT * from book where book_id=?";
                PreparedStatement st = Connection1.connect1.prepareStatement(s4);
                st.setString(1,t1.getText());
                ResultSet rs4 = st.executeQuery();

                while (rs4.next()){
                    t2.setText(rs4.getString("name1"));
                    t3.setText(rs4.getString("isbn"));
                    t4.setText(rs4.getString("Author"));
                    t5.setText(rs4.getString("Category"));
                }


            }
            if(e8.getSource()==b2){
                String s5 = "SELECT * from student where student_id=?";
                PreparedStatement st = Connection1.connect1.prepareStatement(s5);
                st.setString(1,t6.getText());
                ResultSet rs5 = st.executeQuery();
                while (rs5.next()){
                    t7.setText(rs5.getString("name2"));
                    t8.setText(rs5.getString("phone"));
                    t9.setText(rs5.getString("course"));
                    t10.setText(rs5.getString("semester"));
                }
            }
            if(e8.getSource()==b3){
                try {
                    String s6 = "insert into issue(book_id,student_id,bname,sname,course,dateofissue) values(?,?,?,?,?,?)";
                    PreparedStatement st = Connection1.connect1.prepareStatement(s6);
                    st.setString(1,t1.getText());
                    st.setString(2,t6.getText());
                    st.setString(3,t2.getText());
                    st.setString(4,t7.getText());
                    st.setString(5,t9.getText());
                    st.setString(6, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
                    int r1=st.executeUpdate();
                    if (r1>0){
                        JOptionPane.showMessageDialog(null,"Book Issued!!!");
                    }
                    else{JOptionPane.showMessageDialog(null,"error");}
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new IssueBook().setVisible(true);
    }


}
