package com.qiu.golfersintelligence.adapter.vp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.qiu.golfersintelligence.view.fragment.MatchListFragment;

/**
 * Created by a on 2017/9/22.
 */

public class MatchTabPageAdapter extends FragmentStatePagerAdapter{

    public MatchTabPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        MatchListFragment matchListFragment=new MatchListFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("position",position);
        matchListFragment.setArguments(bundle);
        return matchListFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
