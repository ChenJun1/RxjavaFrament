package com.cvnavi.logistics.rxjavaframent.reft.presenter;

import rx.Subscriber;

/**
 * Created by chenj on 16/11/6.
 */
public interface Presenter<T,Y>  {
     void excute(int method, Subscriber<T> subscriber, Y y);
}
