package com.manindertaggar.toddssyndrome.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manindertaggar.toddssyndrome.R;
import com.manindertaggar.toddssyndrome.SyndromTest;
import com.manindertaggar.toddssyndrome.activities.TestActivity;
import com.manindertaggar.toddssyndrome.adapters.AgeAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Maninder Taggar on 16/7/17.
 */

public class SetAgeFragment extends Fragment implements AgeAdapter.AgeSelectedListener {
    SyndromTest syndromTest;

    @BindView(R.id.rvAge)
    RecyclerView rvAge;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.syndromTest = ((TestActivity) getActivity()).getSyndromTest();
        View view = inflater.inflate(R.layout.layout_viewpager_set_age, container, false);
        ButterKnife.bind(this, view);
        setData();
        return view;
    }

    private void setData() {
        rvAge.setHasFixedSize(true);
        rvAge.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvAge.setAdapter(new AgeAdapter(getContext(), this));
    }

    @Override
    public void onAgeSelected(int age) {
        syndromTest.setAge(age);
        ((TestActivity) getActivity()).showNext();

    }
}