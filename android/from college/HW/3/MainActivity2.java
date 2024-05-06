package com.example.randomtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;



public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent2 = getIntent();
        int ItemNum = intent2.getIntExtra("num1",0);

        LinearLayout outerLayout = new LinearLayout(this);
        outerLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        outerLayout.setLayoutParams(params);

        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);


        EditText[] arrE = new EditText[ItemNum];
        TextView[] arrT = new TextView[ItemNum];

        setContentView(outerLayout);
        for (int i = 0; i <ItemNum ; i++) {
            LinearLayout innerL = new LinearLayout(this);

            arrT[i] = new TextView(this);
            arrT[i].setText("Item "+ (i+1));

            arrE[i] = new EditText(this);


            innerL.addView(arrT[i]);
            innerL.addView(arrE[i]);
            outerLayout.addView(innerL);
        }
        Button btn = new Button(this);
        btn.setText("Calculate");
        outerLayout.addView(btn);
        TextView Tv =new TextView(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum = 0;
                for (int i = 0; i < ItemNum; i++) {
                    sum += Integer.parseInt(arrE[i].getText().toString());
                }
                Tv.setLayoutParams(params2);
                Tv.setText("the Total Price is: "+sum);
                Tv.setTextSize(10);
                outerLayout.addView(Tv);
            }
        });
    }
}