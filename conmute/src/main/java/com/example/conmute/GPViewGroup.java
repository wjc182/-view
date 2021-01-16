package com.example.conmute;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class GPViewGroup extends ViewGroup {


    public GPViewGroup(Context context) {
        super(context);
    }

    public GPViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GPViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //测量子布局
        measureChildren(widthMeasureSpec,heightMeasureSpec);

        //测量自己
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //摆放位置
        for (int i = 0; i < getChildCount(); i++) {
            //得到子布局个数
            View childAt = getChildAt(i);

            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            childAt.layout(l,t,l+measuredWidth,t+measuredHeight);

        }
    }
}
