package com.example.tictactoe12g2025;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Cell
{
    final int Xval=0;
    final int Oval=1;

    final int EmptyVal=2;
 private  int x,y;
    private  int cellWith;
  Bitmap bitmapX,bitmapO;
    private int val;
    private Paint p;

    public Cell(int x, int y, Bitmap bitmapX, Bitmap bitmapO, int cellWith) {
        this.x = x;
        this.y = y;
        this.bitmapO = bitmapO;
        this.bitmapX = bitmapX;
        this.cellWith = cellWith;

        this.val=EmptyVal;
        this.p=new Paint();
    }

    public void draw(Canvas canvas)
    {
        p.setStrokeWidth(30);
        p.setStyle(Paint.Style.STROKE);
        canvas.drawRect(x,y,x+cellWith,y+cellWith,p);
        if(val == Xval)
            canvas.drawBitmap(bitmapX,x+10,y+10,null);
        if(val == Oval)
            canvas.drawBitmap(bitmapO,x+10,y+10,null);
    }

    public boolean isEmpty() {
        return val==EmptyVal;
    }

    public boolean setVal(int val) {
        if(this.val == EmptyVal)
        {
            this.val = val;
            return true;
        }
        return false;
    }
}


