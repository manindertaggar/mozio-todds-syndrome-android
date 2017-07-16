package com.manindertaggar.toddssyndrome.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.manindertaggar.toddssyndrome.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewPreviousResults(View view) {
    }

    public void takeTest(View view) {
        startActivity(new Intent(this,TestActivity.class));
    }
}
