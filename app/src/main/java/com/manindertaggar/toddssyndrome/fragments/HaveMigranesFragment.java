package com.manindertaggar.toddssyndrome.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.manindertaggar.toddssyndrome.R;
import com.manindertaggar.toddssyndrome.SyndromTest;
import com.manindertaggar.toddssyndrome.activities.TestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by maninder on 16/7/17.
 */

public class HaveMigranesFragment extends Fragment {
    SyndromTest syndromTest;

    @BindView(R.id.ivMigraneFace)
    ImageView ivMigraneFace;
    @BindView(R.id.ivNoMigraneFace)
    ImageView ivNoMigraneFace;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.syndromTest = ((TestActivity) getActivity()).getSyndromTest();
        View view = inflater.inflate(R.layout.layout_viewpager_have_migranes, container, false);
        ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    private void initViews() {
        if (syndromTest.getIsMale()) {
            ivMigraneFace.setImageResource(R.drawable.male_migrane);
            ivNoMigraneFace.setImageResource(R.drawable.male);
        } else {
            ivMigraneFace.setImageResource(R.drawable.female_migrane);
            ivNoMigraneFace.setImageResource(R.drawable.female);
        }

    }

    @OnClick(R.id.llNoMigrane)
    public void onNoMigraneSelected() {
        syndromTest.setHaveMigranes(false);
        ((TestActivity) getActivity()).showNext();
    }

    @OnClick(R.id.llMigrane)
    public void onMigraneSelected() {
        syndromTest.setHaveMigranes(true);
        ((TestActivity) getActivity()).showNext();

    }

}



