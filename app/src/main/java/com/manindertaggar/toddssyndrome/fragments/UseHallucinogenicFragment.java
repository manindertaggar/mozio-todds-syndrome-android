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

public class UseHallucinogenicFragment extends Fragment {
    SyndromTest syndromTest;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.syndromTest = ((TestActivity) getActivity()).getSyndromTest();
        View view = inflater.inflate(R.layout.layout_viewpager_uses_hallucinogenic, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick(R.id.tvUseDrugsYes)
    public void onDrugsUsedSelected() {
        syndromTest.setUsesHallucinogeninDrugs(true);
        ((TestActivity) getActivity()).showNext();
    }

    @OnClick(R.id.tvUseDrugsNo)
    public void onNoDrugsUsedSelected() {
        syndromTest.setUsesHallucinogeninDrugs(false);
        ((TestActivity) getActivity()).showNext();
    }

}