package jo.edu.bau.drawingpanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class DrawingPanel extends View{
    float x=0, y=0;
    int mouth=1;
    int dir=1; // moving to right
    float x2,y2;
    public DrawingPanel(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d("keyboard",keyCode+"");
        if(keyCode==19)
            dir=4;
        if(keyCode==20)
            dir=3;
        if(keyCode==21)
            dir=1;
        if(keyCode==22)
            dir=2;
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            float x2,y2;
            x2=event.getX();
            y2=event.getY();
            if(x2>x )
            {
                dir=1;
            }else if (x2<x)
            {
                dir=2;
            }
            else if(y2>y)
            {
                dir=3;
            }
            else if(y2<y)
            {
                dir=4;
            }

            invalidate();
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       // canvas.drawColor(Color.BLUE);
        try {Paint p1=new Paint();
        p1.setARGB(255, 255, 0, 0);
        p1.setTypeface(Typeface.create("Arial", Typeface.BOLD_ITALIC));
        p1.setTextSize(80);
        if(dir==1) // left to right
        {
            if (mouth == 1) {
                canvas.drawArc(new RectF(x, y, 200 + x, y+200), 45, 270, true, p1);
                mouth = 2;
            } else {
                canvas.drawArc(new RectF(x, y, 200 + x, y+200), 15, 330, true, p1);
                mouth = 1;
            }
        }
        else if(dir==2)//right to left
        {
            if (mouth == 1) {
                canvas.drawArc(new RectF(x, y, 200 + x, y+200), 225, 270, true, p1);
                mouth = 2;
            } else {
                canvas.drawArc(new RectF(x, y, 200 + x, y+200), 210, 330, true, p1);
                mouth = 1;
            }
        }
        else if(dir==3)//top to buttom
        {
            if (mouth == 1) {
                canvas.drawArc(new RectF(x, y, 200 + x, y+200), 135, 270, true, p1);
                mouth = 2;
            } else {
                canvas.drawArc(new RectF(x, y, 200 + x, y+200), 105, 330, true, p1);
                mouth = 1;
            }
        }
        else if(dir==4)//down to Up
        {
            if (mouth == 1) {
                canvas.drawArc(new RectF(x, y, 200 + x, y+200), 315, 270, true, p1);
                mouth = 2;
            } else {
                canvas.drawArc(new RectF(x, y, 200 + x, y+200), 285, 330, true, p1);
                mouth = 1;
            }
        }
        if(x>this.getMeasuredWidth()-200 && dir==1)
            dir=3;
        else if(y>this.getMeasuredHeight()-200 && dir==3)
            dir=2;
        else if(x<0 && dir==2)
            dir=4;
        else if(y<0 && dir==4)
            dir=1;


        if(dir==1 && x<=(this.getMeasuredWidth()-200))
            x+=50;
        else if(dir==2)
            x-=50;
        else if(dir==3)
            y+=50;
        else if(dir==4)
            y-=50;
        invalidate();
        }catch(Exception e){}
        Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.one);
        canvas.drawBitmap(bitmap, 0,0, new Paint());
    }
}
