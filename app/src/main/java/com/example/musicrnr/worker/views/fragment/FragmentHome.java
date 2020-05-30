package com.example.musicrnr.worker.views.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.QuickContactBadge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.musicrnr.R;
import com.example.musicrnr.worker.views.activity.PlayMusicHome;

public class FragmentHome extends Fragment {
    Button btnPlayMusc;
    public static Fragment instantiate() {
        FragmentHome fmH = new FragmentHome();

        return fmH;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnPlayMusc = view.findViewById(R.id.btn_playmusic);

        btnPlayMusc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),PlayMusicHome.class);
                startActivity(intent);

            }
        });
    }
}


