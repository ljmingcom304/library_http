package com.ljming.http.parse;


import android.text.TextUtils;
import android.util.Log;
import com.ljming.http.okhttp.ProgressUIListener;
import java.io.Serializable;


public abstract class HttpCallBack<T> extends ProgressUIListener {

    private String TAG = "HttpCallBack";

    /**
     * 处理网络请求失败
     */
    public final void onResult(HttpResult httpResult, Serializable result) {
        if (!onPreExecute(httpResult)) {
            if (httpResult.getHttpCode() == HttpCode.SUCCESS) {
                this.onSuccess(result);
            } else if (httpResult.getHttpCode() == HttpCode.NO_DATA) {
                this.onEmpty(httpResult);
            } else {
                this.onFailure(httpResult);
            }
        }
        this.onPostExecute();
    }

    protected boolean onPreExecute(HttpResult httpResult) {
        return onPreExecute(httpResult.getHttpCode());
    }

    protected boolean onPreExecute(HttpCode httpcode) {
        return false;
    }

    /**
     * 网络请求成功
     */
    protected abstract void onSuccess(Serializable s);

    /**
     * 网络请求失败
     */
    protected void onFailure(HttpResult httpResult) {
        HttpCode httpCode = httpResult.getHttpCode();
        String msg = httpResult.getMsg();
        if (TextUtils.isEmpty(msg)) {
            msg = httpCode.getDescription();
        }
        String logger = "[Code:" + httpCode.getCode() + "][Msg:" + msg + "]";
        Log.e(TAG, logger);
        onFailure(msg);
    }

    /**
     * 网络请求失败
     */
    protected void onFailure(String message) {

    }

    /**
     * 网络请求失败
     */
    protected void onEmpty(HttpResult httpResult) {
        HttpCode httpCode = httpResult.getHttpCode();
        String msg = httpResult.getMsg();
        if (TextUtils.isEmpty(msg)) {
            msg = httpCode.getDescription();
        }
        String logger = "[Code:" + httpCode.getCode() + "][Msg:" + msg + "]";
        Log.e(TAG, logger);
        onEmpty(msg);
    }

    /**
     * 网络请求为空
     */
    protected void onEmpty(String message) {
        Log.e(TAG, message);
    }

    /**
     * 执行后处理
     */
    protected void onPostExecute() {

    }

    @Override
    public void onStart(long totalBytes) {
        Log.i(TAG, "============= onStart ===============");
    }

    @Override
    public void onChanged(long numBytes, long totalBytes, float percent, float speed) {
        Log.i(TAG, "[NumBytes:" + numBytes + "][TotalBytes:" + totalBytes + "][Percent:" + percent + "][Speed:" + speed + "]");
    }

    @Override
    public void onFinish() {
        Log.i(TAG, "============= onFinish ===============");
    }

}
