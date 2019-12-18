package com.etrack.test;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class FontText  extends AppCompatTextView {

    public FontText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public FontText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FontText(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "font/test.ttf");
        setTypeface(tf ,1);

    }
}
