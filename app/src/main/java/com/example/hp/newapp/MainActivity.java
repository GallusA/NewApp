package com.example.hp.newapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // mDynamicReceiver myDymamicReceiver = new mDynamicReceiver();
    // IntentFilter intentFilter;

    MessageReceiver broadcastReceiver;
    IntentFilter intentFilter;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         TextView textView;
        textView = (TextView) findViewById(R.id.textView);
        broadcastReceiver = new MessageReceiver(textView);
    }

    @Override
    protected void onStart() {
        super.onStart();

        intentFilter = new IntentFilter();
        intentFilter.addAction("SendText");

        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(broadcastReceiver);
    }
}