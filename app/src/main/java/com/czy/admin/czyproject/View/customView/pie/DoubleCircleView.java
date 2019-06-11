package com.czy.admin.czyproject.View.customView.pie;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Create by cpSir on 2019/6/11
 */
public class DoubleCircleView extends View {

    // 宽高
    private int mWidth, mHeight;
    // 画笔
    private Paint mPaint = new Paint();


    public DoubleCircleView(Context context) {
        super(context);
    }

    public DoubleCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

// 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);

        canvas.drawCircle(0, 0, 400, mPaint);          // 绘制两个圆形
        canvas.drawCircle(0, 0, 380, mPaint);

        for (int i = 0; i <= 360; i += 10) {               // 绘制圆形之间的连接线
            canvas.drawLine(0, 380, 0, 400, mPaint);
            canvas.rotate(10);
        }
    }
}
