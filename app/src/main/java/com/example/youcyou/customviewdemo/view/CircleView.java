package com.example.youcyou.customviewdemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.youcyou.customviewdemo.R;

/**
 * 继承View 重写onDraw
 *
 * @since 16/7/12.
 */
public class CircleView extends View {

    private int mColor = Color.RED;
    private int mRadius = 0;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        /**
         * 自定义属性
         */
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        mColor = a.getColor(R.styleable.CircleView_circle_color, Color.RED);
        mRadius = (int) a.getDimension(R.styleable.CircleView_circle_radius, 0);
        a.recycle();
        init();
    }

    private void init() {
        mPaint.setColor(mColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        if (mRadius == 0) {
            mRadius = Math.min(getMeasuredWidth() - paddingLeft - paddingRight, getMeasuredHeight() - paddingTop - paddingBottom) / 2;
        }

        /**
         *处理wrap_content
         */
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mRadius * 2 + paddingLeft + paddingRight, mRadius * 2 + paddingTop + paddingBottom);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mRadius * 2 + paddingLeft + paddingRight, heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, mRadius * 2 + paddingTop + paddingBottom);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * 处理padding
         */
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;
        canvas.drawCircle(paddingLeft + width / 2, paddingTop + height / 2, mRadius, mPaint);

    }
}
