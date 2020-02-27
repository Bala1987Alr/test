package com.etrack.test.menulevel.pink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.etrack.test.Matching;
import com.etrack.test.R;
import com.etrack.test.menulevel.yellow.SelectCorrectPicture;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class PinkLevel extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout pink_level1,pink_level2,pink_level3,pink_level4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pink_list_of_alphapet);

        pink_level1 = (LinearLayout)findViewById(R.id.pink_level_one);
        pink_level2 = (LinearLayout)findViewById(R.id.pink__level_two);
        pink_level3 = (LinearLayout)findViewById(R.id.pink__level_three);
        pink_level4 = (LinearLayout)findViewById(R.id.pink__level_four);


        pink_level1.setOnClickListener(this);
        pink_level2.setOnClickListener(this);
        pink_level3.setOnClickListener(this);
        pink_level4.setOnClickListener(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();

        }



}

    @Override
    public void onClick(View view) {

        startActivity(new Intent(this, Matching.class));
    }
}
