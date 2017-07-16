package com.manindertaggar.toddssyndrome.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.manindertaggar.toddssyndrome.fragments.HaveMigranesFragment;
import com.manindertaggar.toddssyndrome.fragments.SetAgeFragment;
import com.manindertaggar.toddssyndrome.fragments.SetSexFragment;
import com.manindertaggar.toddssyndrome.fragments.TestResultsFragment;
import com.manindertaggar.toddssyndrome.fragments.UseHallucinogenicFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Maninder Taggar on 11/7/17.
 */

public class TestAdapter extends FragmentPagerAdapter {

    private final List<String> fragments = new ArrayList();
    private Context context;
    private HashMap<Integer, Fragment> framentsMap = new HashMap<>();

    public TestAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        fragments.add(SetSexFragment.class.getName());
        fragments.add(SetAgeFragment.class.getName());
        fragments.add(HaveMigranesFragment.class.getName());
        fragments.add(UseHallucinogenicFragment.class.getName());
        fragments.add(TestResultsFragment.class.getName());
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = Fragment.instantiate(context, fragments.get(position));
        framentsMap.put(position, fragment);
        return fragment;
    }

    public Fragment getFragmentAtPosition(int position) {
        if (framentsMap.containsKey(position)) {
            return framentsMap.get(position);
        }

        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }

}