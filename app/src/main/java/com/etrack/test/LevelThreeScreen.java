package com.etrack.test;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LevelThreeScreen extends AppCompatActivity {

private RelativeLayout fullscreen_content_controls;
private ImageView iv_left,iv_right,iv_center;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.level_three_screen);
        iv_left =   findViewById(R.id.iv_left);
        fullscreen_content_controls =   findViewById(R.id.fullscreen_content_controls);
        iv_center =   findViewById(R.id.iv_center);
        iv_right =   findViewById(R.id.iv_right);
        iv_center.setImageResource(R.drawable.ic_yellow_on);
        iv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        iv_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                Intent intent = new Intent(getApplicationContext(), MenuScreen.class);
                startActivity(intent);*/
            }
        });
        iv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

      fullscreen_content_controls.setBackgroundColor(Color.parseColor("#E5B00C"));

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();

    }


} }
