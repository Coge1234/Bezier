package com.example.jochen.bezier.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.jochen.bezier.R;
import com.example.jochen.bezier.widget.adhesion.AdhesionLayout;

public class AdhesionLayoutActivity extends AppCompatActivity {

    private AdhesionLayout adhesionLayout;
    private TextView tv_adhesion;
    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adhesion_layout);
        setTitle("AdhesionLayoutActivity");
        adhesionLayout = (AdhesionLayout) findViewById(R.id.adhesion);
        tv_adhesion = (TextView) findViewById(R.id.tv_adhesion);

        tv_adhesion.setText(String.valueOf(count));
        if (count > 0) {
            adhesionLayout.setVisibility(View.VISIBLE);
        } else {
            adhesionLayout.setVisibility(View.GONE);
        }
        adhesionLayout.setOnAdherentListener(new AdhesionLayout.OnAdherentListener() {
            @Override
            public void onDismiss() {
                count = 0;
            }
        });
    }

    public void addCountOnClickListener(View view) {
        if (count == 0) {
            adhesionLayout.reset();
        }
        count++;
        adhesionLayout.setVisibility(View.VISIBLE);
        tv_adhesion.setText(String.valueOf(count));

    }

    public void minusCountOnClickListener(View view) {
        count--;
        if (count > 0) {
            tv_adhesion.setText(String.valueOf(count));
        } else {
            count = 0;
            adhesionLayout.setVisibility(View.GONE);
        }
    }
}
