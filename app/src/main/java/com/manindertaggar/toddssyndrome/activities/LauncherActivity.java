package com.manindertaggar.toddssyndrome.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.manindertaggar.toddssyndrome.R;
import com.manindertaggar.toddssyndrome.network.requests.GetAllTestsRequest;
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

        if (!Pref.getInstance().isDataSyncedAtleastOnce()) {
            new GetAllTestsRequest(getApplicationContext()).send();
        }

        ivLogo.animate().setInterpolator(new DecelerateInterpolator()).setDuration(1000).rotationY(180);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LauncherActivity.this, MainActivity.class));
                finish();
            }
        }, SPLASH_DELAY);
    }

}
