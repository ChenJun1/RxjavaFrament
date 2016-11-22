package com.cvnavi.logistics.rxjavaframent.mode.entity;

/**
 * 版权所有 势航网络
 * Created by ${ChenJ} on 2016/11/16.
 */

public class BaseRequest<T> {
    /**
     * 所属系统
     */
    public String ActionSystem = "APP";

    /**
     * 用户Key
     */
    public String User_Key;

    /**
     * 用户类型
     */
    public String UserType_Oid;

    /**
     * 用户登录令牌Token
     */
    public String Token;

    /**
     * 公司ID
     */
    public String Company_Oid;


    public String Org_Code;//是	用户所属机构
    public String Org_Name;//是	机构名称

    public String User_Name; //用户名

    public String User_Tel; //手机号

    public T DataValue;
}
