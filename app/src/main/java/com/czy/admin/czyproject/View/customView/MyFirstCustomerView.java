package com.czy.admin.czyproject.View.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.czy.admin.czyproject.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cmx on 2018/3/6.
 */

public class MyFirstCustomerView extends View implements View.OnClickListener{
    private Context mContext;
    /**
     * 文本
     */
    private String mText;
    /**
     * 文本的颜色
     */
    private int mTextColor;
    /**
     * 文本的大小
     */
    private int mTextSize;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mBound;
    private Paint mPaint;
    public MyFirstCustomerView(Context context) {
        this(context,null);
    }

    //默认情况下，系统调用的是这个构造函数
    public MyFirstCustomerView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public MyFirstCustomerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        //获取 TypedArray 对象
        TypedArray _TypedArray = mContext.getTheme().obtainStyledAttributes(attrs, R.styleable.MyFirstCustomerView, 0, 0);
        try {
            mText = _TypedArray.getString(R.styleable.MyFirstCustomerView_text);
            mTextColor = _TypedArray.getColor(R.styleable.MyFirstCustomerView_textColor, Color.BLUE);
            mTextSize = _TypedArray.getDimensionPixelSize(R.styleable.MyFirstCustomerView_textSize,
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 35, getResources().getDisplayMetrics()));
        } finally {
            _TypedArray.recycle();
        }
        /**
         * 获得绘制文本的宽和高
         */
        mPaint = new Paint();
        mPaint.setTextSize(mTextSize);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mBound = new Rect();
        Log.i("Tag", "TextLength:" + mText.length());
        mPaint.getTextBounds(mText, 0, mText.length(), mBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.i("Tag", "onMeasure():");
        int _WidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int _WidthSpec = MeasureSpec.getSize(widthMeasureSpec);
        int _HeightMode = MeasureSpec.getMode(heightMeasureSpec);
        int _HeightSpec = MeasureSpec.getSize(heightMeasureSpec);
        int _Width;
        int _Height;
        //宽度
        if(_WidthMode == MeasureSpec.EXACTLY){
            _Width = _WidthSpec;
        }else{
            mPaint.setTextSize(mTextSize);
            mPaint.getTextBounds(mText, 0, mText.length(), mBound);
            float _TextWidth = mBound.width();
            _Width = (int) (getPaddingLeft() + _TextWidth + getPaddingRight());
        }
        //高度
        if(_HeightMode == MeasureSpec.EXACTLY){
            _Height = _HeightSpec;
        }else{
            mPaint.setTextSize(mTextSize);
            mPaint.getTextBounds(mText, 0, mText.length(), mBound);
            float _TextHeight = mBound.height();
            _Height = (int) (getPaddingTop() + _TextHeight + getPaddingBottom());
        }

        setMeasuredDimension(_Width, _Height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.i("Tag", "onDraw():");
        mPaint.setColor(Color.YELLOW);
        Log.i("Tag", "getMeasuredWidth():" + getMeasuredWidth() + "   " + getMeasuredHeight());
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

        mPaint.setColor(mTextColor);
        Log.i("Tag", "getWidth():" + getWidth() + "   " + getHeight());
        Log.i("Tag", "mBound.width():" + mBound.width() + "   " + mBound.height());
        canvas.drawText(mText, getWidth() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(mContext,"点击了...",Toast.LENGTH_SHORT).show();
    }
}
