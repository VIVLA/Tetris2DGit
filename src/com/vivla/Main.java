package com.vivla;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        SwingUtilities.invokeLater(frame);
        frame.addFigure();
    }
}
