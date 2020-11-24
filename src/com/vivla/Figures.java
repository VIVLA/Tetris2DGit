package com.vivla;

import java.util.ArrayList;

public enum Figures {

    I1 (0, 1,  1, 1,  2, 1,  3, 1),
    I2 (1, 0,  1, 1,  1, 2,  1, 3),

    J1 (1, 0,  1, 1,  0, 2,  1, 2),
    J2 (0, 0,  0, 1,  1, 1,  2, 1),
    J3 (1, 0,  2, 0,  1, 1,  1, 2),
    J4 (0, 1,  1, 1,  2, 1,  2, 2),

    L1 (1, 0,  1, 1,  1, 2,  2, 2),
    L2 (0, 1,  1, 1,  2, 1,  0, 2),
    L3 (0, 0,  1, 0,  1, 1,  1, 2),
    L4 (2, 0,  0, 1,  1, 1,  2, 1),

    O  (0, 0,  1, 0,  0, 1,  1, 1),

    S1 (1, 1,  2, 1,  0, 2,  1, 2),
    S2 (0, 0,  0, 1,  1, 1,  1, 2),

    T1 (0, 1,  1, 1,  2, 1,  1, 2),
    T2 (1, 0,  0, 1,  1, 1,  1, 2),
    T3 (1, 0,  0, 1,  1, 1,  2, 1),
    T4 (1, 0,  1, 1,  2, 1,  1, 2),

    Z1 (0, 1,  1, 1,  1, 2,  2, 2),
    Z2 (2, 0,  1, 1,  2, 1,  1, 2);

    public ArrayList<Coord> cords;
    public Coord leftTopCoord;
    public Coord rightBottomCoord;

    Figures(int...dots) {
        cords = new ArrayList<>();
        for (int j = 0; j < dots.length; j += 2) {
            cords.add(new Coord(dots[j], dots[j + 1]));
        }
        leftTopCoord = getLeftTopCoord();
        rightBottomCoord = getRightBottomCoord();
    }


    private Coord getLeftTopCoord() {
        int x = cords.get(0).getX();
        int y = cords.get(0).getY();
        for (Coord coord : cords) {
            if (x > coord.getX()) x = coord.getX();
            if (y > coord.getY()) y = coord.getY();
        }
        return new Coord(x, y);
    }

    private Coord getRightBottomCoord() {
        int x = cords.get(0).getX();
        int y = cords.get(0).getY();
        for (Coord coord : cords) {
            if (x < coord.getX()) x = coord.getX();
            if (y < coord.getY()) y = coord.getY();
        }
        return new Coord(x, y);

    }

    public static Figures getRandomFigure() {
        switch ((int) (Math.random() * 7)) {
            default:
            case 0: return I1;
            case 1: return L1;
            case 2: return J1;
            case 3: return O;
            case 4: return S1;
            case 5: return T1;
            case 6: return Z1;
        }
    }

    public Figures turnRight() {
        switch (this) {
            default:
            case I1: return I2;
            case I2: return I1;
            case J1: return J2;
            case J2: return J3;
            case J3: return J4;
            case J4: return J1;
            case L1: return L2;
            case L2: return L3;
            case L3: return L4;
            case L4: return L1;
            case O:  return O;
            case S1: return S2;
            case S2: return S1;
            case T1: return T2;
            case T2: return T3;
            case T3: return T4;
            case T4: return T1;
            case Z1: return Z2;
            case Z2: return Z1;
        }
    }

}
