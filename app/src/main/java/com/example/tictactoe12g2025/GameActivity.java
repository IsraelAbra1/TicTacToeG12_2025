package com.example.tictactoe12g2025;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private BoardGame boardGame;
    private GameModule gameModule;
    private FbModule fbModule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_game);
        boardGame = new BoardGame(this);
        gameModule = new GameModule();
        setContentView(boardGame);

        fbModule = new FbModule(this);
    }

    public void setPositionFromFb(Position position) {
        // This function calls from Firebase Module when onDataChange
        int line = position.getLine();
        int col = position.getCol();
        boardGame.setNewValOnBoard(line,col);
        // TODO: 16/09/2025  call to isWin()
        int isWin = gameModule.isWin(boardGame.arr);
        if(isWin == GameModule.xWin)
            Toast.makeText(this, "X Win", Toast.LENGTH_SHORT).show();
        else
            if(isWin == GameModule.oWin)
                Toast.makeText(this, "O Win", Toast.LENGTH_SHORT).show();
            else
            Toast.makeText(this, "No Win", Toast.LENGTH_SHORT).show();
    }

    public void setNewTouch(int line, int col) {
        Position position = new Position(line,col);
        fbModule.setPositionInFirebase(position);
    }
}