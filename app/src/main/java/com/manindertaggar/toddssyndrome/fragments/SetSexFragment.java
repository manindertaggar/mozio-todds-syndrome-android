package com.manindertaggar.toddssyndrome.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manindertaggar.toddssyndrome.R;
import com.manindertaggar.toddssyndrome.SyndromCalculator;
import com.manindertaggar.toddssyndrome.activities.TestActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by maninder on 16/7/17.
 */

public class SetSexFragment extends Fragment {
    private SyndromCalculator syndromCalculator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.syndromCalculator = ((TestActivity) getActivity()).getSyndromCalculator();
        View view = inflater.inflate(R.layout.layout_viewpager_set_sex, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.llMale)
    public void onMaleSelected() {
        syndromCalculator.setIsMale(true);
        ((TestActivity) getActivity()).showNext();
    }

    @OnClick(R.id.llFemale)
    public void onFemaleSelected() {
        syndromCalculator.setIsMale(false);
        ((TestActivity) getActivity()).showNext();
    }

}