package com.example.yt.ytlogistics.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by chebole on 2018/7/25.
 */

public class MyCustomViewPager extends ViewPager {

    /**是否可以滑动：默认可以滑动*/
    private boolean isCanScroll = true;

    public MyCustomViewPager(Context context) {
        super(context);
    }

    public MyCustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 解决切换需要经过中间页
     */
    @Override
    public void setCurrentItem(int item) {
        //super.setCurrentItem(item);源码
        super.setCurrentItem(item,false);//smoothScroll false表示切换的时候,不经过两个页面的中间页
    }

    /**
     * 让ViewPager不能左右滑动
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(isCanScroll){
            return super.onTouchEvent(ev);
        }else{
            return false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(isCanScroll){
            return super.onInterceptTouchEvent(ev);
        }else{
            return false;
        }
    }

    /**
     * 暴露出去的方法,屏蔽ViewPager的滑动,默认不可滑动
     * @param isCanScroll 为true可以左右滑动,为false不可滑动
     */
    public void setIsCanScroll(boolean isCanScroll){
        this.isCanScroll = isCanScroll;
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {

        /*if (v instanceof IjkVideoView) {//解决视频播放器和viewpager滑动冲突问题
            return true;
        }*/
        return super.canScroll(v, checkV, dx, x, y);
    }
}
