package com.example.jochen.bezier.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jochen.bezier.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_adhesion_layout).setOnClickListener(this);
        findViewById(R.id.btn_adhesion_progress).setOnClickListener(this);
        findViewById(R.id.btn_adhesion_elastic_loader).setOnClickListener(this);
        findViewById(R.id.btn_adhesion_wave).setOnClickListener(this);
        findViewById(R.id.btn_demo).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_adhesion_layout:
                startActivity(new Intent(MainActivity.this, AdhesionLayoutActivity.class));
                break;
            case R.id.btn_adhesion_progress:
                startActivity(new Intent(MainActivity.this, AdhesionLoaderProgressActivity.class));
                break;
            case R.id.btn_adhesion_elastic_loader:
                startActivity(new Intent(MainActivity.this, ElasticLoaderActivity.class));
                break;
            case R.id.btn_adhesion_wave:
                startActivity(new Intent(MainActivity.this, WaveActivity.class));
                break;
            case R.id.btn_demo:
                startActivity(new Intent(MainActivity.this, DemoActivity.class));
                break;
        }
    }
}
