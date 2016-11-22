package com.cvnavi.logistics.rxjavaframent.widget.itemdecoration;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Chenj on 16/9/2.
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    private final int mHeight;
    private int mOrientation;

    public SpaceItemDecoration(int orientation, int dividerHeight) {
        setOrientation(orientation);
        mHeight = dividerHeight;
    }

    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildLayoutPosition(view);
        if (mOrientation == VERTICAL_LIST) {
            if (position == 0) {
                outRect.set(mHeight, mHeight, mHeight, mHeight);
            } else {
                outRect.set(mHeight, 0, mHeight, mHeight);
            }
        } else {
            if (position == 0) {
                outRect.set(mHeight, mHeight, mHeight, mHeight);
            } else
                outRect.set(0, mHeight, mHeight, mHeight);
        }
    }
}
