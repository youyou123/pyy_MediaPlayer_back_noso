package com.example.mediaplayer_pyy;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends Activity {
    private Button go;
    private EditText url;
    private Button button;
    private VideoView videoview;
    private MediaController mMediaController;
    private String url1 = "http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4";
    private String url2 = "rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov";
    private String url3 = "http://42.96.249.166/live/270.m3u8";
    private String url4 = "http://61.129.89.191/ThroughTrain/download.html?id=4035&flag=-org-";//音频url
    private String  url5="http://192.168.1.254/DCIM/VIDEO/2017_0415_191651_004A.MOV";
   // 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go = (Button) findViewById(R.id.go);
        url = (EditText) findViewById(R.id.url);
        button = (Button) findViewById(R.id.play);
        videoview = (VideoView) findViewById(R.id.video);

        mMediaController = new MediaController(this);
		videoview.setMediaController(mMediaController);

        url.setText(url5);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                loadView(url.getText().toString());
            }
        });

        go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MediaPlayerActivity.class);
                startActivity(intent);
            }
        });
    }


    public void loadView(String path) {
        Uri uri = Uri.parse(path);
        videoview.setVideoURI(uri);
        videoview.start();

        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
     //         mp.setLooping(true);
                mp.start();// 播放
                Toast.makeText(MainActivity.this, "开始播放！", Toast.LENGTH_LONG).show();
            }
        });

        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "播放完毕", Toast.LENGTH_SHORT).show();
            }
        });

    }

}

