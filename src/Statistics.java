import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Statistics extends JFrame  {
    JPanel panel,p1,p2;
    JTable table,table2;
    JScrollPane scroll1,scroll2;
    JLabel l1,l2,l3;
    public void issue1(){try {
        Connection1 c1 = new Connection1();
        String s12 = "SELECT * from issue";
        PreparedStatement st = Connection1.connect1.prepareStatement(s12);
        ResultSet rs8=st.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs8));
    }

    catch (Exception e){e.printStackTrace();}}

    public void Return1(){try {
        Connection1 c1 = new Connection1();
        String s13 = "SELECT * from return1";
        PreparedStatement st = Connection1.connect1.prepareStatement(s13);
        ResultSet rs9=st.executeQuery();
        table2.setModel(DbUtils.resultSetToTableModel(rs9));
    }
    catch (Exception e){e.printStackTrace();}}

    Statistics(){
        setBounds(300,100,765,700);
        panel = new JPanel();
        panel.setBackground(new Color(171, 201, 222));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l1 = new JLabel("Statistics");
        l1.setBounds(300, 20, 400, 40);
        l1.setFont(new Font("MV Boli", Font.BOLD, 40));
//        l1.setForeground(Color.WHITE);
        l1.setBackground(Color.BLUE);
        panel.add(l1);

        JScrollPane scroll1 = new JScrollPane();
        scroll1.setBounds(25,90,700,250);
        panel.add(scroll1);

        table = new JTable();
        table.setBackground(new Color(54, 161, 179));
        scroll1.setViewportView(table);

        p1 = new JPanel();
        p1.setBorder(new TitledBorder(new LineBorder(new Color(175, 128, 150), 3),"Issue Details",TitledBorder.TRAILING,TitledBorder.TOP,null,new Color(71,96,114)));
        p1.setBounds(10,70,730,280);
        panel.add(p1);

        l3 = new JLabel("Back");
        l3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                Page1 page2 = new Page1();

                page2.setVisible(true);
            }
        });
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/back2.png"));
        Image i8 = i7.getImage().getScaledInstance(20,20, 1);
        ImageIcon i9 = new ImageIcon(i8);
        l3.setIcon(i9);
        l3.setBounds(20, 30, 100, 30);

        l3.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        panel.add(l3);

        JScrollPane scroll2 = new JScrollPane();
        scroll2.setBounds(25,365,700,250);
        panel.add(scroll2);
        table2 = new JTable();
        table2.setBackground(new Color(54, 161, 179));
        scroll2.setViewportView(table2);

        p2 = new JPanel();
        p2.setBorder(new TitledBorder(new LineBorder(new Color(175, 128, 150), 3),"Return Details",TitledBorder.LEADING,TitledBorder.BOTTOM,null,new Color(71,96,114)));
        p2.setBounds(10,350,730,280);
        panel.add(p2);

        issue1();
        Return1();
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Statistics().setVisible(true);
    }
}
