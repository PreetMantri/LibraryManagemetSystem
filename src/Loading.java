import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements  Runnable {
    JPanel controlpanel;
    JProgressBar progress;
    int s;
    Thread t1;

    Loading(){
        setTitle("Loading...");
        t1 = new Thread((Runnable)this);

        setBounds(550,200,500,300);
        controlpanel = new JPanel();
        setContentPane(controlpanel);
        controlpanel.setLayout(null);

        JLabel l1 = new JLabel("Library v1.1");
        l1.setBounds(140, 30, 250, 40);
        l1.setFont(new Font("MV Boli", Font.BOLD, 40));
        l1.setForeground(new Color(44, 27, 156));
        controlpanel.add(l1);
        progress = new JProgressBar();
        progress.setStringPainted(true);
        progress.setBounds(100, 135, 300, 25);
        progress.setBackground(new Color(150, 186, 255));
        progress.setFont(new Font("Verdana",Font.PLAIN,10));
//        progress.setForeground(Color.BLACK);
        controlpanel.add(progress);

        JLabel l2 = new JLabel("PLease Wait...");
        l2.setForeground(new Color(10, 16, 200));
        l2.setBounds(190,175,150,20);
        l2.setFont(new Font("Verdana",Font.PLAIN,18));
        controlpanel.add(l2);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(50,130,200));
        panel.setBounds(0, 0, 590, 390);
        controlpanel.add(panel);

        setLoad();
    }
    public void setLoad(){
        setVisible(false);
        t1.start();
    }

    public static void main(String[] args) {
        new Loading().setVisible(true);
    }
    public void run() {
        try{
            for(int i=0;i<200;i++){
                s=s+1;
                int max=progress.getMaximum();
                int value=progress.getValue();
                if(value<max){
                    progress.setValue(progress.getValue()+1);
                }
                else{
                    i=201;
                    setVisible(false);
                    new Page1();
                }
                Thread.sleep(50);
            }
        }
        catch (Exception e1){
            e1.printStackTrace();
        }
    }
}
