package com.manroid.serviceex.receiver.receiver2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.manroid.serviceex.R;

public class Main5Activity extends AppCompatActivity {

    TextView logger;
    MyReceiver mReceiver = new MyReceiver();
    String TAG = "MainFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        //need to initialize the variable here.
        logger = findViewById(R.id.textView1);

    }

    @Override
    public void onResume() {
        super.onResume();
        //the one below registers a global receiver.
        IntentFilter myIF = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
        myIF.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        myIF.addAction("android.intent.action.BATTERY_LOW");
        myIF.addAction("android.intent.action.BATTERY_OKAY");
        registerReceiver(mReceiver, myIF);
        Log.v(TAG, "receiver should be registered");
    }

    @Override
    public void onPause() {  //or onDestory()
        unregisterReceiver(mReceiver);
        Log.v(TAG, "receiver should be unregistered");
        super.onPause();

    }


    public class MyReceiver extends BroadcastReceiver {
        public MyReceiver() {
        }

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.v("myReceiver", "received an intent");
            String info = "\n something wrong.";
            int mStatus = 0;
            if (intent.getAction().equals(Intent.ACTION_BATTERY_LOW)) {  //battery is low!
                info = "\n batter low. should shut down things.";
                mStatus = 1;
                Log.v("myReceiver", "battery low");
            } else if (intent.getAction().equals(Intent.ACTION_BATTERY_OKAY)) {  //battery is now ok!
                info = "\n battery Okay.  ";
                mStatus = 2;
                Log.v("myReceiver", "battery okay");
            } else if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {  //battery is charging.
                info = "\n Power connected, so phone is charging.";
                mStatus = 3;
                Log.v("myReceiver", "ac on");
            } else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {  //power has been disconnected.
                info = "\n Power disconnected.";
                mStatus = 4;
                Log.v("myReceiver", "ac off");
            }
            logger.setText("status is " + mStatus + info);
        }
    }

}