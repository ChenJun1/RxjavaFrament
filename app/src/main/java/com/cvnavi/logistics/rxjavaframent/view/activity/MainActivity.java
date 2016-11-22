package com.cvnavi.logistics.rxjavaframent.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cvnavi.logistics.rxjavaframent.R;
import com.cvnavi.logistics.rxjavaframent.base.BaseActivity;
import com.cvnavi.logistics.rxjavaframent.mode.entity.BaseRequest;
import com.cvnavi.logistics.rxjavaframent.mode.entity.mUserInfoBase;
import com.cvnavi.logistics.rxjavaframent.mode.request.RequestMode;
import com.cvnavi.logistics.rxjavaframent.presenter.Loginpt;
import com.cvnavi.logistics.rxjavaframent.reft.presenter.Presenter;
import com.cvnavi.logistics.rxjavaframent.reft.subscribers.ProgressSubscriber;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @Bind(R.id.dian)
    Button mDian;
    @Bind(R.id.dian_xia)
    Button mDianXia;
    @Bind(R.id.text_tv)
    TextView mTextTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        BaseRequest<RequestMode> request = new BaseRequest<>();
//        request.DataValue = new RequestMode("9673851c-7250-446a-bdf0-1fecf980865", "13111111101", "6666");
//        mPresenter.excute(1, mProgressSubscriber, request);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public Presenter initPresenter() {
        return new Loginpt();
    }

    @Override
    public ProgressSubscriber getProgressSubscriber() {
        return new ProgressSubscriber(mOnNextListener,this);
    }


    @OnClick({R.id.dian,R.id.dian_xia})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dian:
                mTextTv.setText("");
                BaseRequest<RequestMode> request = new BaseRequest<>();
                request.DataValue = new RequestMode("9673851c-7250-446a-bdf0-1fecf980865", "13111111101", "6666");
                mPresenter.excute(1,getProgressSubscriber(), request);
                break;
            case R.id.dian_xia:
                TowActivity.start(this);
                break;
        }

    }

    @Override
    public void onNext(Object o) {
        mUserInfoBase infoBase = (mUserInfoBase) o;
        mTextTv.setText(infoBase.toString());
    }
}
