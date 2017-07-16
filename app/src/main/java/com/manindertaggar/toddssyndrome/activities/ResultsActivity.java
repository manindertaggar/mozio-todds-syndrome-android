package com.manindertaggar.toddssyndrome.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.manindertaggar.toddssyndrome.R;
import com.manindertaggar.toddssyndrome.adapters.ResultsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultsActivity extends AppCompatActivity {

    @BindView(R.id.rvResults)
    RecyclerView rvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        rvResults.setLayoutManager(layoutManager);
        rvResults.setAdapter(new ResultsAdapter(this));
    }
}
