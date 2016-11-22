package com.cvnavi.logistics.rxjavaframent.presenter;

import com.cvnavi.logistics.rxjavaframent.mode.entity.BaseRequest;
import com.cvnavi.logistics.rxjavaframent.mode.entity.mUserInfoBase;
import com.cvnavi.logistics.rxjavaframent.mode.request.RequestMode;
import com.cvnavi.logistics.rxjavaframent.reft.http.HttpMethods;
import com.cvnavi.logistics.rxjavaframent.reft.http.HttpResultFunc;
import com.cvnavi.logistics.rxjavaframent.reft.presenter.Presenter;

import rx.Observable;
import rx.Subscriber;

/**
 * 版权所有 势航网络
 * Created by ${ChenJ} on 2016/11/17.
 */

public class Loginpt implements Presenter{
    @Override
    public void excute(int method, Subscriber subscriber, Object o) {
        Observable observable=null;
        switch (method){
            case 1:
                observable = HttpMethods.getInstance().getHttpApiService().getLogin((BaseRequest<RequestMode>)o)
                        .map(new HttpResultFunc<mUserInfoBase>(method));
                break;
            case 2:
                observable = HttpMethods.getInstance().getHttpApiService().getAutoLogin((BaseRequest)o)
                        .map(new HttpResultFunc<mUserInfoBase>(method));
                break;
        }
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }
}
