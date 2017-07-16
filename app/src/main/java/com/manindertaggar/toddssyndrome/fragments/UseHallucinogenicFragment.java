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

import butterknife.OnClick;

/**
 * Created by maninder on 16/7/17.
 */

public class UseHallucinogenicFragment extends Fragment {
    SyndromCalculator syndromCalculator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.syndromCalculator = ((TestActivity) getActivity()).getSyndromCalculator();
        View view = inflater.inflate(R.layout.layout_viewpager_uses_hallucinogenic, container, false);
        return view;
    }


    @OnClick(R.id.tvUseDrugsYes)
    public void onDrugsUsedSelected() {
        syndromCalculator.setUsesHallucinogeninDrugs(true);
        ((TestActivity) getActivity()).showNext();
    }

    @OnClick(R.id.tvUseDrugsNo)
    public void onNoDrugsUsedSelected() {
        syndromCalculator.setUsesHallucinogeninDrugs(false);
        ((TestActivity) getActivity()).showNext();
    }

}