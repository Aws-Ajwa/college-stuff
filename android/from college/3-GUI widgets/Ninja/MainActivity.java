package jo.edu.bau.myapplication222;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void radioClick(View view) {
        ImageView iv=(ImageView) findViewById(R.id.imageview);
        int id=view.getId();
        if(id==R.id.i1)
            iv.setImageResource(R.drawable.img1);
        else if(id==R.id.i2)
            iv.setImageResource(R.drawable.img2);
        else if(id==R.id.i3)
            iv.setImageResource(R.drawable.img3);
        else
            iv.setImageResource(R.drawable.img4);

    }
}
