package netUtils;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLHandshakeException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

/**
 * Created by zbf on 2019/9/3.
 */

public class OnSuccessAndFaultSub<T> extends DisposableObserver<T> implements ProgressCancelListener {

    private OnSuccessAndFaultListener mOnSuccessAndFaultListener;

    /**
     * 是否需要显示默认Loading
     */
    private boolean showProgress = true;

    private Context context;
    private ProgressDialog progressDialog;


    /**
     * @param mOnSuccessAndFaultListener 成功回调监听
     */
    public OnSuccessAndFaultSub(OnSuccessAndFaultListener mOnSuccessAndFaultListener,Context context) {
        this.mOnSuccessAndFaultListener = mOnSuccessAndFaultListener;
        this.context = context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("正在加载中请稍后~");
    }


    /**
     * @param mOnSuccessAndFaultListener 成功回调监听
     * @param context 上下文
     * @param showProgress 是否需要显示默认Loading
     */
    public OnSuccessAndFaultSub(OnSuccessAndFaultListener mOnSuccessAndFaultListener, Context context, boolean showProgress) {
        this.mOnSuccessAndFaultListener = mOnSuccessAndFaultListener;
        this.context = context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("正在加载中请稍后~");
        this.showProgress = showProgress;
    }

    public OnSuccessAndFaultSub(OnSuccessAndFaultListener mOnSuccessAndFaultListener) {
        this.mOnSuccessAndFaultListener = mOnSuccessAndFaultListener;
    }

    private void showProgressDialog() {
        if (showProgress && null != progressDialog) {
            progressDialog.show();
        }
    }


    private void dismissProgressDialog() {
        if (showProgress && null != progressDialog) {
            progressDialog.dismiss();
        }
    }


    /**
     * 订阅开始时调用
     * 显示ProgressDialog
     */
    @Override
    public void onStart() {
        showProgressDialog();
    }




    @Override
    public void onNext(T t) {
        mOnSuccessAndFaultListener.onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        try {
            if (e instanceof SocketTimeoutException) {//请求超时
                mOnSuccessAndFaultListener.onFault("网络请求超时");
            } else if (e instanceof ConnectException) {//网络连接超时
                mOnSuccessAndFaultListener.onFault("网络连接超时");
            } else if (e instanceof SSLHandshakeException) {//安全证书异常
                mOnSuccessAndFaultListener.onFault("安全证书异常");
            } else if (e instanceof HttpException) {//请求的地址不存在
                int code = ((HttpException) e).code();
                if (code == 504) {
                    mOnSuccessAndFaultListener.onFault("网络异常，请检查您的网络状态");
                } else if (code == 404) {
                    mOnSuccessAndFaultListener.onFault("请求的地址不存在");
                } else {
                    mOnSuccessAndFaultListener.onFault("请求失败");
                }
            } else if (e instanceof UnknownHostException) {//域名解析失败
                mOnSuccessAndFaultListener.onFault("域名解析失败");
            } else {
                // 其他错误
                mOnSuccessAndFaultListener.onFault("error:网络异常");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            Log.e("OnSuccessAndFaultSub", "error:" + e.getMessage());
            dismissProgressDialog();
            progressDialog = null;
        }
    }

    @Override
    public void onComplete() {
        dismissProgressDialog();
        progressDialog = null;
    }

    @Override
    public void onCancelProgress() {
        if (!this.isDisposed()) {
            this.dispose();
        }
    }
}
