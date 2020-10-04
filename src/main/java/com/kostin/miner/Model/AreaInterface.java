package com.kostin.miner.Model;

public interface AreaInterface {

    boolean[][] getArea();

    boolean isWin();

    void setTrueValueToArea(short x, short y, int userOrComp);

    int[][] getAreaIsToWin();

    int getArara();
}
