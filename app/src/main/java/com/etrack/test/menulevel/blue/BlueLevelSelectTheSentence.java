package com.etrack.test.menulevel.blue;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.etrack.test.FontText;
import com.etrack.test.R;

public class BlueLevelSelectTheSentence extends AppCompatActivity {

    ListView modeList;
    String[] stringArray = new String[] { "1", "2","3", "4" };
    ArrayAdapter<String> modeAdapter;
    AlertDialog.Builder builder;
    Dialog dialog = null;
    boolean first_choice,second_choice,third_choice,fourth_choice;

    FontText fontText1,fontText2,fontText3,fontText4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_level_select_the_sentence);

        fontText1 =(FontText)findViewById(R.id.font_text1);
        fontText2 =(FontText)findViewById(R.id.font_text2);
        fontText3 =(FontText)findViewById(R.id.font_text3);
        fontText4 =(FontText)findViewById(R.id.font_text4);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();

        }

        modeList = new ListView(this);

        modeAdapter = new ArrayAdapter<String>(this, R.layout.fill_in_the_blanks_adapter_textview, R.id.text_fill_the_blanks, stringArray);
        modeList.setAdapter(modeAdapter);

        builder = new AlertDialog.Builder(this);
        builder.setView(modeList);
        dialog = builder.create();

        modeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(first_choice )
                {
                    fontText1.setText(adapterView.getItemAtPosition(i).toString());

                }
                if(second_choice)
                {
                    fontText2.setText(adapterView.getItemAtPosition(i).toString());
                }
                if(third_choice)
                {
                    fontText3.setText(adapterView.getItemAtPosition(i).toString());
                }
                else
                {
                    fontText4.setText(adapterView.getItemAtPosition(i).toString());
                }
                dialog.dismiss();
            }
        });
    }

    public void first(View view)
    {
        first_choice = true;
        dialog.show();
    }
    public void second(View view)
    {
        second_choice = true;
        dialog.show();
    }
    public void third(View view)
    {
        third_choice = true;
        dialog.show();
    }
    public void fourth(View view)
    {
        fourth_choice = true;
        dialog.show();
    }

    public void previous(View view)
    {

    }

    public void next(View view)
    {

    }
}
