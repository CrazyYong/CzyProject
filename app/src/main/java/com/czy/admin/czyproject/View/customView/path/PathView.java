package com.czy.admin.czyproject.View.customView.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Create by cpSir on 2019/6/12
 */
public class PathView extends View {

    // 画笔
    private Paint mPaint = new Paint();

    private int mHeight, mWidth;

    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE); //画笔填充描边
        mPaint.setStrokeWidth(10); //描边宽度 10
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = h;
        mWidth = w;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth / 2, mHeight / 2);

        /**
         * lineTo
         */
//        canvas.drawLine(-mWidth / 2,0,mWidth / 2,0,mPaint);
//        canvas.drawLine(0,-mHeight / 2,0,mHeight / 2,mPaint);
//        Path path = new Path();
//        path.lineTo(200,200);
//        path.lineTo(200,0);
//        canvas.drawPath(path,mPaint);

        /**
         * moveTo
         */
//        canvas.drawLine(-mWidth / 2,0,mWidth / 2,0,mPaint);
//        canvas.drawLine(0,-mHeight / 2,0,mHeight / 2,mPaint);
//        Path path = new Path();
//        path.lineTo(200,200);
//        path.moveTo(200,100);
//        path.lineTo(200,0);
//        canvas.drawPath(path,mPaint);

        /**
         * setLastPoint
         */
//        canvas.drawLine(-mWidth / 2,0,mWidth / 2,0,mPaint);
//        canvas.drawLine(0,-mHeight / 2,0,mHeight / 2,mPaint);
//        Path path = new Path();
//        path.lineTo(200,200);
//        path.setLastPoint(200,100);
//        path.lineTo(200,0);
//        canvas.drawPath(path,mPaint);

        /**
         * close
         */
//        Paint paint = new Paint();
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.STROKE); //画笔填充描边
//        paint.setStrokeWidth(10); //描边宽度 10
//        canvas.drawLine(-mWidth / 2,0,mWidth / 2,0,paint);
//        canvas.drawLine(0,-mHeight / 2,0,mHeight / 2,paint);
//        Path path = new Path();
//        path.lineTo(200,200);
//        path.lineTo(200,0);
//        path.close();
//        canvas.drawPath(path,mPaint);

        /**
         * addRect
         */
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE); //画笔填充描边
        paint.setStrokeWidth(10); //描边宽度 10
        canvas.drawLine(-mWidth / 2,0,mWidth / 2,0,paint);
        canvas.drawLine(0,-mHeight / 2,0,mHeight / 2,paint);
        Path path = new Path();
        path.addRect(-200,-200,200,200,Path.Direction.CCW);
        path.setLastPoint(-300,300);
        canvas.drawPath(path,mPaint);
        canvas.drawPoint(-200,200,paint);
    }
}
