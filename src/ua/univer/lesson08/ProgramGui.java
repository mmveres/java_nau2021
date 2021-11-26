package ua.univer.lesson08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ProgramGui {


    public static void main(String[] args) {
        JFrame win = new JFrame("First win");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(300, 400);
        JPanel panel = new JPanel();
        JTextField txt1 = new JTextField("           hi          ");
        JTextField txt2 = new JTextField("           hi          ");
        JButton btn = new JButton("Ok");
        btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < 100; i++) {
                                        txt1.setText("" + i);
                                        try {
                                            Thread.sleep(20);
                                        } catch (InterruptedException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                }
                        }).start();
                        //    txt2.setText("Action "+ txt1.getText());
                    }
                });
        JButton btn1 = new JButton("Ok");
        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txt1.setText("Click");
            }
        });
        panel.add(btn);
        panel.add(txt1);
        panel.add(txt2);
        win.setContentPane(panel);
        win.setVisible(true);
    }

}
