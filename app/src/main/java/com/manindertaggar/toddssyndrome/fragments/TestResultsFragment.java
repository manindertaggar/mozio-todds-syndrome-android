package com.manindertaggar.toddssyndrome.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manindertaggar.toddssyndrome.R;
import com.manindertaggar.toddssyndrome.SyndromCalculator;
import com.manindertaggar.toddssyndrome.activities.TestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by maninder on 16/7/17.
 */

public class TestResultsFragment extends Fragment {
    private SyndromCalculator syndromCalculator;
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
        this.syndromCalculator = ((TestActivity) getActivity()).getSyndromCalculator();
        View view = inflater.inflate(R.layout.layout_viewpager_test_result, container, false);
        ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    private void initViews() {
        tvSex.setText(syndromCalculator.getIsMale() ? "Male" : "Female");
        tvMigranes.setText(syndromCalculator.getHaveMigranes() ? "Yes" : "No");
        tvDrugs.setText(syndromCalculator.getUsesHallucinogeninDrugs() ? "Yes" : "No");
        tvAge.setText(syndromCalculator.getAge() + "");
    }

    @OnClick(R.id.tvHome)
    public void onHomePressed() {
        getActivity().finish();
    }

}