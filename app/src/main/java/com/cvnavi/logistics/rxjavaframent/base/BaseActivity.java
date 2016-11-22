package com.cvnavi.logistics.rxjavaframent.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

import com.cvnavi.logistics.rxjavaframent.reft.presenter.Presenter;
import com.cvnavi.logistics.rxjavaframent.reft.subscribers.ProgressSubscriber;
import com.cvnavi.logistics.rxjavaframent.reft.subscribers.SubscriberOnNextListener;

import butterknife.ButterKnife;

/**
 * 版权所有 势航网络
 * Created by ${ChenJ} on 2016/11/17.
 */

public abstract class BaseActivity extends FragmentActivity implements SubscriberOnNextListener{
    public SubscriberOnNextListener mOnNextListener;//请求数据返回监听
    public Presenter mPresenter;//mode
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        mPresenter=initPresenter();
        mOnNextListener=this;
    }

    public abstract int getLayout();
    public abstract Presenter initPresenter();
    public abstract ProgressSubscriber getProgressSubscriber();


    // 点击空白处，关闭软键盘
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
                manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
        return super.onTouchEvent(event);
    }
}
