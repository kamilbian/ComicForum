package com.example.administrator.comicforum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2018/5/3.
 */

public class WelcomeActivity extends Activity {
    private Intent intent;
    private Timer timer;
    private TimerTask task;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        intent=new Intent(this,MainActivity.class);
        timer=new Timer();
        task=new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(task,3000);
    }

}
