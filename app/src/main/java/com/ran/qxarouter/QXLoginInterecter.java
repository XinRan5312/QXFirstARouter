package com.ran.qxarouter;


import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;



/**
 * Created by houqixin on 2017/5/26.
 *
 * 我们只需写自定义的IInterceptor拦截类，ARouter会自动生产中间类，然后才实行
 * 页面跳转的时候，进行拦截
 *
 * 我们可以自定义一个这样的类，也可以定义n个，建议一个功能模块定义一个
 */
@Interceptor(priority = 1, name = "拦截未登录或者没有WIFI")
public class QXLoginInterecter  implements IInterceptor{


    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        //在这里进行过滤拦截
        if(postcard.getExtra()==QXUtils.CHECK_LOGIN){

            if(!QXUtils.isLogIn()){
                //会调用NavigationCallback接口的onInterrupt(Postcard postcard)方法，如果跳转的时候传入了Callback
                callback.onInterrupt(new Throwable(postcard.getPath()+"CHECK_LOGIN"));
            }else{
                callback.onContinue(postcard);
            }
        }else if(postcard.getExtra()==QXUtils.CHECK_IS_WIFI){
            if(!QXUtils.isWifi()){
                //会调用NavigationCallback接口的onInterrupt(Postcard postcard)方法，如果跳转的时候传入了Callback
                callback.onInterrupt(new Throwable(postcard.getPath()+"CHECK_IS_WIFI"));
            }else{
                callback.onContinue(postcard);
            }
        }else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        Log.e("IInterceptor","初始化init");
    }
}
