package com.example.musicrnr.worker.views.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.musicrnr.R;

public class FragmentC extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment3,container,false);


        return v;
    }

    public static Fragment instantiate(int numberload) {
        FragmentC fmC = new FragmentC();
        Bundle b = new Bundle();
        b.putInt("msg", numberload);


        fmC.setArguments(b);
        return fmC;
    }
}
