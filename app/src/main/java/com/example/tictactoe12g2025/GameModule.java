package com.example.tictactoe12g2025;

public class GameModule {
    public static int xWin = 0;
    public static int oWin = 1;
    public static int noWin = 2;
    public int isWin2(Cell[][] arr)
    {
        if(!arr[0][0].isEmpty()
                && arr[0][0].getVal() == arr[0][1].getVal()
                && arr[0][0].getVal() == arr[0][2].getVal())
            return arr[0][0].getVal();

        return noWin;
    }

    public int isWin(Cell[][] arr)
    {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (!arr[i][0].isEmpty()
                    && arr[i][0].getVal() == arr[i][1].getVal()
                    && arr[i][0].getVal() == arr[i][2].getVal()) {
                return arr[i][0].getVal();
            }
        }

        // check columns
        for (int j = 0; j < 3; j++) {
            if (!arr[0][j].isEmpty()
                    && arr[0][j].getVal() == arr[1][j].getVal()
                    && arr[0][j].getVal() == arr[2][j].getVal()) {
                return arr[0][j].getVal();
            }
        }

        // check main diagonal
        if (!arr[0][0].isEmpty()
                && arr[0][0].getVal() == arr[1][1].getVal()
                && arr[0][0].getVal() == arr[2][2].getVal()) {
            return arr[0][0].getVal();
        }

        // check anti-diagonal
        if (!arr[0][2].isEmpty()
                && arr[0][2].getVal() == arr[1][1].getVal()
                && arr[0][2].getVal() == arr[2][0].getVal()) {
            return arr[0][2].getVal();
        }

        // no winner
        return noWin;
    }

}
