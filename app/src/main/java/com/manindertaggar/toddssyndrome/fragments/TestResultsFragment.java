package com.manindertaggar.toddssyndrome.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manindertaggar.toddssyndrome.R;
import com.manindertaggar.toddssyndrome.SyndromTest;
import com.manindertaggar.toddssyndrome.activities.TestActivity;
import com.manindertaggar.toddssyndrome.network.requests.UploadRequest;
import com.manindertaggar.toddssyndrome.storage.Dao;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Maninder Taggar on 16/7/17.
 */

public class TestResultsFragment extends Fragment {
    private static final String TAG = TestResultsFragment.class.getSimpleName();
    private SyndromTest syndromTest;
    @BindView(R.id.tvSex)
    TextView tvSex;
    @BindView(R.id.tvAge)
    TextView tvAge;
    @BindView(R.id.tvMigranes)
    TextView tvMigranes;
    @BindView(R.id.tvDrugs)
    TextView tvDrugs;
    @BindView(R.id.tvProbability)
    TextView tvProbability;
    @BindView(R.id.tvHome)
    TextView tvHome;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: created");
        this.syndromTest = ((TestActivity) getActivity()).getSyndromTest();
        View view = inflater.inflate(R.layout.layout_viewpager_test_result, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    private void saveAndUpload() {
        Log.d(TAG, "saveAndUpload: ");
        Dao.getSyndromeDao().save(syndromTest);
        new UploadRequest(getContext()).send(syndromTest);
    }


    public void setData() {
        Log.d(TAG, "setData: ");
        tvSex.setText(syndromTest.getIsMale() ? "Male" : "Female");
        tvMigranes.setText(syndromTest.getHaveMigranes() ? "Yes" : "No");
        tvDrugs.setText(syndromTest.getUsesHallucinogeninDrugs() ? "Yes" : "No");
        tvAge.setText(syndromTest.getAge() + "");
        tvProbability.setText(syndromTest.getProbabity() + " %");

        saveAndUpload();
    }

    @OnClick(R.id.tvHome)
    public void onHomePressed() {
        getActivity().finish();
    }

}