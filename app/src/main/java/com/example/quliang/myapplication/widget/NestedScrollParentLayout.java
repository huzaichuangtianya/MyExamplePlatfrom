package com.example.quliang.myapplication.widget;

import android.content.Context;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.quliang.myapplication.R;

/**
 * Created by quliang on 18-4-19.
 */

public class NestedScrollParentLayout extends RelativeLayout implements NestedScrollingParent{

    private final static String TAG=NestedScrollParentLayout.class.getSimpleName();
    private NestedScrollingParentHelper mParentHelper;
    private int                         mTitleHeight;
    private int                         mTitleHeight1;
    private View                        mTitleTabView;
    private View                        mTitleTabView1;

    public NestedScrollParentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NestedScrollParentLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        mParentHelper = new NestedScrollingParentHelper(this);
    }

    //获取子view
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mTitleTabView = this.findViewById(R.id.title_container);
        mTitleTabView1 = this.findViewById(R.id.title_container1);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mTitleHeight = mTitleTabView.getMeasuredHeight();
        mTitleHeight1 = mTitleTabView1.getMeasuredHeight();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec + mTitleHeight+ mTitleHeight1);
    }

    //接口实现--------------------------------------------------

    //在此可以判断参数target是哪一个子view以及滚动的方向，然后决定是否要配合其进行嵌套滚动
    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        if (target instanceof NestedListView) {
            return true;
        }
        return false;
    }


    @Override
    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {
        mParentHelper.onNestedScrollAccepted(child, target, nestedScrollAxes);
    }

    @Override
    public void onStopNestedScroll(View target) {
        mParentHelper.onStopNestedScroll(target);
    }

    //先于child滚动
    //前3个为输入参数，最后一个是输出参数
    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
//        Log.d(TAG,"dx:"+dx+"_dy:"+dy);
//        Log.d(TAG,"getScrollY:"+getScrollY());

        if (dy > 0) {//手势向上滑动
            if (getScrollY() <(mTitleHeight)) {
                scrollBy(0, dy);//滚动
                consumed[1] = dy;//告诉child我消费了多少
            }
        } else if (dy < 0) {//手势向下滑动
            if (getScrollY() > 0) {
                scrollBy(0, dy);//滚动
                consumed[1] = dy;//告诉child我消费了多少
            }
        }
    }

    //后于child滚动
    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {

    }

    //返回值：是否消费了fling
    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false;
    }

    //返回值：是否消费了fling
    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
//        if (!consumed) {
//            return true;
//        }
        return false;
    }

    @Override
    public int getNestedScrollAxes() {
        return mParentHelper.getNestedScrollAxes();
    }


    //scrollBy内部会调用scrollTo
    //限制滚动范围
    @Override
    public void scrollTo(int x, int y) {
        if (y < 0) {
            y = 0;
        }
        if (y > mTitleHeight) {
            y = mTitleHeight;
        }

        super.scrollTo(x, y);
    }

}
