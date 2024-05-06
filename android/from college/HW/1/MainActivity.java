package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int gen_Num;
    EditText enterd_NumTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rand = new Random();
        gen_Num = rand.nextInt(1000);
    }


    public void OnClickSubmit(View view){
        enterd_NumTxt = findViewById(R.id.entered_num);
        int guess = Integer.parseInt(enterd_NumTxt.getText().toString());
            if (guess > gen_Num) {
                Toast.makeText(this, "the right answer is lower",Toast.LENGTH_SHORT).show();
            }else if(guess < gen_Num){
                Toast.makeText(this,"the right answer is higher",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this ,"you guessed the right number" ,Toast.LENGTH_LONG).show();
            }
        }
    }

