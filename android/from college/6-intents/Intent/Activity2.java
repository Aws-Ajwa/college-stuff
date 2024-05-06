package jo.edu.bau.lifecycle_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        TextView tv=(TextView) findViewById(R.id.text2);
        Intent i2=getIntent();
        String x=i2.getStringExtra("name");
        tv.setText("Hello "+x);
    }

    public void onBackClick(View view) {
        finish();
    }
}
