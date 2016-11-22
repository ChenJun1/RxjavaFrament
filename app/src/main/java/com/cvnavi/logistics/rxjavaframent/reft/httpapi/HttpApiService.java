package com.cvnavi.logistics.rxjavaframent.reft.httpapi;


import com.cvnavi.logistics.rxjavaframent.mode.entity.BaseRequest;
import com.cvnavi.logistics.rxjavaframent.mode.entity.HttpResultsh;
import com.cvnavi.logistics.rxjavaframent.mode.entity.mUserInfoBase;
import com.cvnavi.logistics.rxjavaframent.mode.request.RequestMode;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by chenj on 16/11/9.
 */
public interface HttpApiService {


//    @GET("top250")
//    Observable<HttpResult<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);

//    @FormUrlEncoded
//    @POST("GetAppLogin")
//    Observable<HttpResultsh<mUserInfoBase>> getLogin(@Field("UUID") String uuid, @Field("User_Tel") String User_Tel, @Field("VerifyCode") String VerifyCode);

    @POST("GetAppLogin")
    Observable<HttpResultsh<mUserInfoBase>> getLogin(@Body BaseRequest<RequestMode> mode);

    @POST("GetAppAutoLogin")
    Observable<HttpResultsh<mUserInfoBase>> getAutoLogin(@Body BaseRequest mode);
}
