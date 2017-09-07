package com.filho.filho;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.Vector;

/**
 * Created by HeryVandoro on 9/7/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    Vector<Fragment> fragments = new Vector<Fragment>();

    public PagerAdapter(FragmentManager fm) {
        super(fm);

        //initialize fragments
        fragments.add(new PopularFragment());
        fragments.add(new OngoingFragment());
        fragments.add(new UpcomingFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
