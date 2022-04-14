package ua.advanced.lesson04;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramPriority {
    private static Thread thL;
    private static Thread thR;
    public static void main(String[] args) {

        JFrame win  = new JFrame();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(500,300);
        JPanel panel = new JPanel();
        JSlider slider = new JSlider(0, 100, 50);
        JButton bthLM = new JButton("-");
        bthLM.addActionListener(e -> thL.setPriority(thL.getPriority()-1));
        JButton bthLP = new JButton("+");
        bthLP.addActionListener(e -> thL.setPriority(thL.getPriority()+1));
        JButton bthRM = new JButton("-");
        bthRM.addActionListener(e -> thR.setPriority(thR.getPriority()-1));
        JButton bthRP = new JButton("+");
        bthRP.addActionListener(e -> thR.setPriority(thR.getPriority()+1));
        JButton bthStart = new JButton("Start");
        bthStart.addActionListener( e -> {
            thL = new Thread(() -> {
                while (true)
                slider.setValue(slider.getValue()-1);
            });
            thR = new Thread(() -> {
                while (true)
                slider.setValue(slider.getValue()+1);
            });
            thL.setDaemon(true);
            thR.setDaemon(true);
            thL.start();
            thR.start();
        });

        panel.add(bthLM);
        panel.add(bthLP);
        panel.add(slider);
        panel.add(bthRM);
        panel.add(bthRP);
        panel.add(bthStart);
        win.setContentPane(panel);
        win.setVisible(true);
    }
}
