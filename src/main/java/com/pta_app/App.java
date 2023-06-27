package com.pta_app;

import com.pta_app.algorithm.PTA;
import com.pta_app.algorithm.Result;
import com.pta_app.objective_functions.OFCreator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class App {

    public static KeyAdapter addKeyAdapterForDigits() {
        KeyAdapter keyAdapter = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if((c < '0') && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
                if((c > '9') && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        };
        return keyAdapter;
    }

    public static void addComponentsToPane(Container pane) {
        pane.setBackground(new java.awt.Color(203, 195, 227));

        pane.setLayout(null);

        JLabel plumsLabel = new JLabel("Number of plums (N):");
        pane.add(plumsLabel);

        final JTextField plumsField = new JTextField(10);
        plumsField.addKeyListener(addKeyAdapterForDigits());
        pane.add(plumsField);

        JLabel numberOfIterationsLabel = new JLabel("Number of iterations (I):");
        pane.add(numberOfIterationsLabel);

        final JTextField iterationsField = new JTextField(10);
        iterationsField.addKeyListener(addKeyAdapterForDigits());
        pane.add(iterationsField);

        JLabel numberOfDimensionsLabel = new JLabel("Number of dimensions (D):");
        pane.add(numberOfDimensionsLabel);

        final JTextField numberOfDimensionsField = new JTextField(10);
        numberOfDimensionsField.addKeyListener(addKeyAdapterForDigits());
        pane.add(numberOfDimensionsField);

        JLabel ftLabel = new JLabel("Fruitiness threshold (FT):");
        pane.add(ftLabel);

        final JTextField ftField = new JTextField(10);
        pane.add(ftField);

        JLabel rtLabel = new JLabel("Ripeness threshold (RT):");
        pane.add(rtLabel);

        final JTextField rtField = new JTextField(10);
        pane.add(rtField);

        JLabel minFRLabel = new JLabel("Minimum fruitiness rate (FR_min):");
        pane.add(minFRLabel);

        final JTextField minFRField = new JTextField(10);
        pane.add(minFRField);

        JLabel maxFRLabel = new JLabel("Maximum fruitiness rate (FR_max):");
        pane.add(maxFRLabel);

        final JTextField maxFRField = new JTextField(10);
        pane.add(maxFRField);

        JLabel epsilonLabel = new JLabel("Epsilon (eps):");
        pane.add(epsilonLabel);

        final JTextField epsilonField = new JTextField(10);
        pane.add(epsilonField);

        final JLabel ofLabel = new JLabel("Objective function (OF):");
        pane.add(ofLabel);

        String[] ofs = {"", "OF 1", "OF 2", "OF 3", "OF 4", "OF 5", "OF 6", "OF 7", "OF 8", "OF 9"};
        final JComboBox ofsComboBox = new JComboBox(ofs);
        pane.add(ofsComboBox);

        final JTextArea textArea = new JTextArea(22, 48);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        pane.add(scrollPane);

        Insets insets = pane.getInsets();

        Dimension size = plumsLabel.getPreferredSize();
        plumsLabel.setBounds(25 + insets.left, 25 + insets.top,
                size.width, size.height);

        size = plumsField.getPreferredSize();
        plumsField.setBounds(250 + insets.left, 25 + insets.top,
                size.width, size.height);

        size = numberOfIterationsLabel.getPreferredSize();
        numberOfIterationsLabel.setBounds(25 + insets.left, 50 + insets.top,
                size.width, size.height);

        size = iterationsField.getPreferredSize();
        iterationsField.setBounds(250 + insets.left, 50 + insets.top,
                size.width, size.height);

        size = numberOfDimensionsLabel.getPreferredSize();
        numberOfDimensionsLabel.setBounds(25 + insets.left, 75 + insets.top,
                size.width, size.height);

        size = numberOfDimensionsField.getPreferredSize();
        numberOfDimensionsField.setBounds(250 + insets.left, 75 + insets.top,
                size.width, size.height);

        size = ftLabel.getPreferredSize();
        ftLabel.setBounds(25 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = ftField.getPreferredSize();
        ftField.setBounds(250 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = rtLabel.getPreferredSize();
        rtLabel.setBounds(25 + insets.left, 125 + insets.top,
                size.width, size.height);

        size = rtField.getPreferredSize();
        rtField.setBounds(250 + insets.left, 125 + insets.top,
                size.width, size.height);

        size = minFRLabel.getPreferredSize();
        minFRLabel.setBounds(25 + insets.left, 150 + insets.top,
                size.width, size.height);

        size = minFRField.getPreferredSize();
        minFRField.setBounds(250 + insets.left, 150 + insets.top,
                size.width, size.height);

        size = maxFRLabel.getPreferredSize();
        maxFRLabel.setBounds(25 + insets.left, 175 + insets.top,
                size.width, size.height);

        size = maxFRField.getPreferredSize();
        maxFRField.setBounds(250 + insets.left, 175 + insets.top,
                size.width, size.height);

        size = epsilonLabel.getPreferredSize();
        epsilonLabel.setBounds(25 + insets.left, 200 + insets.top,
                size.width, size.height);

        size = epsilonField.getPreferredSize();
        epsilonField.setBounds(250 + insets.left, 200 + insets.top,
                size.width, size.height);

        size = ofLabel.getPreferredSize();
        ofLabel.setBounds(25 + insets.left, 225 + insets.top,
                size.width, size.height);

        size = ofsComboBox.getPreferredSize();
        ofsComboBox.setBounds(250 + insets.left, 225 + insets.top,
                size.width, size.height);

        size = scrollPane.getPreferredSize();
        scrollPane.setBounds(420 + insets.left, 25 + insets.top,
                size.width, size.height);

        JButton simulationButton = new JButton("Start Simulation");
        pane.add(simulationButton);
        simulationButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int N = Integer.parseInt(plumsField.getText());
                int I = Integer.parseInt(iterationsField.getText());
                int D = Integer.parseInt(numberOfDimensionsField.getText());
                double FT = Double.parseDouble(ftField.getText());
                double RT = Double.parseDouble(rtField.getText());
                double minFR = Double.parseDouble(minFRField.getText());
                double maxFR = Double.parseDouble(maxFRField.getText());
                double eps = Double.parseDouble(epsilonField.getText());
                String OF = (String) ofsComboBox.getSelectedItem();

                textArea.setText(null);

                textArea.append("  ------------------------------------------------------------\n");
                textArea.append("  NEW SIMULATION\n");
                textArea.append("  ------------------------------------------------------------\n");

                textArea.append("  Number of horses (N) = " + N + "\n");
                textArea.append("  Number of iterations (I) = " + I + "\n");
                textArea.append("  Number of dimensions (D) = " + D + "\n");
                textArea.append("  Fruitiness threshold (FT) = " + FT + "\n");
                textArea.append("  Ripeness threshold (RT) = " + RT + "\n");
                textArea.append("  Minimum fruitiness rate (minFR) = " + minFR + "\n");
                textArea.append("  Maximum fruitiness rate (maxFR) = " + maxFR + "\n");
                textArea.append("  Epsilon (eps) = " + eps + "\n");
                textArea.append("  Objective function (OF) = " + OF + "\n");

                textArea.append("  ------------------------------------------------------------\n");
                textArea.append("  SIMULATION LOGS\n");
                textArea.append("  ------------------------------------------------------------\n");

                PTA pta = new PTA(N, I, D, FT, RT, minFR, maxFR, eps, OFCreator.generateOF(OF));
                Result result = pta.run();
                textArea.append(result.getLogs());
                textArea.append("  ------------------------------------------------------------\n");
                textArea.append("  GBEST PLUM VALUE\n");
                textArea.append("  ------------------------------------------------------------\n");
                textArea.append("  " + result.getGlobalBest().getFitness() + "\n");
                textArea.append("  ------------------------------------------------------------\n");
                textArea.append("  RUNNING TIME\n");
                textArea.append("  ------------------------------------------------------------\n");
                textArea.append("  " + result.getRunningTime() + " millis\n");
            }
        });

        size = simulationButton.getPreferredSize();
        simulationButton.setBounds(25 + insets.left, 400 + insets.top,
                size.width + 215, size.height + 10);
    }

    public static void main(String args[]){
        JFrame frame = new JFrame("PTA App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        addComponentsToPane(frame.getContentPane());
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
