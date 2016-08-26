package com.lxy.view.watch;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by user on 2016/8/26.
 */
public class WatchView extends View {

    private Paint mPaint;//外圆画笔
    private Paint mHourPaint;//小时刻度画笔
    private Paint mHourTvPaint;//小时文字画笔
    private Paint mPointPaint;//圆心画笔
    private Paint mHourRPaint;//时针画笔
    private Paint mMinuteRPaint;//分针画笔
    private Paint mSecondRPaint;//秒针画笔

    private int mWidth;
    private int mHeight;
    private float mHourR;//时针的长度
    private float mMinuteR;
    private float mSecondR;

    public WatchView(Context context) {
        super(context);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public WatchView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public WatchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WatchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();//外圈圆的画笔
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#39c6c1"));
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.STROKE);//设置空心

        mPointPaint = new Paint();//外圈圆的画笔
        mPointPaint.setAntiAlias(true);
        mPointPaint.setColor(Color.parseColor("#39c6c1"));
        mPointPaint.setStrokeWidth(10);


        mHourPaint = new Paint();
        mPointPaint.setAntiAlias(true);
        mHourPaint.setColor(Color.parseColor("#000000"));
        mHourPaint.setStrokeWidth(8);//刻度的宽度

        mHourTvPaint = new Paint();
        mPointPaint.setAntiAlias(true);
        mHourTvPaint.setColor(Color.parseColor("#000000"));
        mHourTvPaint.setStrokeWidth(5);//刻度的宽度
        mHourTvPaint.setTextSize(35);
        //时针
        mHourRPaint = new Paint();

        mMinuteRPaint = new Paint();

        mSecondRPaint = new Paint();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //处理控件包裹内容的情况

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        mWidth = getWidth();
        mHeight = getHeight();

        mHourR = mWidth / 2 / 3;//半径的三分之一
        mMinuteR = mWidth / 2;//半径的二分之一
        mSecondR = mWidth / 3;//半径的三分之二

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画表盘
        canvas.drawCircle(mWidth / 2, mHeight / 2, mHeight / 2, mPaint);
        //画圆心
        canvas.drawCircle(mWidth / 2, mHeight / 2, 15, mPointPaint);


        //画整点刻度
        drawHour(canvas);
        //画整点文字
        drawText(canvas);
        //
        drawSecondR(canvas);


    }


    //画整点刻度
    public void drawHour(Canvas canvas) {

        for (int i = 1; i < 13; i++) {
            canvas.save();
            canvas.rotate(30 * i, mWidth / 2, mHeight / 2);//先画线再旋转无效
            canvas.drawLine(0, mHeight / 2, 30, mHeight / 2, mHourPaint);
            canvas.restore();
        }
    }

    //画整点文字
    public void drawText(Canvas canvas) {

        for (int i = 1; i < 13; i++) {
            canvas.save();
            canvas.rotate(30 * i, mWidth / 2, mHeight / 2);//先画线再旋转无效
            canvas.drawText(i + "", mWidth / 2 - 10, 60, mHourTvPaint);
            canvas.restore();
        }
    }

    //画秒针
    public void drawSecondR(Canvas canvas){
        canvas.drawLine(mWidth/2,mHeight/2,40,40,mHourRPaint);
    }
}
