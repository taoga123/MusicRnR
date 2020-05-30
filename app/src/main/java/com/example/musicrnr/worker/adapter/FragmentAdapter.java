package com.example.musicrnr.worker.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.musicrnr.worker.views.fragment.FragmentC;
import com.example.musicrnr.worker.views.fragment.FragmentHome;
import com.example.musicrnr.worker.views.fragment.FragmentB;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i)
        {
            case 0: return FragmentHome.instantiate();
            case 1: return FragmentB.newinstance(0);
            case 2: return FragmentC.instantiate(0);
            case 3: return FragmentHome.instantiate();
            case 4: return FragmentHome.instantiate();


        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
