package com.etrack.test.menulevel;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.etrack.test.menulevel.yellow.YellowLevel;
import com.etrack.test.R;
import com.etrack.test.menulevel.blue.BlueLevel;
import com.etrack.test.menulevel.green.GreenLevel;
import com.etrack.test.menulevel.pink.PinkLevel;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuLevelFragment extends Fragment {


    private LinearLayout ll_level_one,ll_level_two
            ,ll_level_three,ll_level_four;

    public MenuLevelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_level, container, false);


        ll_level_one =   view.findViewById(R.id.ll_level_one);
        ll_level_two =   view.findViewById(R.id.ll_level_two);
        ll_level_three =   view.findViewById(R.id.ll_level_three);
        ll_level_four =   view.findViewById(R.id.ll_level_four);

        ll_level_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), YellowLevel.class);
                startActivity(intent);
            }
        });
        ll_level_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PinkLevel.class);
                startActivity(intent);
            }
        });
        ll_level_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BlueLevel.class);
                startActivity(intent);
            }
        });
        ll_level_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GreenLevel.class);
                startActivity(intent);
            }
        });




        return view;
    }

}
