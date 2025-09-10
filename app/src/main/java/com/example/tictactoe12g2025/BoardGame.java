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

        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            float x = event.getX();
            float y = event.getY();

            int line = (int) (y/cellHeight);
            int col = (int) (x/cellWidth);
            if(line < 3 && col < 3)
            {
                ;
            }
            else
            {
                Toast.makeText(context, "outside", Toast.LENGTH_SHORT).show();
                return false;
            }


            ((GameActivity)context).setNewTouch(0,0);

        }


        return false;
    }
}
