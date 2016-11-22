package com.cvnavi.logistics.rxjavaframent.mode.request;

/**
 * 版权所有 势航网络
 * Created by ${ChenJ} on 2016/11/16.
 */

public class RequestMode {

    /**
     * UUID : 9673851c-7250-446a-bdf0-1fecf9808651
     * User_Tel : 13111111101
     * VerifyCode : 6666
     */

    private String UUID;
    private String User_Tel;
    private String VerifyCode;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getUser_Tel() {
        return User_Tel;
    }

    public void setUser_Tel(String User_Tel) {
        this.User_Tel = User_Tel;
    }

    public String getVerifyCode() {
        return VerifyCode;
    }

    public void setVerifyCode(String VerifyCode) {
        this.VerifyCode = VerifyCode;
    }

    public RequestMode(String UUID, String user_Tel, String verifyCode) {
        this.UUID = UUID;
        User_Tel = user_Tel;
        VerifyCode = verifyCode;
    }
}
