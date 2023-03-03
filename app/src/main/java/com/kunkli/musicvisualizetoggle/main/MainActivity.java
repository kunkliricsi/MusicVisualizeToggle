package com.kunkli.musicvisualizetoggle.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.StatusBarManager;
import android.content.ComponentName;
import android.os.Bundle;

import com.kunkli.musicvisualizetoggle.R;
import com.kunkli.musicvisualizetoggle.services.MusicVisualizerTileService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}