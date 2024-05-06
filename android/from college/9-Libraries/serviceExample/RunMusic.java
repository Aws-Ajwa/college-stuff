package jo.edu.bau.stanfordsetest;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class RunMusic extends Service {

    public RunMusic() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        MediaPlayer mp=MediaPlayer.create(this, R.raw.music);
        mp.start();
        Log.d("Music", "Service has been started..");
        String x=intent.getStringExtra("key1");
        Log.d("Music Output", x);
        Intent s2=new Intent();
        s2.putExtra("key2", "Author name");
        s2.setAction("findauthor");
        sendBroadcast(s2);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
