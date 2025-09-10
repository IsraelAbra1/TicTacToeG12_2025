package com.example.tictactoe12g2025;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private FbModule fbModule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_game);
        BoardGame boardGame = new BoardGame(this);
        setContentView(boardGame);

        fbModule = new FbModule(this);
    }


    public void setPositionFromFb(Position position) {
    }

    public void setNewTouch(int line, int col) {
        Position position = new Position(line,col);
        fbModule.setPositionInFirebase(position);
    }
}