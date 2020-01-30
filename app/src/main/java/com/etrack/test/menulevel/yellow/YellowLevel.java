package com.etrack.test.menulevel.yellow;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.etrack.test.CustomAdapter;
import com.etrack.test.R;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class YellowLevel extends AppCompatActivity {

private GridView gv_alphabet;
private String[] alphabets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.level_one_screen);
        alphabets = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        

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
            public void onItemClick(AdapterView<?> parent, View view, int position,  long id) {
                // set an Intent to Another Activity
                Intent intent = new Intent(YellowLevel.this, SelectCorrectPicture.class);
                startActivity(intent);
            }
        });

} }
