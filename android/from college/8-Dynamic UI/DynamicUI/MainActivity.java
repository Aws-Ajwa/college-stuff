package jo.edu.bau.listviewexample;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int b1ID=1000;
        int b2ID=2000;
        RelativeLayout myRelative=new RelativeLayout(this);
        Display display=getWindowManager().getDefaultDisplay();
        Point size=new Point();
        display.getSize(size);

        Button b1=new Button(this);
        b1.setText("Button 1");
        b1.setId(b1ID);
        RelativeLayout.LayoutParams b1Param=new RelativeLayout.LayoutParams(size.x/2, size.y/2);
        b1Param.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        myRelative.addView(b1, b1Param);


        Button b2=new Button(this);
        b2.setText("Button 2");
        b2.setId(b2ID);
        RelativeLayout.LayoutParams b2Param=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        b2Param.addRule(RelativeLayout.BELOW,b1ID);
        myRelative.addView(b2, b2Param);

        Button b3=new Button(this);
        b3.setText("Button 3");
        RelativeLayout.LayoutParams b3Param=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        b3Param.addRule(RelativeLayout.BELOW, b1ID);
        b3Param.addRule(RelativeLayout.RIGHT_OF,b2ID );
        myRelative.addView(b3, b3Param);

        setContentView(myRelative);


    }
}
