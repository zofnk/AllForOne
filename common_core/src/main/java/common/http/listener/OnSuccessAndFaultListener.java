package common.http.listener;

/**
 * Created by zbf on 2018/3/27.
 */
public interface OnSuccessAndFaultListener<T> {
    void onSuccess(T result);

    void onFault(String errorMsg);
}
