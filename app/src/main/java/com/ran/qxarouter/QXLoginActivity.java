package com.ran.qxarouter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/login/1",extras = QXUtils.CHECK_LOGIN,priority = 2)
public class QXLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qxlogin);
        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/main/1").navigation(QXLoginActivity.this, new QXBaseNativationCallBack() {
                    @Override
                    public void onInterrupted(Postcard postcard) {

                        String path=postcard.getPath();

                        String group=postcard.getGroup();

                        int priority=postcard.getPriority();

                        Bundle bundle=postcard.getExtras();

                        int extras=postcard.getExtra();

                        Object tag=postcard.getTag();

                        //也就是说一旦页面跳转被打断了 我可以得到他所有的跳转信息
                    }
                });
            }
        });
    }
}
