package com.school.android.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.google.firebase.messaging.FirebaseMessaging;
import com.school.android.myapplication.alarm.AlarmActivity;
import com.school.android.myapplication.storage.DBActivity;

public class MainActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.startServiceButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
            }
        });

        findViewById(R.id.startAlarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAlarm();
            }
        });

        findViewById(R.id.dbButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDb();
            }
        });

        FirebaseMessaging.getInstance().subscribeToTopic("cesar_school");
    }

    private void start() {
        Intent intent = new Intent(this, SampleIntentService.class);
        startService(intent);
    }

    private void startAlarm() {
        Intent intent = new Intent(this, AlarmActivity.class);
        startActivity(intent);
    }

    private void startDb() {
        Intent intent = new Intent(this, DBActivity.class);
        startActivity(intent);
    }
}
