package jo.edu.bau.lifecycle_3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp=MediaPlayer.create(this,R.raw.music2 );
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mp.start();
    }

    public void onNextClick(View view) {
        EditText et=(EditText) findViewById(R.id.inputText);
        String x=et.getText().toString();
        Intent i=new Intent(this, Activity2.class);
        i.putExtra("name", x);
        startActivity(i);
    }
}
