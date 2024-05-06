package jo.edu.bau.listviewexample;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PrintStream output= null;
        try {
            File outDir=getExternalFilesDir(null);
            File outFile=new File(outDir, "AICollege");
            output = new PrintStream(outFile);
            output.println("Salt");
            output.println("Amman");
            output.println("Madaba");
            output.println("Ajloun");
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try{

            File outDir=getExternalFilesDir(null);
            File outFile=new File(outDir, "AICollege");
        Scanner input=new Scanner(outFile);
        String s="";
        while(input.hasNextLine())
         s+=input.nextLine()+"\n";
        TextView tv=findViewById(R.id.city);
        tv.setText(s);
        }catch (Exception e)
        {

        }





    }
}
