import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Page1 extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l11,l12,l4,l5,l6,l7;
    JPanel panel1,panel2,panel3;
    JButton b1,b2,b3,b4,b5,b6;

    Page1(){
        setTitle("Options");

        panel1 = new JPanel();
        setContentPane(panel1);

        b1 = new JButton("Add Books");
        b1.setBounds(50,200,120,25);
        b1.setFont(new Font("MV Boli",Font.PLAIN,15));
        b1.setBackground(new Color(125, 237, 255));
        panel1.add(b1);
        b1.addActionListener(this);
        b2 = new JButton("Statistics");
        b2.setBounds(250,200,120,25);
        b2.setFont(new Font("MV Boli",Font.PLAIN,15));
        b2.setBackground(new Color(125, 237, 255));
        panel1.add(b2);
        b2.addActionListener(this);
        b3 = new JButton("Add User");
        b3.setBounds(450,200,120,25);
        b3.setFont(new Font("MV Boli",Font.PLAIN,15));
        b3.setBackground(new Color(125, 237, 255));
        panel1.add(b3);
        b3.addActionListener(this);
        b4 = new JButton("Issue Book");
        b4.setBounds(120,400,150,25);
        b4.setFont(new Font("MV Boli",Font.PLAIN,15));
        b4.setBackground(new Color(125, 237, 255));
        panel1.add(b4);
        b4.addActionListener(this);

        b5 = new JButton("Return Book");
        b5.setBounds(320,400,150,25);
        b5.setFont(new Font("MV Boli",Font.PLAIN,15));
        b5.setBackground(new Color(125, 237, 255));
        panel1.add(b5);
        b5.addActionListener(this);


        JLabel l1= new JLabel();
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/profile5.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,1);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l2 = new JLabel(i3);
        l2.setBounds(460,90,100,100);
        panel1.add(l2);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/book4.png"));
        Image i5 = i4.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l3 = new JLabel(i6);
        l3.setBounds(60,90,100,100);
        panel1.add(l3);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/book3.png"));
        Image i8 = i7.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l4 = new JLabel(i9);
        l4.setBounds(260,90,100,100);
        panel1.add(l4);

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/add7.png"));
        Image i11 = i10.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel l5 = new JLabel(i12);
        l5.setBounds(150,290,100,100);
        panel1.add(l5);

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/return6.png"));
        Image i14 = i13.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel l6 = new JLabel(i15);
        l6.setBounds(350,290,100,100);
        panel1.add(l6);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED,new  Color(80,96,130),new  Color(80,100,130)));
        menuBar.setBackground(new Color(200,255,255));
        menuBar.setBounds(0,10,600,35);
        panel1.add(menuBar);

        JMenu mRecord = new JMenu("Records");
        mRecord.setFont(new Font("Futura",Font.PLAIN,15));


        JMenuItem bookdetail = new JMenuItem("Book Details");
        bookdetail.setFont(new Font("Futura",Font.PLAIN,15));
        mRecord.add(bookdetail);
        bookdetail.addActionListener(this);

        JMenuItem userdetail = new JMenuItem("Student Details");
        userdetail.setFont(new Font("Futura",Font.PLAIN,15));
        mRecord.add(userdetail);
        userdetail.addActionListener(this);

        JMenu mExit = new JMenu("Exit");
        mExit.setFont(new Font("Futura",Font.PLAIN,15));

        JMenuItem logout = new JMenuItem("Logout");
        logout.setFont(new Font("Futura",Font.PLAIN,15));
        mExit.add(logout);
        logout.addActionListener(this);
        JMenuItem exit1 = new JMenuItem("Exit");
        exit1.setFont(new Font("Futura",Font.PLAIN,15));
        mExit.add(exit1);
        exit1.addActionListener(this);

        exit1.setMnemonic(KeyEvent.VK_E);
        logout.setMnemonic(KeyEvent.VK_L);
        logout.setMnemonic(KeyEvent.VK_L);
        menuBar.add(mRecord);
        menuBar.add(mExit);



        panel1.setBackground(new Color(50,130,200));
        setBounds(500,150,600,500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e4) {
        try {
            String msg=e4.getActionCommand();
            if (msg.equals("Logout")){
                setVisible(false);
                new LoginUser1().setVisible(true);
            }
            else if(msg.equals("Exit")){
                System.exit(ABORT);

            }
            else if (msg.equals("Book Details")) {
                setVisible(false);
                new BookDetail().setVisible(true);
            }
            else if (msg.equals("Student Details")) {
                setVisible(false);
                new StudentDetail().setVisible(true);
            }
            if(e4.getSource()==b1){//Add Books
                setVisible(false);
                new AddBooks().setVisible(true);
            }
            if(e4.getSource()==b2){//Statistics
                setVisible(false);
                new Statistics().setVisible(true);
            }
            if(e4.getSource()==b3){//Add User
                setVisible(false);
                new AddUser();
            }
            if(e4.getSource()==b4){//Issue Book
                setVisible(false);
                new IssueBook().setVisible(true);
            }
            if(e4.getSource()==b5){//Return Book
                setVisible(false);
                new ReturnBook().setVisible(true);
            }
        }
        catch (Exception e1){
            e1.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Page1();
    }


}
