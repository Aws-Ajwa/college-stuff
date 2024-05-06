package com.example.lab4;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
// task from my head similar to task one:
public class MainActivity extends AppCompatActivity {
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView[] arrImg = new ImageView[4];
        arrImg[0] = findViewById(R.id.img1);
        arrImg[1] = findViewById(R.id.img2);
        arrImg[2] = findViewById(R.id.img3);
        arrImg[3] = findViewById(R.id.img4);
        ImageView img = findViewById(R.id.img);
        Button BP = (Button)findViewById(R.id.Bprev);
        Button BN = (Button)findViewById(R.id.Bnext);
        BP.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (i == 0){
                    return;
                } else {
                   img.setVisibility(View.GONE);
                   arrImg[i].setVisibility(View.GONE);
                   i--;
                   arrImg[i].setVisibility(View.VISIBLE);
                }
            }
        });
        BN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (i == 3){
                    return;
                } else {
                    img.setVisibility(View.GONE);
                    arrImg[i].setVisibility(View.GONE);
                    i++;
                    arrImg[i].setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
/////////////////////////////////////////////////////////////////////
// task 2 in lap4 slides
package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View v){
        ImageView iv = (ImageView) findViewById(R.id.iv);
        if (v.getId() == R.id.square){
            iv.setImageResource(R.drawable.square);
        } else if (v.getId() ==  R.id.cercle){
            iv.setImageResource(R.drawable.cercle);
        } else if (v.getId() ==  R.id.Rectangle){
            iv.setImageResource(R.drawable.rectangle);
        } else if (v.getId() == R.id.Parallelogram){
            iv.setImageResource(R.drawable.parallelogram);
        } if (v.getId() == R.id.triangle){
            iv.setImageResource(R.drawable.triangle);
        }
    }
}