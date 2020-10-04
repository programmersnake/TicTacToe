package com.kostin.miner.Players;

import com.kostin.miner.Model.Area;
import com.kostin.miner.Model.AreaInterface;

public class PlayerUser implements Player {
    private final AreaInterface area;

    public PlayerUser() {
        area = new Area();
        System.out.println( "Player area is " + area );
    }

    @Override
    public short[] xod(short x, short y) {
        area.setTrueValueToArea( x, y, 2 );
        return null;
    }

    @Override
    public AreaInterface getArea() {
        return area;
    }

    @Override
    public boolean isWin() {
        return area.isWin();
    }

    @Override
    public int getWinImgCode() {
        return area.getArara();
    }
}
