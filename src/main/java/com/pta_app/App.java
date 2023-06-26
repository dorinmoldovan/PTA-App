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

}
