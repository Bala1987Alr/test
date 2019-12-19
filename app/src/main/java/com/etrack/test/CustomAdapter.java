package com.etrack.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String alphabets[];
    LayoutInflater inflter;
    public CustomAdapter(Context applicationContext, String[] alphabets) {
        this.context = applicationContext;
        this.alphabets = alphabets;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return alphabets.length;
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
        view = inflter.inflate(R.layout.custom_list_alphepet, null); // inflate the layout
        FontText icon = (FontText) view.findViewById(R.id.tv_alphabet); // get the reference of ImageView
        icon.setText(alphabets[i]); // set logo images
        return view;
    }
}
