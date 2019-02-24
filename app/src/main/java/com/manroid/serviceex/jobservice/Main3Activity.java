package com.manroid.serviceex.jobservice;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.manroid.serviceex.R;
import com.manroid.serviceex.handler.MainActivity;

public class Main3Activity extends AppCompatActivity {

    EditText et_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_input = (EditText) findViewById(R.id.editText);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                MyJobService.scheduleJob(Main3Activity.this, Integer.valueOf(et_input.getText().toString()), false);  //Main3Activity context, not listener...
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                MyJobService.scheduleJob(Main3Activity.this, Integer.valueOf(et_input.getText().toString()), true);  //Main3Activity context, not listener...
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                MyJobService.cancelJob(Main3Activity.this);
            }
        });

    }
}