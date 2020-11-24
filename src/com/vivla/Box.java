package com.vivla;

import javax.swing.*;
import java.awt.*;

public class Box extends JPanel {

    public Box(int x, int y) {
        super();
        setBounds(x * Config.SIZE, y * Config.SIZE, Config.SIZE, Config.SIZE);
        setBackground(Color.GRAY);
        setVisible(true);
    }

    public void setColor(int color) {
        if (color == 1)
            setBackground(Color.CYAN);
        else
            setBackground(Color.GRAY);
    }

}
