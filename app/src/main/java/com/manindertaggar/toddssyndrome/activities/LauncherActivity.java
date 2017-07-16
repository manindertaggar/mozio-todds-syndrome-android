package com.manindertaggar.toddssyndrome.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.manindertaggar.toddssyndrome.R;
import com.manindertaggar.toddssyndrome.storage.Pref;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LauncherActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000;
    @BindView(R.id.ivLogo)
    ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        ButterKnife.bind(this);
        ivLogo.setAlpha(0f);
        ivLogo.animate().setInterpolator(new DecelerateInterpolator()).setDuration(1000).rotationY(180).alpha(1);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Pref.getInstance().isLoggedIn()) {
                    startActivity(new Intent(LauncherActivity.this, MainActivity.class));
                } else {

                    Intent intent = new Intent(LauncherActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, SPLASH_DELAY);
    }

}
