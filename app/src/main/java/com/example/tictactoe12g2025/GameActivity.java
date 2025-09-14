package com.example.tictactoe12g2025;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private BoardGame boardGame;
    private FbModule fbModule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_game);
        boardGame = new BoardGame(this);
        setContentView(boardGame);

        fbModule = new FbModule(this);
    }

    public void setPositionFromFb(Position position) {
        // This function calls from Firebase Module when onDataChange
        int line = position.getLine();
        int col = position.getCol();
        boardGame.setNewValOnBoard(line,col);

    }

    public void setNewTouch(int line, int col) {
        Position position = new Position(line,col);
        fbModule.setPositionInFirebase(position);
    }
}