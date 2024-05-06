package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        EditText editT = findViewById(R.id.ET);
        btn.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Intent intent = new Intent(MainActivity.this , MainActivity2.class);
               int ItemNum = Integer.parseInt(editT.getText().toString());
               intent.putExtra("ItemNum" , ItemNum);
               startActivity(intent);
           }
        });
    }
}