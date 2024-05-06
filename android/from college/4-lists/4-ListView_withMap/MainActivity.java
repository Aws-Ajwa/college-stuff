package jo.edu.bau.phonecontact2;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String[] name = {"Ali", "Ahmad", "Sara"};
    String[] mobile = {"32432", "453343", "4232"};
    int[] image = {R.drawable.img1, R.drawable.img2, R.drawable.img3};
    ArrayAdapter myAdapyer;
    HashMap<String, String> hm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hm=new HashMap<String, String>();
        for(int i=0; i<name.length; i++)
            hm.put(name[i], mobile[i]);


        ListView myList = (ListView) findViewById(R.id.contactList);
        myAdapyer=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_2,android.R.id.text1 ,hm.keySet().toArray()){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view=super.getView(position, convertView, parent);
                //TextView tv=(TextView) view.findViewById(android.R.id.text1);
                TextView tv2=(TextView) view.findViewById(android.R.id.text2);
                //ImageView iv=(ImageView) view.findViewById(android.R.id.icon);
                // tv.setText(name[position]);
                tv2.setText(hm.get(myAdapyer.getItem(position)));
                //iv.setImageResource(image[position]);

                return view;
            }
        };
        myList.setAdapter(myAdapyer);
    }
}