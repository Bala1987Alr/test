package com.etrack.test.menulevel.yellow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.etrack.test.R;

import java.util.HashMap;

public class SelectCorrectPicture extends AppCompatActivity {

    private int[] imagelist = new int[]{R.mipmap.ant,R.mipmap.aeroplane,R.mipmap.apple,R.mipmap.axe,R.mipmap.aeroplane,R.mipmap.apple};
    private GridView gridview;
    private HashMap<Character,Boolean> selected = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_correct_picture);

        selected.put('R',false);
        selected.put('R',false);
        selected.put('R',false);
        selected.put('R',false);
        selected.put('W',false);
        selected.put('W',false);

        gridview = (GridView)findViewById(R.id.gridView);

        SelectCorrectAdapter selectCorrectAdapter = new SelectCorrectAdapter(this,imagelist,selected);
        gridview.setAdapter(selectCorrectAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity

            }
        });

    }
}
