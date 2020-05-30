package com.example.musicrnr.worker.views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.musicrnr.R;
import com.example.musicrnr.worker.model.data.Song;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PlayMusicHome extends AppCompatActivity {
    ImageButton btnPlay,btnStop,btnPreview,btnNext;
    TextView Textten,Timeup,Timeend;
    SeekBar seekBar;
    ArrayList<Song> arraySong;
    int poision  = 0 ;
    MediaPlayer mediaPlayer;
    ImageView imageView;
    Animation animation;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        // hide the action bar

        getSupportActionBar().hide();
        setContentView(R.layout.activity_play_music_home);

        btnPlay = findViewById(R.id.btnplay);
        btnStop = findViewById(R.id.btnstop);
        btnPreview = findViewById(R.id.btnView);
        btnNext = findViewById(R.id.btnnext);
        Textten = findViewById(R.id.textTen);
        Timeup = findViewById(R.id.texttime1);
        Timeend = findViewById(R.id.texttime2);
        seekBar = findViewById(R.id.seekBar);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sun_rotate);

        // Cac ham anh xa
        AddSong();
        AddMedia();
        SetTimeTotal();
        UpdateTimeSong();
        UpAnimation();

        //Set on click lisener
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.btn_play);

                }
                else
                {
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.btn_pause);
                }
                SetTimeTotal();
                UpdateTimeSong();
//                imageView.startAnimation(animation);


            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                btnPlay.setImageResource(R.drawable.btn_play);
                AddMedia();
                SetTimeTotal();
                UpdateTimeSong();

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poision ++;
                if(poision > arraySong.size() -1)
                {
                    poision = 0;
                }
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                btnPlay.setImageResource(R.drawable.btn_pause);
                AddMedia();
                mediaPlayer.start();
                SetTimeTotal();
                UpdateTimeSong();


            }
        });

        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poision --;
                if (poision < 0)
                {
                    poision =  arraySong.size() - 1;

                }
                if (mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                btnPlay.setImageResource(R.drawable.btn_pause);
                AddMedia();
                mediaPlayer.start();
                SetTimeTotal();
                UpdateTimeSong();

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());

            }
        });
    }


    private void UpAnimation() {

    }

    // thread update timesong
    private void UpdateTimeSong() {

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat setupsong = new SimpleDateFormat("mm:ss");
                Timeup.setText(setupsong.format(mediaPlayer.getCurrentPosition()));
                // update progress song
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                // end song => new song
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        poision ++;
                        if(poision > arraySong.size() -1)
                        {
                            poision = 0;
                        }
                        if(mediaPlayer.isPlaying())
                        {
                            mediaPlayer.stop();
                        }
                        AddMedia();
                        mediaPlayer.start();
                        SetTimeTotal();
                        UpdateTimeSong();
                    }
                });
                handler.postDelayed(this,100);
            }
        },200);

    }
    private void SetTimeTotal() {
        SimpleDateFormat setup = new SimpleDateFormat("mm:ss");
        Timeend.setText(setup.format(mediaPlayer.getDuration()));
        // set max of song =  media . duration;
        seekBar.setMax(mediaPlayer.getDuration());

    }

    // method add
    private void AddMedia() {
        mediaPlayer = MediaPlayer.create(PlayMusicHome.this,
                arraySong.get(poision).getFile());
        Textten.setText(arraySong.get(poision).getTitle());

    }

    private void AddSong() {
        arraySong = new ArrayList<>();
        String url = "https://firebasestorage.googleapis.com/v0/b/mymuysick.appspot.com/o/Ketsuraku-Automation-ONE-OK-ROCK.mp3?alt=media&token=05c59590-3f5e-4de1-910b-ca2b91f8e006";

        arraySong.add(new Song("Anh di kiem em",R.raw.aditimai));
        arraySong.add(new Song("Khien ti hi",R.raw.akhientihi));
        arraySong.add(new Song("1 doi 1 giac mo ",R.raw.giacmo));
        arraySong.add(new Song("Quang tao cai boong",R.raw.quangtaocaiboong));
        arraySong.add(new Song("Make me move",R.raw.makememove));


    }
}
