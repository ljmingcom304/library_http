package com.ljming.http.okhttp;

import android.os.Message;
import com.ljming.http.parse.HttpCallBack;
import com.ljming.http.parse.HttpResult;
import java.io.Serializable;

/**
 * Title:HttpMessage
 * <p>
 * Description:子线程向主线程传递消息
 * </p>
 * Author Jming.L
 * Date 2017/11/1 11:04
 */
public class HttpMessage<T> {

    private Serializable serializable;
    private HttpResult httpResult;
    private HttpCallBack<T> callBack;

    public Serializable getSerializable() {
        return serializable;
    }

    public void setSerializable(Serializable serializable) {
        this.serializable = serializable;
    }

    public HttpCallBack<T> getCallBack() {
        return callBack;
    }

    public void setCallBack(HttpCallBack<T> callBack) {
        this.callBack = callBack;
    }

    public HttpResult getHttpResult() {
        return httpResult;
    }

    public void setHttpResult(HttpResult httpResult) {
        this.httpResult = httpResult;
    }

    public Message build() {
        Message msg = new Message();
        msg.obj = this;
        return msg;
    }
}
