package com.example.tictactoe12g2025;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class BoardGame extends View {
    private boolean isFirstTime = true;
    Cell[][] arr;

    private int cellWidth, cellHeight;
    private Context context;
    private int count = 0;

    public BoardGame(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        //Paint p = new Paint();
        //canvas.drawCircle(200,200,100,p);
        if(isFirstTime)
        {
            cellWidth = canvas.getWidth()/3;
            cellHeight = cellWidth;

            Bitmap bitmapX = BitmapFactory.decodeResource(getResources(),R.drawable.x);
            Bitmap bitmapO = BitmapFactory.decodeResource(getResources(),R.drawable.o);
            bitmapX = Bitmap.createScaledBitmap(bitmapX,cellWidth-10,cellHeight-10,false);
            bitmapO = Bitmap.createScaledBitmap(bitmapO,cellWidth-10,cellHeight-10,false);

            arr = new Cell[3][3];
            for (int line = 0; line < 3; line++) {
                for (int col = 0; col < 3; col++) {
                    arr[line][col] = new Cell(line*cellWidth, col*cellHeight,bitmapX,bitmapO,cellWidth);
                }
            }
            isFirstTime = false;
        }

        for (int line = 0; line < 3; line++) {
            for (int col = 0; col < 3; col++) {
                arr[line][col].draw(canvas);
            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        int line = (int) (y/cellWidth);
        int col = (int)(x/cellHeight);
        if(line < 3 && col < 3)
        {
            // for fb
            if(arr[line][col].isEmpty() == true)
            {
                ((GameActivity)context).setNewTouch(line,col);
            }
            else
            {
                Toast.makeText(getContext(), "not empty", Toast.LENGTH_SHORT).show();
            }
        }
        else
            Toast.makeText(getContext(), "outside", Toast.LENGTH_SHORT).show();
        return false;
    }

    public void setNewValOnBoard(int line, int col) {
        // this functions calls from GameActivity when new value receive from FB
        if(arr[line][col].setVal(count) == true)
            count = 1 - count;

        invalidate();  // clears the canvas and redraws it by call to onDraw()
    }
}
