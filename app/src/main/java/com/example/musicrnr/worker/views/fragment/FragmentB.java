package com.example.musicrnr.worker.views.fragment;

import android.os.Bundle;
import android.os.Handler;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.musicrnr.R;
import com.example.musicrnr.worker.adapter.FragmentAdapter2;


public class FragmentB extends Fragment {
    int currentBannerPage = 0;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2,container,false);


        return v;
    }

    public static FragmentB newinstance(int numberload)
    {
        FragmentB fmB = new FragmentB();
        Bundle b = new Bundle();
        b.putInt("msg", numberload);

        fmB.setArguments(b);

        return fmB;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.viewPager2);
        viewPager.setAdapter(new FragmentAdapter2(getChildFragmentManager()));
        autoScroll();


    }

    private void autoScroll() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if ((currentBannerPage+1)>6 )
                {
                    currentBannerPage = 0 ;

                }


                viewPager.setCurrentItem(currentBannerPage++,true);
                handler.postDelayed(this,1000);
            }
        },5000);

//        Runnable timeCounter = new Runnable() {
//            @Override
//            public void run() {
//
//                if ((currentBannerPage+1)>6 )
//                {
//                    currentBannerPage = 0 ;
//
//                }
//                Log.e("chay tao xem", " :D");
//
//                viewPager.setCurrentItem(currentBannerPage++,true);
//                handler.postDelayed(this,1000);
//
//            }
//        };
//        handler.postDelayed(timeCounter, 5000);
    }

}
