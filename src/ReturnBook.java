import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReturnBook extends JFrame implements ActionListener {
    JPanel panel;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JDateChooser dateChooser;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    JButton b1,b2,b3,b4;

    ReturnBook(){
        setTitle("Return Book");
        setBounds(500,250,765,330);
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(171, 201, 222));

        JLabel l1 = new JLabel("Book ID");
        l1.setBounds(50,70,100,25);
        panel.add(l1);

        t1 = new JTextField(20);
        t1.setBounds(145,70,130,25);
        panel.add(t1);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(50,110,100,25);
        panel.add(l2);

        t2 = new JTextField(20);
        t2.setBounds(145,110,130,25);
        panel.add(t2);

        JLabel l3 = new JLabel("Student ID");
        l3.setBounds(450,70,100,25);
        panel.add(l3);

        t3 = new JTextField(20);
        t3.setBounds(570,70,130,25);
        panel.add(t3);

        JLabel l4 = new JLabel("Name");
        l4.setBounds(450,110,100,25);
        panel.add(l4);

        t4 = new JTextField(15);
        t4.setBounds(570,110,130,25);
        panel.add(t4);

        JLabel l5 = new JLabel("Date of Issue");
        l5.setBounds(50,150,100,25);
        panel.add(l5);

        t5 = new JTextField(15);
        t5.setBounds(145,150,130,25);
        panel.add(t5);

        JLabel l6 = new JLabel("Date of Return");
        l6.setBounds(450,150,100,25);
        panel.add(l6);

        dateChooser = new JDateChooser();
        dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(570, 147, 150, 29);
        panel.add(dateChooser);

        b1 = new JButton("Search");
        b1.setBounds(300,70,100,30);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Return");
        b2.setBounds(250,190,100,30);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        panel.add(b2);
        b2.addActionListener(this);

        b3 = new JButton("Back");
        b3.setBounds(400,190,100,30);
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.WHITE);
        panel.add(b3);
        b3.addActionListener(this);

        JPanel p1 = new JPanel();
        p1.setBorder(new TitledBorder(new LineBorder(new Color(175, 128, 150), 3),"Return",TitledBorder.TRAILING,TitledBorder.BOTTOM,null,new Color(71,96,114)));
        p1.setBounds(10,10,730,269);
        p1.setBackground(new Color(171, 201, 222));
        panel.add(p1);

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent e9) {
        try {
            Connection1 c1 = new Connection1();
            if(e9.getSource()==b1){
                String s6 = "SELECT * from issue where book_id=?";
                PreparedStatement st = Connection1.connect1.prepareStatement(s6);
                st.setString(1,t1.getText());
                ResultSet rs5 = st.executeQuery();
                while (rs5.next()){
                    t2.setText(rs5.getString("bname"));
                    t3.setText(rs5.getString("student_id"));
                    t4.setText(rs5.getString("sname"));
                    t5.setText(rs5.getString("dateofissue"));
                }

            }
            if(e9.getSource()==b2){
                String s7 = "insert into return1(book_id,student_id,bname,sname,dateofissue,dateofreturn) values(?,?,?,?,?,?)";
                PreparedStatement st = Connection1.connect1.prepareStatement(s7);
                st.setString(1,t1.getText());
                st.setString(2,t3.getText());
                st.setString(3,t2.getText());
                st.setString(4,t4.getText());
                st.setString(5,t5.getText());
                st.setString(6, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
                int r2=st.executeUpdate();
                if (r2>0){
                    JOptionPane.showMessageDialog(null,"Book Returned!!!");
                }
                else{JOptionPane.showMessageDialog(null,"error");}
            }
            if(e9.getSource()==b3){
                setVisible(false);
                new Page1().setVisible(true);
            }
        }
        catch (Exception e){e.printStackTrace();}
    }

    public static void main(String[] args) {
        new ReturnBook().setVisible(true);
    }



}
