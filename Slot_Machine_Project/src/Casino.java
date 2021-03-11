import java.awt.Button;
import java.awt.Choice;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.Border;

public class Casino {

    public static String updateBet(Choice c){
        String option;
        option = c.getItem(c.getSelectedIndex());
        return option;
    }



    public static void main(String[] args) {
        Vector<String> pths=new Vector<>();

        JFrame frame=new JFrame();
        frame.setTitle("CASINO");

        Choice c = new Choice();
        c.setBounds(700, 640, 110, 75);
        c.add("25");
        c.add("50");
        c.add("100");
        c.add("500");
        c.add("1000");

        frame.setSize(910, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button=new JButton("SPIN");
        button.setBounds(350,610,150,60);
        frame.getContentPane().add(button);
        frame.getContentPane().add(c);



        String option;

        option = c.getItem(c.getSelectedIndex());
        MyPanel mp=new MyPanel();

        frame.add(mp);
        frame.setVisible(true);
        mp.setBet(updateBet(c));



        mp.InitPaths();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mp.setBet(updateBet(c));
                mp.updateThread();

            }
        });







    }

}
