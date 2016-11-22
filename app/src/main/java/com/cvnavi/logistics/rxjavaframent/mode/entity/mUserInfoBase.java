package com.cvnavi.logistics.rxjavaframent.mode.entity;

/**
 * 登录
 * Created by JohnnyYuan on 2016/7/5.
 */
public class mUserInfoBase {

    /// <summary>
    /// 操作令牌
    /// </summary>
    public String Token;
    /// <summary>
    /// 用户名
    /// </summary>
    public String User_Name;

    /// <summary>
    /// 用户电话
    /// </summary>
    public String User_Tel;

    /// <summary>
    /// 用户类型
    /// </summary>
    public String UserType_Oid;

    /// <summary>
    /// 公司ID
    /// </summary>
    public String Company_Oid;

    /// <summary>
    /// 唯一标识符
    /// </summary>
    public String UUID;

    /// <summary>
    /// 用户Key
    /// </summary>
    public String User_Key;

    /// <summary>
    /// 菜单列表
    /// </summary>

    /// <summary>
    /// 验证码
    /// </summary>
    public String VerifyCode;

    /// <summary>
    /// 用户状态
    /// </summary>
    public String UserStatus;

    public String IsUse;

    //机构号
    public String Org_Code;

    //机构名称
    public String Org_Name;

    //查询接口
    public String Search_NoLength;

    @Override
    public String toString() {
        return "mUserInfoBase{" +
                "Token='" + Token + '\'' +
                ", User_Name='" + User_Name + '\'' +
                ", User_Tel='" + User_Tel + '\'' +
                ", UserType_Oid='" + UserType_Oid + '\'' +
                ", Company_Oid='" + Company_Oid + '\'' +
                ", UUID='" + UUID + '\'' +
                ", User_Key='" + User_Key + '\'' +
                ", VerifyCode='" + VerifyCode + '\'' +
                ", UserStatus='" + UserStatus + '\'' +
                ", IsUse='" + IsUse + '\'' +
                ", Org_Code='" + Org_Code + '\'' +
                ", Org_Name='" + Org_Name + '\'' +
                ", Search_NoLength='" + Search_NoLength + '\'' +
                '}';
    }
}
