package com.etrack.test.menulevel.yellow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.etrack.test.R;

import java.util.HashMap;

public class SelectCorrectAdapter extends BaseAdapter {
    private Context context;
    private int imageList[];
    private HashMap<Character,Boolean> selected;
    private LayoutInflater inflter;
    public SelectCorrectAdapter(Context applicationContext, int[] imageList, HashMap<Character,Boolean> selected) {
        this.context = applicationContext;
        this.imageList = imageList;
        this.selected = selected;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return imageList.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.select_correct_pic, null); // inflate the layout
        ImageView icon = (ImageView) view.findViewById(R.id.img_src); // get the reference of ImageView
        ImageView isCORW = (ImageView) view.findViewById(R.id.is_correct_or_wrong);
        icon.setImageResource(imageList[i]); // set logo images
        return view;
    }
}
