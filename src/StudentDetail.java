import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDetail extends JFrame implements ActionListener {
    JPanel panel;
    JButton b1, b2, b3, b4;
    JTable table;
    JTextField t1, t2, t3, t4;

    StudentDetail(){
        setTitle("Student Details");
        setBounds(300, 200, 900, 500);
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(171, 201, 222));

        JScrollPane scroll1 = new JScrollPane();
        scroll1.setBounds(80, 140, 770, 300);
        panel.add(scroll1);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                t1.setText(table.getModel().getValueAt(row, 1).toString());
            }
        });
        table.setBackground(new Color(54, 161, 179));
        scroll1.setViewportView(table);

        b1 = new JButton("Search");
        b1.setBounds(600, 80, 100, 30);
        b1.setFont(new Font("Verdana", Font.BOLD, 11));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/search3.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20, 1);
        ImageIcon i3 = new ImageIcon(i2);
        b1.setIcon(i3);
        panel.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Delete");
        b2.setBounds(725, 80, 100, 30);
        b2.setFont(new Font("Verdana", Font.BOLD, 11));
        panel.add(b2);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/delete user.png"));
        Image i5 = i4.getImage().getScaledInstance(20,20, 1);
        ImageIcon i6 = new ImageIcon(i5);
        b2.setIcon(i6);
        b2.addActionListener(this);

        JLabel l1 = new JLabel("Student Details");
        l1.setBounds(300, 30, 400, 40);
        l1.setFont(new Font("MV Boli", Font.BOLD, 40));
//        l1.setForeground(Color.WHITE);
        l1.setBackground(Color.BLUE);
        panel.add(l1);

        t1 = new JTextField(20);
        t1.setBounds(200, 80, 300, 40);
//        t1.setEditable(false);
        panel.add(t1);

        JLabel l3 = new JLabel("Back");
        l3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                Page1 page2 = new Page1();

                page2.setVisible(true);
            }
        });
        l3.setBounds(100, 80, 100, 30);
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/back2.png"));
        Image i8 = i7.getImage().getScaledInstance(20,20, 1);
        ImageIcon i9 = new ImageIcon(i8);
        l3.setIcon(i9);
        panel.add(l3);
        Student();


        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e11) {
        try{
            Connection1 c1 = new Connection1();
            if (e11.getSource() == b1) {
                String s11 = "SELECT * from student where concat(name2, student_id) like ?";
                PreparedStatement st = Connection1.connect1.prepareStatement(s11);
                st.setString(1, "%" + t1.getText() + "%");
                ResultSet rs6 = st.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs6));
            }
            if (e11.getSource() == b2) {
                String s9 = "DELETE from student where name2= '" + t1.getText() + "'";
                PreparedStatement st = Connection1.connect1.prepareStatement(s9);
                JDialog.setDefaultLookAndFeelDecorated(true);
                int response = JOptionPane.showConfirmDialog(null, "Do yo want to delete?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.NO_OPTION) {
                } else if (response == JOptionPane.YES_OPTION) {
                    int rs8 = st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Deleted!!!");
                } else if (response == JOptionPane.CLOSED_OPTION) {
                }
                st.close();


            }
            Connection1.connect1.close();
        }

        catch (Exception e){e.printStackTrace();}
    }
    public void Student(){try {
        Connection1 c1 = new Connection1();
        String s9 = "SELECT student_id,name2,phone,course,semester from student";
        PreparedStatement st = Connection1.connect1.prepareStatement(s9);
        ResultSet rs7=st.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs7));
    }
    catch (Exception e){e.printStackTrace();}}

    public static void main(String[] args) {
        new StudentDetail().setVisible(true);
    }
}
