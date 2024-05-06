package com.example.listview_usingintents;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        
        Intent intent = getIntent();
        String extra = intent.getStringExtra( "Course");
        TextView tv = findViewById(R.id.textView);
        tv.setText("selected course is "+extra);


    }

}