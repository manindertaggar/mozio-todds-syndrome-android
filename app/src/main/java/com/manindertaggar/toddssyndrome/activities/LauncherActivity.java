package com.manindertaggar.toddssyndrome.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import com.manindertaggar.toddssyndrome.R;
import com.manindertaggar.toddssyndrome.storage.Pref;

public class LauncherActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Pref.getInstance().isLoggedIn()) {
                    startActivity(new Intent(LauncherActivity.this, MainActivity.class));
                } else {
                    startActivity(new Intent(LauncherActivity.this, LoginActivity.class));
                }
                finish();
            }
        }, SPLASH_DELAY);
    }

}
