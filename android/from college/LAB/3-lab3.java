import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveB = findViewById(R.id.saveB);
        Button openB = findViewById(R.id.openB);
        CheckBox autoS = findViewById(R.id.autosave);
        CheckBox star = findViewById(R.id.star);
        RadioGroup Rg = findViewById(R.id.RG);
        saveB.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
             Toast.makeText(MainActivity.this,"you Clicked on Save Button",Toast.LENGTH_LONG).show();
           }
        });
        openB.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Toast.makeText(MainActivity.this,"you Clicked on open Button",Toast.LENGTH_LONG).show();
           }
        });
        autoS.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (autoS.isChecked()){
                    Toast.makeText(MainActivity.this,"you Checked CheckBox Button",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this,"you unChecked CheckBox Button",Toast.LENGTH_LONG).show();
                }
            }
        });
        star.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(star.isChecked()){
                    Toast.makeText(MainActivity.this,"you Checked StarCheckBox Button",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this,"you unChecked StarCheckBox Button",Toast.LENGTH_LONG).show();
                }
            }
        });
       Rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
           @Override
           public void onCheckedChanged(RadioGroup r , int id){
               if(id == R.id.RB1){
                   Toast.makeText(MainActivity.this,"you Checked radio Button1",Toast.LENGTH_LONG).show();
               } else{
                   Toast.makeText(MainActivity.this,"you Checked radio Button2",Toast.LENGTH_LONG).show();
               }
           }
       });
    }
}
/////////////////////////////////////////////////////////////////////////////////////////
//task1:
// package com.example.lab_1;

// import androidx.appcompat.app.AppCompatActivity;

// import android.os.Bundle;
// import android.view.View;
// import android.widget.Button;
// import android.widget.CheckBox;
// import android.widget.EditText;
// import android.widget.RadioGroup;
// import android.widget.Toast;

// public class MainActivity extends AppCompatActivity {

//     @Override
//     protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.activity_main);
//         Button B1 = findViewById(R.id.B1);
//         EditText ET = findViewById(R.id.ET);
//         B1.setOnClickListener(new View.OnClickListener(){
//             @Override
//             public void onClick(View v){
//                 double fahrenheit = (9 *  Double.parseDouble(ET.getText().toString()))/5+32;
//                 Toast.makeText(MainActivity.this, "the Degree in fahrenheit is="+fahrenheit, Toast.LENGTH_SHORT).show();
//             }
//         });
//     }
// }
// // fahrenheit = (9/5) * celsius+32
//////////////////////////////////////////////////////////////////////////////////
// task2:
// package com.example.lab_1;

// import androidx.appcompat.app.AppCompatActivity;

// import android.os.Bundle;
// import android.view.View;
// import android.widget.Button;
// import android.widget.CheckBox;
// import android.widget.EditText;
// import android.widget.RadioGroup;
// import android.widget.Toast;

// public class MainActivity extends AppCompatActivity {

//     @Override
//     protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.activity_main);
//         Button B1 = findViewById(R.id.B1);
//         EditText ET = findViewById(R.id.ET);
//         B1.setOnClickListener(new View.OnClickListener(){
//             @Override
//             public void onClick(View v){
//                 Double fact = Factorial(Double.parseDouble(ET.getText().toString()));
//                 Toast.makeText(MainActivity.this, "the Factorial is= "+ fact,Toast.LENGTH_LONG).show();
//             }
//         });
//     }
//     public Double Factorial(Double num){
//         if(num == 0)
//             return 1.0;
//         return (num * Factorial(num-1));
//     }
// }
