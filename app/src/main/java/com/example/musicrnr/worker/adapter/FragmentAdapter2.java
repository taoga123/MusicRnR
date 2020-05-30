package com.example.musicrnr.worker.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.example.musicrnr.worker.views.fragment.FragmentC;

public class FragmentAdapter2 extends FragmentPagerAdapter {
    public FragmentAdapter2(FragmentManager childFragmentManager) {
        super(childFragmentManager);
    }

    public Fragment getItem(int i) {

        switch (i)
        {
            case 0: return FragmentC.instantiate(1);
            case 1: return FragmentC.instantiate(2);
            case 2: return FragmentC.instantiate(3);
            case 3: return FragmentC.instantiate(4);
            case 4: return FragmentC.instantiate(5);
            case 5: return FragmentC.instantiate(6);
            case 6: return FragmentC.instantiate(7);

        }
        return null;
    }

    @Override
    public int getCount() {
        return 7;
    }

}
