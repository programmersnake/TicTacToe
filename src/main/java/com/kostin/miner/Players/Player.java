package com.kostin.miner.Players;

import com.kostin.miner.Model.AreaInterface;

public interface Player {

    short[] xod(short x, short y);

    boolean isWin();

    AreaInterface getArea();

    int getWinImgCode();

}
