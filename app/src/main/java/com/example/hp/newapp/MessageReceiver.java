package com.example.hp.newapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

/**
 * Created by HP on 8/15/2017.
 */

public class MessageReceiver extends BroadcastReceiver {

    TextView textView;
    int val;
    MessageReceiver(TextView textView){
        this.textView = textView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "I received the Message", Toast.LENGTH_SHORT).show();
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction("SMS_RECEIVED_ACTION");
        broadcastIntent.putExtra("Message", ""+ val);
        textView.setText(intent.getStringExtra("Message"));
        context.sendBroadcast(broadcastIntent);

    }
}