package com.example.jochen.bezier.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jochen.bezier.R;
import com.example.jochen.bezier.widget.wave.WaveView;

public class WaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave);
        setTitle("WaveActivity");
        WaveView waveView = (WaveView) findViewById(R.id.wave);
        waveView.setRunning();
    }
}
