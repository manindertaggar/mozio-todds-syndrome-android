package com.manindertaggar.toddssyndrome.misc;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by maninder on 11/7/17.
 */


class TestPagerTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View view, float position) {
        ImageView ivHeader = null;//view.findViewById(R.id.ivHeader);
        ImageView ivBackground = null;// view.findViewById(R.id.ivBackground);
        int pageHeight = view.getHeight();

        if (position < -1) {
            view.setAlpha(0);
        } else if (position <= 1) {
            view.setAlpha(1);
            view.setTranslationX(view.getWidth() * -position);
            ivHeader.setTranslationY(-position * (pageHeight / 2));
            ivBackground.setTranslationY(-position * (pageHeight / 4));
            float yPosition = position * view.getHeight();
            view.setTranslationY(yPosition);
            view.setAlpha(1 - position * 2);
        } else {
            view.setAlpha(0);
        }
    }
}