package com.example.conmute;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;

public class FartherViewGroup  extends ViewGroup {

    private int deFultL;
    private int deFultT;
    private ArrayList<Integer> rowHight=new ArrayList<>();


    public FartherViewGroup(Context context) {
        super(context);
    }

    public FartherViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FartherViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       //super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //测量子布局
        measureChildren(widthMeasureSpec,heightMeasureSpec);

        //测量自己
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        deFultL = l;
        deFultT = t;

        //摆放位置
        for (int i = 0; i < getChildCount(); i++) {
            //得到子布局个数
            View childAt = getChildAt(i);
            //测量得到的宽高
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();

            if((deFultL+measuredWidth)>=getMeasuredWidth()){
              //回去最大值
                Integer max = Collections.max(rowHight);
                //清空集合
                rowHight.clear();
                //找到最大值
                deFultT+=max;
                deFultL=l;
                childAt.layout(deFultL,deFultT,deFultL+measuredWidth,deFultT+measuredHeight);
                deFultL+=measuredWidth;
                //将最大值存入集合
                rowHight.add(childAt.getMeasuredHeight());
            }else {
                childAt.layout(deFultL,deFultT,deFultL+measuredWidth,deFultT+measuredHeight);
                rowHight.add(childAt.getMeasuredHeight());
                deFultL+=measuredHeight;

            }
        }
    }
}
