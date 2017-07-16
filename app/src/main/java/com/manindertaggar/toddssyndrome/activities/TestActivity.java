package com.manindertaggar.toddssyndrome.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.manindertaggar.toddssyndrome.R;
import com.manindertaggar.toddssyndrome.SyndromTest;
import com.manindertaggar.toddssyndrome.adapters.TestAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.testViewPager)
    ViewPager testViewPager;
    Unbinder unbinder;
    public SyndromTest syndromTest;
    private TestAdapter testAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        this.syndromTest = new SyndromTest();

        unbinder = ButterKnife.bind(this);

        testAdapter = (new TestAdapter(this, getSupportFragmentManager()));
        testViewPager.setAdapter(testAdapter);
        testViewPager.beginFakeDrag();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbinder.unbind();
    }

    public SyndromTest getSyndromTest() {
        return syndromTest;
    }

    public void showNext() {
        testViewPager.setCurrentItem(testViewPager.getCurrentItem() + 1);
    }

    @Override
    public void onBackPressed() {
        if (testViewPager.getCurrentItem() == 0 || (testAdapter.getCount() - 1) == testViewPager.getCurrentItem())
            super.onBackPressed();
        else
            testViewPager.setCurrentItem(testViewPager.getCurrentItem() - 1);

    }
}


