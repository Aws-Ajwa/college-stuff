package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent2 = getIntent();
        int ItemNum = intent2.getIntExtra("ItemNum",0);
        EditText arrE[] = new EditText[ItemNum];
        TextView arrT[] = new TextView[ItemNum];
        LinearLayout arrL[] = new LinearLayout[ItemNum];

        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                                          ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                          ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                          ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout myLayout = new LinearLayout(this);
        myLayout.setOrientation(LinearLayout.VERTICAL);
        myLayout.setLayoutParams(params3);
        setContentView(myLayout);

        for (int i = 0 , j = 1; i < ItemNum; i++ , j++) {
            arrL[i] = new LinearLayout(this);
            arrL[i].setLayoutParams(params2);
            arrL[i].setOrientation(LinearLayout.HORIZONTAL);

            arrE[i] = new EditText(this);
            arrE[i].setHint("Prise");
            arrE[i].setInputType(InputType.TYPE_CLASS_NUMBER);
            arrE[i].setLayoutParams(params2);

            arrT[i] = new TextView(this);
            arrT[i].setTextSize(20);
            arrT[i].setLayoutParams(params1);
            arrT[i].setText("   Item "+ j);

            arrL[i].addView(arrT[i]);
            arrL[i].addView(arrE[i]);
            myLayout.addView(arrL[i]);
        }
        Button btn = new Button(this);
        btn.setLayoutParams(params2);
        btn.setText("Calculate Price");
        myLayout.addView(btn);
        TextView Tv = new TextView(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = 0;
                for (int i = 0; i < ItemNum; i++) {
                    sum += Integer.parseInt(arrE[i].getText().toString());
                }
                Tv.setLayoutParams(params2);
                Tv.setText("the Total Price is: "+sum);
                Tv.setGravity(Gravity.CENTER);
                Tv.setTextSize(20);
                myLayout.addView(Tv);
            }
        });
    }
}