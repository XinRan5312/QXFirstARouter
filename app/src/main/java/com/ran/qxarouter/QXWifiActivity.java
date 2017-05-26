package com.ran.qxarouter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/wifi/1",extras = QXUtils.CHECK_IS_WIFI,priority = 1)
public class QXWifiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qxwifi);

        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/login/1").navigation(QXWifiActivity.this, new QXBaseNativationCallBack() {
                    @Override
                    public void onInterrupted(Postcard postcard) {

                        final String path=postcard.getPath();

                        String group=postcard.getGroup();

                        int priority=postcard.getPriority();

                        Bundle bundle=postcard.getExtras();

                        int extras=postcard.getExtra();

                        Object tag=postcard.getTag();
                        //该方法是在子线程 要返回到主线程
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(QXWifiActivity.this,"没有登录"+path,Toast.LENGTH_LONG).show();
                            }
                        });



                        //也就是说一旦页面跳转被打断了 我可以得到他所有的跳转信息
                    }
                });
            }
        });
    }
}
