package com.example.fickhd.model;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class CustomItemDecorator extends RecyclerView.ItemDecoration {

    int halfSpace;

    CustomItemDecorator(int spanPadding){
        halfSpace = spanPadding/2;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        if(parent.getPaddingLeft()!=halfSpace){
            parent.setPadding(halfSpace, halfSpace, halfSpace, halfSpace);
            parent.setClipToPadding(false);
        }

        outRect.top = halfSpace;
        outRect.right = halfSpace;
        outRect.left = halfSpace;
        outRect.bottom = halfSpace;

    }
}