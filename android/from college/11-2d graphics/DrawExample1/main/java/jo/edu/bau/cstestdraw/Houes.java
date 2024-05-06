package jo.edu.bau.cstestdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Houes extends View {
    public Houes(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
int x=0;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p1=new Paint();
        p1.setARGB(255, 255, 255, 0);
        canvas.drawRect(300, 400, 600, 900, p1);
        Path path=new Path();
        path.moveTo(250, 400);
        path.lineTo(450, 100);;
        path.lineTo(650, 400);
        path.close();
        canvas.drawPath(path, new Paint());
        canvas.drawText("Hello World",100,100,new Paint() );
        x+=10;
        invalidate();
    }
}
