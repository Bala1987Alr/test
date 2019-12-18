package com.etrack.test;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class StartScreen extends AppCompatActivity {

    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;
private RelativeLayout fullscreen_content_controls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start_screen);

        fullscreen_content_controls =   findViewById(R.id.fullscreen_content_controls);
      fullscreen_content_controls.setBackground(R.color.colorstart);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();

    }


} }
