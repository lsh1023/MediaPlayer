package com.lsh.videocamera;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;


/**
 * 录制视频并显示在在控件上
 */

public class MainActivity extends AppCompatActivity {

    private static final int RECORD_VIDEO = 0;

    private Button videoButton;
    private VideoView videoView;

    private void startRecording() {
        //生成Intent
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        //启动摄像头应用程序
        startActivityForResult(intent, RECORD_VIDEO);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoButton = (Button) findViewById(R.id.buttonVideo);
        videoView = (VideoView) findViewById(R.id.videoView);
        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRecording();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == RECORD_VIDEO) {
            videoView.setVideoURI(data.getData());
            videoView.start();
        }


    }
}
