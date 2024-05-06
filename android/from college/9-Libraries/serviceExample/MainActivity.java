package jo.edu.bau.stanfordsetest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import stanford.androidlib.SimpleActivity;
import stanford.androidlib.SimpleList;

public class MainActivity extends SimpleActivity {
    String[] cities = {"Amman", "Al-salt", "Aqaba"};
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent s=new Intent(this, RunMusic.class);
        s.putExtra("key1", "music name");
        startService(s);
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

            }
        });
        TextView tv = $TV(R.id.text1);
        ListView lv = $LV(R.id.list1);
        tv.setText("List of Cities");
        tv.setTextSize(30);
        SimpleList.with(this)
                .setItems(lv, cities);
        lv.setOnItemClickListener(this);
        //broadcast receiverreigiseter
        IntentFilter  filter=new IntentFilter();
        filter.addAction("findauthor");

        registerReceiver(new Receiver(),filter );


    }

    @Override
    public void onItemClick(ListView list, int index) {
        super.onItemClick(list, index);
      // toast("position is "+index);
      //  tts.speak("Welcome to "+cities[index], TextToSpeech.QUEUE_FLUSH, null);
        Intent i=new Intent(this, CityActivity.class);
        i.putExtra("city", cities[index]);
        startActivity(i);


    }
private class  Receiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("findauthor"))
        {
            String x=intent.getStringExtra("key2");
            Log.d("Music Broadcast", x);
        }
    }
}
}

