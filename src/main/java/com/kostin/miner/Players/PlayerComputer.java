package com.kostin.miner.Players;

import com.kostin.miner.Model.AreaInterface;

public class PlayerComputer implements Player {
    private final AreaInterface area;
    private final ComputerBrain brain;

    public PlayerComputer(AreaInterface area) {
        this.area = area;
        brain = new ComputerBrainImpl();
        System.out.println( "Comp area is " + area );
    }

    @Override
    public short[] xod(short x, short y) {
        short[] shorts = brain.getComputerHod( area.getAreaIsToWin() );

        if (shorts[0] != -1) {
            area.setTrueValueToArea( shorts[0], shorts[1], 1 );
        }

        return shorts;
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
