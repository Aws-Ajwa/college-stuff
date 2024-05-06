package jo.edu.bau.csservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FindFact extends Service {
    public FindFact() {
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        int num=intent.getIntExtra("num1", 1);
        Log.d("Rama", "recived from Activit is "+ num);
        int fact=1;
        for(int i=num; i>=1; i--)
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fact=fact*i;

        }
        Log.d("Rama", "After calculation is "+ fact);

        Intent factIntent=new Intent();
        factIntent.setAction("findfact");
        factIntent.putExtra("fact", fact);
        sendBroadcast(factIntent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
