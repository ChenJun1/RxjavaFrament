package com.cvnavi.logistics.rxjavaframent.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cvnavi.logistics.rxjavaframent.R;
import com.cvnavi.logistics.rxjavaframent.base.BaseRecyclerViewAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 版权所有 势航网络
 * Created by ${ChenJ} on 2016/11/18.
 */

public class TowAdapter extends BaseRecyclerViewAdapter<String> {
    private List<String> mStringList;

    public TowAdapter(Context context, @NonNull List<String> list) {
        super(context, list);
        this.mStringList=list;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.itme_tow;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBindView(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;

        viewHolder.mTextTv.setText( mStringList.get(position));
        setOnItemClick(position,((ViewHolder) holder).mTextTv);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.text_tv)
        TextView mTextTv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
