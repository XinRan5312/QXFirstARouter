package com.ran.qxarouter;


import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;

/**
 * Created by houqixin on 2017/5/26.
 * 配合拦截器Interceptor工作 当满足拦截器的条件的时候
 * 拦截器InterceptorCallback的方法里就会调用onInterrupt(Postcard postcard)
 */
public abstract class QXBaseNativationCallBack implements NavigationCallback {
    //我们跳转的时候要传入这个Callback如果想响应拦截器的结果
    @Override
    public void onFound(Postcard postcard) {
       //找到
    }

    @Override
    public void onLost(Postcard postcard) {
        //丢失
    }

    @Override
    public void onArrival(Postcard postcard) {
       //达到
    }

    @Override
    public void onInterrupt(Postcard postcard) {
       //被打断
        onInterrupted(postcard);

    }

    public abstract void onInterrupted(Postcard postcard);
}
