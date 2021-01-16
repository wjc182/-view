package com.example.conmute;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class AttrView extends View {
    //画笔
    private Paint paint;
    private String string;
    private Float dimension;
    private float rawX;
    private float rawY;

    public AttrView(Context context) {
        this(context,null);
    }

    public AttrView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AttrView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        //画笔颜色
        paint.setColor(0xFFF6071C);
        //获取文本
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AttrView);

        string = typedArray.getString(R.styleable.AttrView_attr_text);

        dimension = typedArray.getDimension(R.styleable.AttrView_attr_size,10);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //触摸事件
        switch (event.getAction()){
            case MotionEvent.ACTION_POINTER_UP:

                break;
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                //触摸日志
                Log.e("TAG","手指触摸：x"+event.getX()+"--Y"+event.getY());

                rawX = event.getRawX();
                rawY = event.getRawY();
                Log.e("TAG","手指触摸：x"+ rawX +"--Y"+ rawY);
                //废止 重绘
                invalidate();
                break;
        }
        return true;
    }
    float sweepAngle = 10;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        RectF rectF = new RectF();
//        rectF.left = 50;
//        rectF.top = 50;
//        rectF.right = 200;
//        rectF.bottom = 200;
//        paint.setStrokeWidth(10);
//        paint.setColor(0xffffffff);
//        paint.setStyle(Paint.Style.STROKE);
//
//        canvas.drawArc(rectF,0,sweepAngle,false,paint);
//        ++sweepAngle;
//
//        if(sweepAngle > 360){
//            Toast.makeText(getContext(), "下载完成", Toast.LENGTH_SHORT).show();
//        }else{
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            invalidate();
//        }


        //画布
        paint.setTextSize(dimension);

        canvas.drawText("x---"+rawX+"---y"+rawY,100,100,paint);

        paint.setColor(Color.GREEN);

        canvas.drawCircle(rawX,rawY,100,paint);
    }
}
