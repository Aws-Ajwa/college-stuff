package jo.edu.bau.csservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class FactReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if (intent.getAction().equals("findfact"))
        {
            int x=intent.getIntExtra("fact",0);
            Log.d("Rama", "from receiver is "+x);
        }
        else if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED))
        {
            Log.d("Rama", "Power has been connected");

        }
        else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED))
        {
            Log.d("Rama", "Power has been switched off");

        }    }
}
