package me.dahei.touchtester;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * created by yubosu
 * 2018年08月02日上午10:21
 */
public class LogLinearLayout extends LinearLayout {

    private String TAG = "LogLinearLayout";

    private Boolean onIntercept = null;
    private Boolean dispatchTouch = null;
    private Boolean onTouch = null;



    public LogLinearLayout(Context context) {
        super(context);
    }

    public LogLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LogLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setTouchOption(Boolean onIntercept, Boolean dispatchTouch, Boolean onTouch) {
        this.onIntercept = onIntercept;
        this.dispatchTouch = dispatchTouch;
        this.onTouch = onTouch;
    }

    public void setName(String name) {
        this.TAG = name;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent");
        if(this.onIntercept == null) {
            return super.onInterceptTouchEvent(ev);
        }
        return onIntercept;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "dispatchTouchEvent action down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "dispatchTouchEvent action move");
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "dispatchTouchEvent action cancel");
                break;

        }
        if (this.dispatchTouch == null) {
            return super.dispatchTouchEvent(ev);
        }
        return dispatchTouch;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "onTouchEvent action down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "onTouchEvent action move");
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "onTouchEvent action cancel");
                break;

        }
        if(this.onTouch == null) {
            return super.onTouchEvent(event);
        }
        return onTouch;
    }
}
