package com.cvnavi.logistics.rxjavaframent.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cvnavi.logistics.rxjavaframent.R;
import com.cvnavi.logistics.rxjavaframent.base.BaseActivity;
import com.cvnavi.logistics.rxjavaframent.base.listener.OnItemClickListener;
import com.cvnavi.logistics.rxjavaframent.base.listener.OnLoadMoreListener;
import com.cvnavi.logistics.rxjavaframent.mode.entity.BaseRequest;
import com.cvnavi.logistics.rxjavaframent.mode.entity.mUserInfoBase;
import com.cvnavi.logistics.rxjavaframent.mode.request.RequestMode;
import com.cvnavi.logistics.rxjavaframent.presenter.Loginpt;
import com.cvnavi.logistics.rxjavaframent.reft.presenter.Presenter;
import com.cvnavi.logistics.rxjavaframent.reft.subscribers.ProgressSubscriber;
import com.cvnavi.logistics.rxjavaframent.utils.DensityUtil;
import com.cvnavi.logistics.rxjavaframent.view.adapter.TowAdapter;
import com.cvnavi.logistics.rxjavaframent.widget.itemdecoration.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 版权所有 势航网络
 * Created by ${ChenJ} on 2016/11/17.
 */

public class TowActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener, OnItemClickListener {

    @Bind(R.id.text_tv)
    TextView mTextTv;
    @Bind(R.id.dian)
    Button mDian;
    @Bind(R.id.rv)
    RecyclerView mRv;
    @Bind(R.id.rf_layout)
    SwipeRefreshLayout mRfLayout;

    private TowAdapter mTowAdapter=null;

    public static void start(Context context) {
        Intent starter = new Intent(context, TowActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }
    List<String> list;
    private void initView() {
        list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i+"是谁唱的歌");
        }
        mTowAdapter=new TowAdapter(this,list);

        LinearLayoutManager linerar=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRv.setLayoutManager(linerar);
        mRv.setItemAnimator(new DefaultItemAnimator());
        mRv.addItemDecoration(new SpaceItemDecoration(SpaceItemDecoration.VERTICAL_LIST, DensityUtil.dip2px(this, 10)));
        mRv.setAdapter(mTowAdapter);
        mTowAdapter.setOnLoadMoreListener(this,mRv);
        mRfLayout.setOnRefreshListener(this);
        mTowAdapter.setOnItemClickListener(this);
    }

    @Override
    public int getLayout() {
        return R.layout.tow_activity;
    }

    @Override //
    public Presenter initPresenter() {
        return new Loginpt();
    }

    @Override
    public ProgressSubscriber getProgressSubscriber() {
        return new ProgressSubscriber(mOnNextListener, this);
    }

    @Override
    public void onNext(Object o) {
        mUserInfoBase infoBase = (mUserInfoBase) o;
//        mTextTv.setText(infoBase.toString());
        mTowAdapter.setLoaded(true);
    }

    @OnClick(R.id.dian)
    public void onClick() {
        BaseRequest<RequestMode> request = new BaseRequest<>();
        request.DataValue = new RequestMode("a6ad0ded-35a5-4c3f-a0f6-5ff2a6bab561", "13111111101", "6666");
        mPresenter.excute(1, getProgressSubscriber(), request);
    }

    @Override
    public void onRefresh() {
        for (int i = 0; i < 10; i++) {
            list.add(i+"是谁唱的歌大大大啊");
            mTowAdapter.notifyDataSetChanged();
        }
        mRfLayout.setRefreshing(false);
    }

    @Override
    public void onItemClick(int position, View v) {
        Toast.makeText(this,"点击Rl",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadMore() {
        for (int i = 0; i < 10; i++) {
            list.add(i+"是谁唱的歌aaaaa");
        }
        mTowAdapter.notifyDataSetChanged();
        setload();

    }

    private void setload() {
        BaseRequest<RequestMode> request = new BaseRequest<>();
        request.DataValue = new RequestMode("a6ad0ded-35a5-4c3f-a0f6-5ff2a6bab561", "13111111101", "6666");
        mPresenter.excute(1, getProgressSubscriber(), request);

    }
}
