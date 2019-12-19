package com.etrack.test;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MenuScreen extends AppCompatActivity {

private RelativeLayout fullscreen_content_controls;
private ImageView iv_left,iv_right,iv_center;
private LinearLayout ll_level_one,ll_level_two
        ,ll_level_three,ll_level_four;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu_start_screen);
        iv_left =   findViewById(R.id.iv_left);
        fullscreen_content_controls =   findViewById(R.id.fullscreen_content_controls);
        iv_center =   findViewById(R.id.iv_center);
        iv_right =   findViewById(R.id.iv_right);
        ll_level_one =   findViewById(R.id.ll_level_one);
                ll_level_two =   findViewById(R.id.ll_level_two);
        ll_level_three =   findViewById(R.id.ll_level_three);
        ll_level_four =   findViewById(R.id.ll_level_four);
        iv_center.setImageResource(R.drawable.ic_color_off);
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
        ll_level_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LevelOneScreen.class);
                startActivity(intent);
            }
        });
        ll_level_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LevelTwoScreen.class);
                startActivity(intent);
            }
        });
        ll_level_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LevelThreeScreen.class);
                startActivity(intent);
            }
        });
        ll_level_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LevelFourScreen.class);
                startActivity(intent);
            }
        });
      fullscreen_content_controls.setBackgroundColor(Color.parseColor("#FF2EC2C1"));

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();

    }


} }
