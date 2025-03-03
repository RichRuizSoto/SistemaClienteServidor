package com.mycompany.proyecto1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameOne extends JFrame {

    public FrameOne() {

        setSize(new Dimension(1400, 800));
        setMinimumSize(new Dimension(1600, 800));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(0, 70));
        northPanel.setBackground(new Color(255, 255, 255));
        northPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));

        JButton threeLinesButton = new JButton("≡");
        threeLinesButton.setPreferredSize(new Dimension(60, 40));
        threeLinesButton.setFont(new Font("Arial", Font.BOLD, 30));

        northPanel.add(threeLinesButton, FlowLayout.LEFT);

        JButton octoberEatsButton = new JButton("<html>October <b>Eats</b></html>");
        octoberEatsButton.setPreferredSize(new Dimension(200, 40));
        octoberEatsButton.setFont(new Font("Arial", Font.ITALIC, 20));

        octoberEatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent openMainWindow) {
                dispose();
                FrameOne firstFrame = new FrameOne();
            }
        });

        northPanel.add(octoberEatsButton);

        JPanel northSpace = new JPanel();
        northSpace.setPreferredSize(new Dimension(400, 40));
        northSpace.setBackground(new Color(0, 0, 0, 0));

        northPanel.add(northSpace);

        JTextArea searchArea = new JTextArea();
        searchArea.setPreferredSize(new Dimension(400, 40));
        searchArea.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        northPanel.add(searchArea);

        JButton cart = new JButton();
        cart.setPreferredSize(new Dimension(60, 40));
        cart.setFont(new Font("Arial", Font.BOLD, 20));

        ImageIcon cartImage = new ImageIcon("images/cart.png");
        ImageIcon cartImageEscalada = new ImageIcon(cartImage.getImage().getScaledInstance(20, 20, Image.SCALE_FAST));
        cart.setIcon(cartImageEscalada);

        cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent openCartWindow) {
                dispose();
                FrameFour fourthFrame = new FrameFour();
            }
        });

        northPanel.add(cart);

        JButton singIn = new JButton("Iniciar Sesion");
        singIn.setPreferredSize(new Dimension(200, 40));
        singIn.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));

        singIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent openSingInWindow) {
                dispose();
                FrameTwo secondFrame = new FrameTwo();
            }
        });

        northPanel.add(singIn);

        JButton singUp = new JButton("Registrarse");
        singUp.setPreferredSize(new Dimension(150, 40));
        singUp.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));

        singUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent openSingInWindow) {
                dispose();
                FrameFive fifthFrame = new FrameFive();
            }
        });

        northPanel.add(singUp);

        JButton[] northButtons = {threeLinesButton, octoberEatsButton, cart, singIn, singUp};

        for (JButton button : northButtons) {
            button.setContentAreaFilled(false); //Hace Transparente el fondo de los botones
            button.setBorderPainted(false);
            button.setFocusPainted(false);
        }

        JPanel centralPanel = new JPanel();
        centralPanel.setSize(new Dimension(1000, 1000));
        centralPanel.setBackground(Color.white);

        JPanel CCPanel = new JPanel();
        CCPanel.setPreferredSize(new Dimension(1400, 750));
        CCPanel.setBackground(Color.white);
        CCPanel.setLayout(new BorderLayout());

        centralPanel.add(CCPanel);

        JPanel NCCPanel = new JPanel();
        NCCPanel.setPreferredSize(new Dimension(0, 60));
        NCCPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 17));
        NCCPanel.setBackground(new Color(255, 255, 255));

        JButton todosB, ocoberEatsB, superB, expressB, alcoholB, farmaciaB, gourmet, retailB, mascotaB, floresB, bebeB, electronicaB;

        todosB = new JButton("Todos");
        ocoberEatsB = new JButton("October Eats");
        superB = new JButton("Super");
        expressB = new JButton("Express");
        alcoholB = new JButton("Alcohol");
        farmaciaB = new JButton("Farmacia");
        gourmet = new JButton("Gourmet");
        retailB = new JButton("Retail");
        mascotaB = new JButton("Mascota");
        floresB = new JButton("Flores");
        bebeB = new JButton("Bebe");
        electronicaB = new JButton("Electronica");

        JButton[] NCCButtons = {todosB, ocoberEatsB, superB, expressB, alcoholB, farmaciaB, gourmet, retailB, mascotaB, floresB, bebeB, electronicaB};

        for (JButton button : NCCButtons) {
            button.setFont(new Font("Arial", Font.ITALIC, 15));
            button.setContentAreaFilled(false); //Hace Transparente el fondo de los botones
            button.setBorderPainted(false);
            button.setFocusPainted(false);

            NCCPanel.add(button);
        };

        CCPanel.add(NCCPanel, BorderLayout.NORTH);

        JPanel CCCPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        CCCPanel.setBackground(Color.white);
        CCCPanel.setPreferredSize(new Dimension(1400, 690));

        JButton restOne, restOTwo, restThree, restFour, restFive, restSix, restSeven, restEight;

        restOne = new JButton();
        restOTwo = new JButton();
        restThree = new JButton();
        restFour = new JButton();
        restFive = new JButton();
        restSix = new JButton();
        restSeven = new JButton();
        restEight = new JButton();

        JButton[] buttons = {restOne, restOTwo, restThree, restFour, restFive, restSix, restSeven, restEight};

        for (JButton button : buttons) {
            button.setPreferredSize(new Dimension(344, 300));
            button.setBackground(Color.white);
            button.setLayout(new FlowLayout());

            JPanel imagePanel = new JPanel();
            imagePanel.setBackground(new Color(211, 211, 211));
            imagePanel.setPreferredSize(new Dimension(342, 205));

            button.add(imagePanel);

            JPanel namePanel = new JPanel();
            namePanel.setBackground(Color.gray);
            namePanel.setPreferredSize(new Dimension(342, 63));

            button.add(namePanel);

            button.setContentAreaFilled(false); //Hace Transparente el fondo de los botones
            button.setBorderPainted(false);
            button.setFocusPainted(false);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent openMenuWindow) {
                    dispose();
                    FrameThree thirdFrame = new FrameThree();
                }
            });

            CCCPanel.add(button);
        }

        CCPanel.add(CCCPanel);

        add(northPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);

        setVisible(true);

    }

}
