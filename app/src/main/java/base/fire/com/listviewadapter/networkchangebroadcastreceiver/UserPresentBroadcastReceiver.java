package base.fire.com.listviewadapter.networkchangebroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class UserPresentBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent intent) {

        /*Sent when the user is present after
         * device wakes up (e.g when the keyguard is gone)
         * */
        if(intent.getAction().equals(Intent.ACTION_USER_PRESENT)){
            Toast.makeText(arg0,"user present",Toast.LENGTH_LONG).show();


        }
        /*Device is shutting down. This is broadcast when the device
         * is being shut down (completely turned off, not sleeping)
         * */
        else if (intent.getAction().equals(Intent.ACTION_SHUTDOWN)) {
            Toast.makeText(arg0,"user not present",Toast.LENGTH_LONG).show();


        }
    }

}
