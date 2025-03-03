package com.mycompany.proyecto1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FrameFive extends JFrame {

    public FrameFive() {

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

        JLabel titleOne = new JLabel("<html>What's your phone name</html>");
        titleOne.setFont(new Font("Arial", Font.ROMAN_BASELINE, 21));
        titleOne.setPreferredSize(new Dimension(290, 40));

        CCPanel.add(titleOne);

        JTextArea inputNameArea = new JTextArea();
        inputNameArea.setPreferredSize(new Dimension(290, 40));
        inputNameArea.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        CCPanel.add(inputNameArea);

        JLabel titleTwo = new JLabel("<html>What's your password?</html>");
        titleTwo.setFont(new Font("Arial", Font.ROMAN_BASELINE, 21));
        titleTwo.setPreferredSize(new Dimension(290, 40));

        CCPanel.add(titleTwo);

        JTextArea inputPasswordArea = new JTextArea();
        inputPasswordArea.setPreferredSize(new Dimension(290, 40));
        inputPasswordArea.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        CCPanel.add(inputPasswordArea);

        JLabel titleThree = new JLabel("<html>What's your phone number or<br>email?</html>");
        titleThree.setFont(new Font("Arial", Font.ROMAN_BASELINE, 21));
        titleThree.setPreferredSize(new Dimension(290, 40));

        CCPanel.add(titleThree);

        JTextArea inputEmailArea = new JTextArea();
        inputEmailArea.setPreferredSize(new Dimension(290, 40));
        inputEmailArea.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        CCPanel.add(inputEmailArea);

        JLabel titleFour = new JLabel("<html>What's your physical address?</html>");
        titleFour.setFont(new Font("Arial", Font.ROMAN_BASELINE, 21));
        titleFour.setPreferredSize(new Dimension(290, 40));

        CCPanel.add(titleFour);

        JTextArea inputAddressArea = new JTextArea();
        inputAddressArea.setPreferredSize(new Dimension(290, 40));
        inputAddressArea.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        CCPanel.add(inputAddressArea);

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
