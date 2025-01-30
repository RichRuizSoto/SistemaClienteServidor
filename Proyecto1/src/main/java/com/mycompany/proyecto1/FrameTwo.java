package com.mycompany.proyecto1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameTwo extends JFrame {

    public FrameTwo() {

        setSize(new Dimension(1400, 800));
        setMinimumSize(new Dimension(1600, 800));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(0, 70));
        northPanel.setBackground(new Color(0, 0, 0));
        northPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));

        JButton octoberEatsButton = new JButton("<html>October <b>Eats</b></html>");
        octoberEatsButton.setPreferredSize(new Dimension(200, 40));
        octoberEatsButton.setFont(new Font("Arial", Font.ITALIC, 25));
        octoberEatsButton.setForeground(new Color(255, 255, 255));
        octoberEatsButton.setContentAreaFilled(false); //Hace Transparente el fondo de los botones
        octoberEatsButton.setBorderPainted(false);
        octoberEatsButton.setFocusPainted(false);

        octoberEatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent openMainWindow) {
                dispose();
                FrameOne firstFrame = new FrameOne();
            }
        });

        northPanel.add(octoberEatsButton);

        JPanel centralPanel = new JPanel();
        centralPanel.setSize(new Dimension(1000, 1000));
        centralPanel.setBackground(new Color(255, 255, 255));

        JPanel CCPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 12));
        CCPanel.setPreferredSize(new Dimension(350, 750));
        CCPanel.setBackground(new Color(0, 0, 0, 0));

        centralPanel.add(CCPanel);

        JPanel space = new JPanel();
        space.setPreferredSize(new Dimension(290, 150));
        space.setBackground(new Color(0, 0, 0, 0));

        CCPanel.add(space);

        JLabel titleOne = new JLabel("<html>What's your phone number or<br>email?</html>");
        titleOne.setFont(new Font("Arial", Font.ROMAN_BASELINE, 21));
        titleOne.setPreferredSize(new Dimension(290, 40));

        CCPanel.add(titleOne);

        JTextArea inputEmailArea = new JTextArea();
        inputEmailArea.setPreferredSize(new Dimension(290, 40));
        inputEmailArea.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        CCPanel.add(inputEmailArea);

        JButton continueButton, googleButton, appleButton, QRButton;

        continueButton = new JButton("Continue");
        googleButton = new JButton(" Continue with Google");

        ImageIcon googleImage = new ImageIcon("images/google.png");
        ImageIcon googleImageEscalada = new ImageIcon(googleImage.getImage().getScaledInstance(25, 25, Image.SCALE_FAST));
        googleButton.setIcon(googleImageEscalada);

        appleButton = new JButton(" Continue with Apple");

        ImageIcon appleImage = new ImageIcon("images/apple.png");
        ImageIcon appleImageEscalada = new ImageIcon(appleImage.getImage().getScaledInstance(20, 20, Image.SCALE_FAST));
        appleButton.setIcon(appleImageEscalada);

        QRButton = new JButton(" Log in with QR code");

        ImageIcon qrImage = new ImageIcon("images/qr.png");
        ImageIcon qrImageEscalada = new ImageIcon(qrImage.getImage().getScaledInstance(20, 20, Image.SCALE_FAST));
        QRButton.setIcon(qrImageEscalada);

        JButton[] buttons = {continueButton, googleButton, appleButton, QRButton};

        for (JButton button : buttons) {
            button.setPreferredSize(new Dimension(290, 40));
            button.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));
            button.setForeground(Color.DARK_GRAY);
            button.setBackground(new Color(240, 240, 240));
            button.setBorderPainted(false);
            button.setFocusPainted(false);

            if (button.getText().equals("Continue with Google") || button.getText().equals("Log in with QR code")) {
                JSeparator separator = new JSeparator();
                separator.setBackground(Color.GRAY);
                separator.setPreferredSize(new Dimension(280, 5));

                CCPanel.add(separator);
            };

            CCPanel.add(button);
        };

        continueButton.setBackground(Color.BLACK);
        continueButton.setForeground(Color.WHITE);

//        JDialog dialog = new JDialog(secondFrame, "Inicio de sesion", true);
//        dialog.setSize(300, 200);
//        dialog.setLocationRelativeTo(secondFrame);
//        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        dialog.setVisible(true);
        add(centralPanel, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);

        setVisible(true);

    }

}
