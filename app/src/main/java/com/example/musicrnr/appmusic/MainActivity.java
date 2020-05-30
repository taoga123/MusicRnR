package com.example.musicrnr.appmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.musicrnr.R;
import com.example.musicrnr.worker.adapter.FragmentAdapter;
import com.example.musicrnr.worker.views.activity.SplashActivity;
import com.example.musicrnr.worker.views.fragment.FragmentHome;

// Created by CuongThinh on 29/05/2020
// Không viết code tinh toan vào phần này
// History phải cập nhật trạng thái sửa cái gì ở đâu , tại sao sửa, giải pháp sửa, ngày giờ chỉnh sửa.
public class MainActivity extends AppCompatActivity {
    ViewPager mviewPager;
    FragmentAdapter fragmentAdapter;

    int currentBannerPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // make the activity full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        // hide the action bar

        getSupportActionBar().hide();


        mviewPager = findViewById(R.id.viewpager_home);




        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());

        mviewPager.setAdapter(fragmentAdapter);



    }

}
