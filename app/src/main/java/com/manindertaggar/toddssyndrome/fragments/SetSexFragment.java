package com.manindertaggar.toddssyndrome.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manindertaggar.toddssyndrome.R;
import com.manindertaggar.toddssyndrome.SyndromTest;
import com.manindertaggar.toddssyndrome.activities.TestActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Maninder Taggar on 16/7/17.
 */

public class SetSexFragment extends Fragment {
    private SyndromTest syndromTest;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.syndromTest = ((TestActivity) getActivity()).getSyndromTest();
        View view = inflater.inflate(R.layout.layout_viewpager_set_sex, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.llMale)
    public void onMaleSelected() {
        syndromTest.setIsMale(true);
        ((TestActivity) getActivity()).showNext();
    }

    @OnClick(R.id.llFemale)
    public void onFemaleSelected() {
        syndromTest.setIsMale(false);
        ((TestActivity) getActivity()).showNext();
    }

}