package com.kadir.bootcamp.sonzelzele.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kadir.bootcamp.sonzelzele.fragments.FirstFragment;
import com.kadir.bootcamp.sonzelzele.fragments.SecondFragment;
import com.kadir.bootcamp.sonzelzele.fragments.ThirdFragment;

/**
 * Created by KadirDogan on 8/11/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new FirstFragment();
        else if(position == 1)
            return new SecondFragment();
        else
            return new ThirdFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
