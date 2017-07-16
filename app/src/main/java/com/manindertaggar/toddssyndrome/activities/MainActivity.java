package com.manindertaggar.toddssyndrome.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.manindertaggar.toddssyndrome.R;
import com.manindertaggar.toddssyndrome.SyndromTest;
import com.manindertaggar.toddssyndrome.SyndromTestDao;
import com.manindertaggar.toddssyndrome.network.requests.UploadRequest;
import com.manindertaggar.toddssyndrome.storage.Dao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uploadFailedTests();
    }

    private void uploadFailedTests() {
        List<SyndromTest> failedSyndromeTests = Dao.getSyndromeDao().queryBuilder()
                .where(SyndromTestDao.Properties.IsUploaded.eq(false))
                .list();

        for (SyndromTest failedSyndromeTest : failedSyndromeTests) {
            new UploadRequest(getApplicationContext()).send(failedSyndromeTest);
        }
    }

    public void viewPreviousResults(View view) {
        startActivity(new Intent(this, ResultsActivity.class));
    }

    public void takeTest(View view) {
        startActivity(new Intent(this, TestActivity.class));
    }
}
