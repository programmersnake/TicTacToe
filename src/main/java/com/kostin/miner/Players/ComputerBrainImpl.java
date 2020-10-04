package com.kostin.miner.Players;

public class ComputerBrainImpl implements ComputerBrain {

    @Override
    public short[] getComputerHod(int[][] area) {
        short[] shorts = new short[2];

        winnerTactikStep( area, shorts );

        return shorts;
    }

    private void linearStep(int[][] area, short[] shorts) {
        if (area[0][0] == 0) {
            shorts[0] = 0;
            shorts[1] = 0;
        } else if (area[0][1] == 0) {
            shorts[0] = 0;
            shorts[1] = 1;
        } else if (area[0][2] == 0) {
            shorts[0] = 0;
            shorts[1] = 2;
        } else if (area[1][0] == 0) {
            shorts[0] = 1;
            shorts[1] = 0;
        } else if (area[1][1] == 0) {
            shorts[0] = 1;
            shorts[1] = 1;
        } else if (area[1][2] == 0) {
            shorts[0] = 1;
            shorts[1] = 2;
        } else if (area[2][0] == 0) {
            shorts[0] = 2;
            shorts[1] = 0;
        } else if (area[2][1] == 0) {
            shorts[0] = 2;
            shorts[1] = 1;
        } else if (area[2][2] == 0) {
            shorts[0] = 2;
            shorts[1] = 2;
        } else {
            shorts[0] = -1;
            shorts[1] = -1;
        }
    }

