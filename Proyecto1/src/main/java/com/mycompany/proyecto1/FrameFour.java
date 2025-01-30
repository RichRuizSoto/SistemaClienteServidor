package com.mycompany.proyecto1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameFour extends JFrame {

    public FrameFour() {

        setSize(new Dimension(1400, 800));
        setMinimumSize(new Dimension(1600, 800));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(0, 70));
        northPanel.setBackground(new Color(255, 255, 255));
        northPanel.setLayout(new GridLayout(1, 3));

        JButton backB, octoberEatsB;

        backB = new JButton("Regresar al negocio");
        backB.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));

        octoberEatsB = new JButton("<html>October <b>Eats</b></html>");
        octoberEatsB.setFont(new Font("Arial", Font.ITALIC, 25));

        octoberEatsB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent openMainWindow) {
                dispose();
                FrameOne firstFrame = new FrameOne();
            }
        });

        JButton[] buttonsNorth = {backB, octoberEatsB};

        for (JButton button : buttonsNorth) {
            button.setContentAreaFilled(false); //Hace Transparente el fondo de los botones
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setForeground(Color.BLACK);

            northPanel.add(button);
        }

        JPanel space = new JPanel();
        space.setBackground(Color.white);
        northPanel.add(space);

        JPanel centralPanel = new JPanel();
        centralPanel.setSize(new Dimension(1000, 1000));
//        centralPanel.setBackground(new Color(211, 211, 211));

        JPanel CCPanel = new JPanel();
        CCPanel.setPreferredSize(new Dimension(1400, 750));
        CCPanel.setLayout(new BorderLayout());

        centralPanel.add(CCPanel);

        JPanel westPanel, eastPanel;

        westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(970, 0));

        JPanel details, paymemt;

        details = new JPanel(new FlowLayout());
        details.setPreferredSize(new Dimension(960, 400));
        details.setBackground(new Color(211, 211, 211));

        westPanel.add(details);

        paymemt = new JPanel(new FlowLayout());
        paymemt.setPreferredSize(new Dimension(960, 200));
        paymemt.setBackground(new Color(211, 211, 211));

        westPanel.add(paymemt);

        eastPanel = new JPanel(new FlowLayout());
        eastPanel.setPreferredSize(new Dimension(415, 0));

        JPanel subscription, cart, codes, total;

        subscription = new JPanel();
        subscription.setPreferredSize(new Dimension(400, 250));

        cart = new JPanel();
        cart.setPreferredSize(new Dimension(400, 70));

        codes = new JPanel();
        codes.setPreferredSize(new Dimension(400, 120));

        total = new JPanel();
        total.setPreferredSize(new Dimension(400, 180));

        JPanel[] panelsEast = {subscription, cart, codes, total};

        for (JPanel panel : panelsEast) {
            panel.setBackground(Color.white);

            eastPanel.add(panel);
        }

        CCPanel.add(westPanel, BorderLayout.WEST);
        CCPanel.add(eastPanel, BorderLayout.EAST);

        add(northPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);

        setVisible(true);
    }

}
