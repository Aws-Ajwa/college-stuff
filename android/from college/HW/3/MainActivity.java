package com.example.randomtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
///////////// one btn and one ET from the input of ET we go to another activity
// and make input number of TV and ET and sum the ET entries

    TextView TV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText Et1 = findViewById(R.id.item1);
        Button btnSum = findViewById(R.id.btn_sum);
        TV = findViewById(R.id.TextView);

        btnSum.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Intent intent = new Intent(MainActivity.this , MainActivity2.class);
               if (null == Integer.parseInt(Et1.getText().toString())){

               }
               int num1 = Integer.parseInt(Et1.getText().toString());
               intent.putExtra("num1",num1);
               startActivity(intent);
           }
        });
    }
}