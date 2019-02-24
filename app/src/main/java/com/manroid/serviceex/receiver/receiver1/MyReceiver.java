package com.manroid.serviceex.receiver.receiver1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.manroid.serviceex.handler.MainActivity;

public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Received an intent.", Toast.LENGTH_SHORT).show();

        if (intent.getAction().equals(Main4Activity.ACTION1)) { //is it our action1?
            Toast.makeText(context, "We received an intent for Action1.", Toast.LENGTH_SHORT).show();
        } else if (intent.getAction().equals(Main4Activity.ACTION2)) { //is it our action2?
            Toast.makeText(context, "We received an intent for Action2.", Toast.LENGTH_SHORT).show();
        }
    }
}