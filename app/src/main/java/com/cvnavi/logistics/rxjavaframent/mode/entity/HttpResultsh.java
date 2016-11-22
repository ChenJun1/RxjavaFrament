package com.cvnavi.logistics.rxjavaframent.mode.entity;

/**
 * 版权所有 势航网络
 * Created by ${ChenJ} on 2016/11/17.
 */

public class HttpResultsh<T> {
    private boolean Success;
    private Object ErrorText;
    private Object MsgType;
    private int RowCount;
    private int method;
    private T DataValue;


    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }



    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public Object getErrorText() {
        return ErrorText;
    }

    public void setErrorText(Object errorText) {
        ErrorText = errorText;
    }

    public Object getMsgType() {
        return MsgType;
    }

    public void setMsgType(Object msgType) {
        MsgType = msgType;
    }

    public int getRowCount() {
        return RowCount;
    }

    public void setRowCount(int rowCount) {
        RowCount = rowCount;
    }

    public T getDataValue() {
        return DataValue;
    }

    public void setDataValue(T dataValue) {
        DataValue = dataValue;
    }
}