    private void winnerTactikStep(int[][] area, short[] shorts) {
        if (area[1][1] == 0) {
            shorts[0] = 1;
            shorts[1] = 1;
            System.out.println( "winnerTactiktoeStep " + 0 );
        }

        //      The Last Win Step
        else if ((area[0][0] == 1) && (area[0][2] == 1) && (area[0][1] == 0)) {
            shorts[0] = 0;
            shorts[1] = 1;
            System.out.println( "winnerTactiktoeStep " + 1 );
        } else if ((area[0][0] == 1) && (area[2][0] == 1) && (area[1][0] == 0)) {
            shorts[0] = 1;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 2 );
        } else if ((area[2][0] == 1) && (area[2][2] == 1) && (area[2][1] == 0)) {
            shorts[0] = 2;
            shorts[1] = 1;
            System.out.println( "winnerTactiktoeStep " + 3 );
        } else if ((area[0][2] == 1) && (area[2][2] == 1) && (area[1][2] == 0)) {
            shorts[0] = 1;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 4 );
        } else if ((area[1][1] == 1) && (area[2][1] == 1) && (area[0][1] == 0)) {
            shorts[0] = 0;
            shorts[1] = 1;
            System.out.println( "winnerTactiktoeStep " + 5 );
        } else if ((area[1][1] == 1) && (area[1][2] == 1) && (area[1][0] == 0)) {
            shorts[0] = 1;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 6 );
        } else if ((area[1][1] == 1) && (area[1][0] == 1) && (area[1][2] == 0)) {
            shorts[0] = 1;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 7 );
        } else if ((area[0][1] == 1) && (area[1][1] == 1) && (area[2][1] == 0)) {
            shorts[0] = 2;
            shorts[1] = 1;
            System.out.println( "winnerTactiktoeStep " + 8 );
        } else if ((area[0][1] == 1) && (area[0][2] == 1) && (area[0][0] == 0)) {
            shorts[0] = 0;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 9 );
        } else if ((area[1][0] == 1) && (area[2][0] == 1) && (area[0][0] == 0)) {
            shorts[0] = 0;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 10 );
        } else if ((area[1][1] == 1) && (area[2][2] == 1) && (area[0][0] == 0)) {
            shorts[0] = 0;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 11 );
        } else if ((area[0][0] == 1) && (area[0][1] == 1) && (area[0][2] == 0)) {
            shorts[0] = 0;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 12 );
        } else if ((area[2][2] == 1) && (area[1][2] == 1) && (area[0][2] == 0)) {
            shorts[0] = 0;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 13 );
        } else if ((area[1][1] == 1) && (area[2][0] == 1) && (area[0][2] == 0)) {
            shorts[0] = 0;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 14 );
        } else if ((area[0][0] == 1) && (area[1][0] == 1) && (area[2][0] == 0)) {
            shorts[0] = 2;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 15 );
        } else if ((area[2][2] == 1) && (area[2][1] == 1) && (area[2][0] == 0)) {
            shorts[0] = 2;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 16 );
        } else if ((area[1][1] == 1) && (area[0][2] == 1) && (area[2][0] == 0)) {
            shorts[0] = 2;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 17 );
        } else if ((area[0][0] == 1) && (area[1][1] == 1) && (area[2][2] == 0)) {
            shorts[0] = 2;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 18 );
        } else if ((area[0][2] == 1) && (area[1][2] == 1) && (area[2][2] == 0)) {
            shorts[0] = 2;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 19 );
        } else if ((area[2][0] == 1) && (area[2][1] == 1) && (area[2][2] == 0)) {
            shorts[0] = 2;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 20 );
        }

        //    Protection
        else if ((area[0][1] == 2) && (area[0][2] == 2) && (area[0][0] == 0)) {
            shorts[0] = 0;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 50 );
        } else if ((area[1][0] == 2) && (area[2][0] == 2) && (area[0][0] == 0)) {
            shorts[0] = 0;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 51 );
        } else if ((area[1][1] == 2) && (area[2][2] == 2) && (area[0][0] == 0)) {
            shorts[0] = 0;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 52 );
        } else if ((area[0][0] == 2) && (area[0][2] == 2) && (area[0][1] == 0)) {
            shorts[0] = 0;
            shorts[1] = 1;
            System.out.println( "winnerTactiktoeStep " + 53 );
        } else if ((area[1][1] == 2) && (area[2][1] == 2) && (area[0][1] == 0)) {
            shorts[0] = 0;
            shorts[1] = 1;
            System.out.println( "winnerTactiktoeStep " + 54 );
        } else if ((area[0][0] == 2) && (area[0][1] == 2) && (area[0][2] == 0)) {
            shorts[0] = 0;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 55 );
        } else if ((area[1][2] == 2) && (area[2][2] == 2) && (area[0][2] == 0)) {
            shorts[0] = 0;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 56 );
        } else if ((area[1][1] == 2) && (area[2][0] == 2) && (area[0][2] == 0)) {
            shorts[0] = 0;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 57 );
        } else if ((area[0][0] == 2) && (area[2][0] == 2) && (area[1][0] == 0)) {
            shorts[0] = 1;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 58 );
        } else if ((area[1][1] == 2) && (area[1][2] == 2) && (area[1][0] == 0)) {
            shorts[0] = 1;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 59 );
        } else if ((area[0][1] == 2) && (area[2][1] == 2) && (area[1][1] == 0)) {
            shorts[0] = 1;
            shorts[1] = 1;
            System.out.println( "winnerTactiktoeStep " + 60 );
        } else if ((area[1][0] == 2) && (area[1][2] == 2) && (area[1][1] == 0)) {
            shorts[0] = 1;
            shorts[1] = 1;
            System.out.println( "winnerTactiktoeStep " + 61 );
        } else if ((area[0][0] == 2) && (area[2][2] == 2) && (area[1][1] == 0)) {
            shorts[0] = 1;
            shorts[1] = 1;
            System.out.println( "winnerTactiktoeStep " + 62 );
        } else if ((area[0][2] == 2) && (area[2][0] == 2) && (area[1][1] == 0)) {
            shorts[0] = 1;
            shorts[1] = 1;
            System.out.println( "winnerTactiktoeStep " + 63 );
        } else if ((area[0][2] == 2) && (area[2][2] == 2) && (area[1][2] == 0)) {
            shorts[0] = 1;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 64 );
        } else if ((area[1][0] == 2) && (area[1][1] == 2) && (area[1][2] == 0)) {
            shorts[0] = 1;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 65 );
        } else if ((area[0][0] == 2) && (area[1][0] == 2) && (area[2][0] == 0)) {
            shorts[0] = 2;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 66 );
        } else if ((area[2][1] == 2) && (area[2][2] == 2) && (area[2][0] == 0)) {
            shorts[0] = 2;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 67 );
        } else if ((area[1][1] == 2) && (area[0][2] == 2) && (area[2][0] == 0)) {
            shorts[0] = 2;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 68 );
        } else if ((area[0][1] == 2) && (area[1][1] == 2) && (area[2][1] == 0)) {
            shorts[0] = 2;
            shorts[1] = 1;
            System.out.println( "winnerTactiktoeStep " + 69 );
        } else if ((area[2][0] == 2) && (area[2][2] == 2) && (area[2][1] == 0)) {
            shorts[0] = 2;
            shorts[1] = 1;
            System.out.println( "winnerTactiktoeStep " + 70 );
        } else if ((area[2][0] == 2) && (area[2][1] == 2) && (area[2][2] == 0)) {
            shorts[0] = 2;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 71 );
        } else if ((area[0][2] == 2) && (area[1][2] == 2) && (area[2][2] == 0)) {
            shorts[0] = 2;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 72 );
        } else if ((area[0][0] == 2) && (area[1][1] == 2) && (area[2][2] == 0)) {
            shorts[0] = 2;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 73 );
        } else if (area[0][0] == 0) {
            shorts[0] = 0;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 21 );
        } else if (area[0][2] == 0) {
            shorts[0] = 0;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 22 );
        }

        //   Angles
        else if (area[2][0] == 0) {
            shorts[0] = 2;
            shorts[1] = 0;
            System.out.println( "winnerTactiktoeStep " + 23 );
        } else if (area[2][2] == 0) {
            shorts[0] = 2;
            shorts[1] = 2;
            System.out.println( "winnerTactiktoeStep " + 24 );
        } else {
            linearStep( area, shorts );
            System.out.println( "winnerTactiktoeStep " + 25 );
        }
    }
}
