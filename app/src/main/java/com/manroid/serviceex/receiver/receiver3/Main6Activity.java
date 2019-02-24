package com.manroid.serviceex.receiver.receiver3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.manroid.serviceex.R;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_QUIT_ACTIVITY");
        intentFilter.addAction("ACTION_NEW_SONG");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("ACTION_NEW_SONG")) {
                    Log.d("FREE_MUSIC", "ACTION_NEW_SONG");
                }else if (intent.getAction().equals("ACTION_QUIT_ACTIVITY")){
                    Log.d("FREE_MUSIC", "ACTION_QUIT_ACTIVITY");
                }

            }
        };

        registerReceiver(broadcastReceiver, intentFilter);
    }

    public void onClickSend(View view) {
        Intent intent = new Intent();
        intent.setAction("ACTION_NEW_SONG");
        sendBroadcast(intent); // Notify the activity that there are no more songs to be played
    }
}
