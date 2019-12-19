package com.etrack.test;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LevelOneScreen extends AppCompatActivity {

private RelativeLayout fullscreen_content_controls;
private ImageView iv_left,iv_right,iv_center;
private GridView gv_alphabet;
private String[] alphabets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.level_one_screen);
        alphabets = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
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
                Intent intent = new Intent(getApplicationContext()"," MenuScreen.class);
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

        gv_alphabet = (GridView) findViewById(R.id.gv_alphabet); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), alphabets);
        gv_alphabet.setAdapter(customAdapter);
        // implement setOnItemClickListener event on GridView
        gv_alphabet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
          /*      Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("image", logos[position]); // put image data in Intent
                startActivity(intent);*/ // start Intent
            }
        });

} }
