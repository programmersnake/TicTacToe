package com.kostin.miner.Model;

public class Area implements AreaInterface {

    private final boolean[][] area;
    private final int[][] areaToIsWin;
    private int arara;
    private int maxLenght;

    public Area() {
        area = new boolean[3][3];
        areaToIsWin = new int[3][3];
        arara = -1;
        maxLenght = 9;
        init();
    }

    private void init() {
        for (boolean[] wight : area) {
            for (boolean oneBool : wight) {
                oneBool = false;
            }
        }
    }

    @Override
    public int[][] getAreaIsToWin() {
        return areaToIsWin;
    }

    @Override
    public int getArara() {
        return arara;
    }

    @Override
    public boolean[][] getArea() {
        return area;
    }

    @Override
    public void setTrueValueToArea(short x, short y, int userOrComp) {
        area[x][y] = true;
        areaToIsWin[x][y] = userOrComp;
    }

    @Override
    public boolean isWin() {

        if (((areaToIsWin[0][0] == 2) && (areaToIsWin[1][0] == 2) && (areaToIsWin[2][0] == 2)) ||
                ((areaToIsWin[0][0] == 1) && (areaToIsWin[1][0] == 1) && (areaToIsWin[2][0] == 1))) {
            arara = 0;
            System.out.println( "Arara " + arara );

            return true;
        } else if (((areaToIsWin[0][1] == 2) && (areaToIsWin[1][1] == 2) && (areaToIsWin[2][1] == 2)) ||
                ((areaToIsWin[0][1] == 1) && (areaToIsWin[1][1] == 1) && (areaToIsWin[2][1] == 1))) {
            arara = 1;
            System.out.println( "Arara " + arara );

            return true;
        } else if (((areaToIsWin[0][2] == 2) && (areaToIsWin[1][2] == 2) && (areaToIsWin[2][2] == 2)) ||
                ((areaToIsWin[0][2] == 1) && (areaToIsWin[1][2] == 1) && (areaToIsWin[2][2] == 1))) {
            arara = 2;
            System.out.println( "Arara " + arara );

            return true;
        } else if (((areaToIsWin[0][0] == 2) && (areaToIsWin[0][1] == 2) && (areaToIsWin[0][2] == 2)) ||
                ((areaToIsWin[0][0] == 1) && (areaToIsWin[0][1] == 1) && (areaToIsWin[0][2] == 1))) {
            arara = 3;
            System.out.println( "Arara " + arara );

            return true;
        } else if (((areaToIsWin[1][0] == 2) && (areaToIsWin[1][1] == 2) && (areaToIsWin[1][2] == 2)) ||
                ((areaToIsWin[1][0] == 1) && (areaToIsWin[1][1] == 1) && (areaToIsWin[1][2] == 1))) {
            arara = 4;
            System.out.println( "Arara " + arara );

            return true;
        } else if (((areaToIsWin[2][0] == 2) && (areaToIsWin[2][1] == 2) && (areaToIsWin[2][2] == 2)) ||
                ((areaToIsWin[2][0] == 1) && (areaToIsWin[2][1] == 1) && (areaToIsWin[2][2] == 1))) {
            arara = 5;
            System.out.println( "Arara " + arara );

            return true;
        } else if (((areaToIsWin[0][0] == 2) && (areaToIsWin[1][1] == 2) && (areaToIsWin[2][2] == 2)) ||
                ((areaToIsWin[0][0] == 1) && (areaToIsWin[1][1] == 1) && (areaToIsWin[2][2] == 1))) {
            arara = 6;
            System.out.println( "Arara " + arara );

            return true;
        } else if (((areaToIsWin[0][2] == 2) && (areaToIsWin[1][1] == 2) && (areaToIsWin[2][0] == 2)) ||
                ((areaToIsWin[0][2] == 1) && (areaToIsWin[1][1] == 1) && (areaToIsWin[2][0] == 1))) {
            arara = 7;
            System.out.println( "Arara " + arara );

            return true;
        } else {
            maxLenght--;
            System.out.println( "max = " + maxLenght );
            if (maxLenght != 0)
                return false;
            arara = 8;
            return true;
        }
    }


}
