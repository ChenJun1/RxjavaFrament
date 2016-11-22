package com.cvnavi.logistics.rxjavaframent.reft.http;

import com.cvnavi.logistics.rxjavaframent.mode.entity.HttpResultsh;
import com.cvnavi.logistics.rxjavaframent.reft.excption.ApiException;

import rx.functions.Func1;

/**
 * 版权所有 势航网络
 * Created by ${ChenJ} on 2016/11/16.
 */

public class HttpResultFunc<T> implements Func1<HttpResultsh<T>, T> {
    private int method;
    @Override
    public T call(HttpResultsh<T> tHttpResult) {
        if (!tHttpResult.isSuccess()) {
            throw new ApiException(100);
        }
        tHttpResult.setMethod(method);
        return tHttpResult.getDataValue();
    }

    public HttpResultFunc(int method){
        super();
        this.method=method;
    }
}
