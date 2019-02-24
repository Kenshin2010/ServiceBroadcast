package com.manroid.serviceex.receiver.receiver1;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.manroid.serviceex.R;
import com.manroid.serviceex.handler.MainActivity;

public class Main4Activity extends AppCompatActivity {
    //declare the intent names here, except if change ACTION1, fix it in AndroidManifest.xml as well.
    public static final String ACTION1 = "edu.cs4730.bcr.mystaticevent";
    public static final String ACTION2 = "edu.cs4730.bcr.mydyanicevent";

    String TAG = "MainActivity";

    MyReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        //need to initialize the variable here.
        mReceiver = new MyReceiver();

    }

    @Override
    public void onResume() {
        super.onResume();
        // Register mReceiver to receive messages.  This is using the local broadcast, instead of a global.
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter(ACTION2));
        //the one below registers a global receiver.
        //registerReceiver(mReceiver, new IntentFilter(ACTION2));
        //Log.v(TAG, "receiver should be registered");
    }

    @Override
    protected void onPause() {  //or onDestory()
        // Unregister since the activity is not visible.  This is using the local broadcast, instead of a global.
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
        //the one below unregisters a global receiver.
        //unregisterReceiver(mReceiver);
        Log.v(TAG, "receiver should be unregistered");
        super.onPause();

    }

    public void onClickButton1(View view) {
        Intent i = new Intent(Main4Activity.ACTION1);
        i.setPackage("com.manroid.serviceex"); //in API 26, it must be explicit now.
        //since it's registered as a global (in the manifest), use sendBroadCast
        //LocalBroadcastManager.getInstance(getContext()).sendBroadcast(i);
        sendBroadcast(i);
    }

    public void onClickButton2(View view) {
        Intent i = new Intent(Main4Activity.ACTION2);
        //since it's registered a local, use the LocalBroadcastManager.
        LocalBroadcastManager.getInstance(this).sendBroadcast(i);
        //use this if registered as a global receiver.
        //getActivity().sendBroadcast(i);
        Log.v(TAG, "Should have sent the broadcast.");
    }
}