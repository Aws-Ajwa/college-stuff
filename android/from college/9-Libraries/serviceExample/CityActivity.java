package jo.edu.bau.stanfordsetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import stanford.androidlib.SimpleActivity;

public class CityActivity extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        Intent i=getIntent();
        String x=i.getStringExtra("city");
        TextView tc=$TV(R.id.city_name);
        tc.setText(x);
    }
}
