package com.vivla;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame implements Runnable {

    private Box[][] boxes;
    private Coord coord;
    private Figures figure;

    public MainFrame() {
        initFrame();
        initPanel();
        addKeyListener(new KeyPressAdapter());
    }

    @Override
    public void run() {
        repaint();
    }

    private void initFrame() {
        setSize(Config.SIZE * Config.WIDTH + 15, Config.SIZE * Config.HEIGHT + 35);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Tetris The Game");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initPanel() {
        boxes = new Box[Config.WIDTH][Config.HEIGHT];
        for (int x = 0; x < Config.WIDTH; x++)
            for (int y = 0; y < Config.HEIGHT; y++) {
                boxes[x][y] = new Box(x, y);
                add(boxes[x][y]);
            }
    }

    public void addFigure() {
        coord = new Coord(4, 5);
        figure = Figures.getRandomFigure();
        showFigure();
    }

    private void initFigure(Coord at, Figures figure, int color) {
        for (Coord coord : figure.cords)
            setBoxColor(coord.getX() + at.getX(), coord.getY() + at.getY(), color);
    }

    private void showFigure() {
        initFigure(coord, figure, 1);
    }

    private void hideFigure() {
        initFigure(coord, figure, 0);
    }

    private void setBoxColor(int x, int y, int color) {
        if (x < 0 || x >= Config.WIDTH) return;
        if (y < 0 || y >= Config.HEIGHT) return;
        boxes[x][y].setColor(color);
    }

    private void moveFigure(int sx, int sy) {
        coord = new Coord(coord.getX() + sx, coord.getY() + sy);
    }

    private void turnFigure() {
        figure = figure.turnRight();
    }

    private class KeyPressAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            hideFigure();
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT: moveFigure(-1, 0); break;
                case KeyEvent.VK_RIGHT: moveFigure(+1, 0); break;
                case KeyEvent.VK_U: moveFigure(0, -1); break;
                case KeyEvent.VK_UP: turnFigure(); break;
                case KeyEvent.VK_SPACE: moveFigure(0, 1); break;
            }
            showFigure();
        }
    }

}
