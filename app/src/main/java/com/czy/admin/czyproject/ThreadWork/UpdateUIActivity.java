package com.czy.admin.czyproject.ThreadWork;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.czy.admin.czyproject.R;

/**
 * Created by admin on 2018/7/29.
 */

public class UpdateUIActivity extends Activity implements View.OnClickListener{
    private Button update_1,update_2,update_3,update_4;

    Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            update_2.setText("方法二更新了" +
                    "");
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_ui);
        update_1=(Button)findViewById(R.id.update_1);
        update_2=(Button)findViewById(R.id.update_2);
        update_3=(Button)findViewById(R.id.update_3);
        update_4=(Button)findViewById(R.id.update_4);
        update_1.setOnClickListener(this);
        update_2.setOnClickListener(this);
        update_3.setOnClickListener(this);
        update_4.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.update_1:
                methodOne();
                break;
            case R.id.update_2:
                //方法二
           handler.sendEmptyMessage(1);
                break;
            case R.id.update_3:
                //方法二
                methodThree();
                break;
            case R.id.update_4:
                methodFour();
                break;
        }

    }

    /**
     * 方法一
     */
    private void methodOne(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        update_1.setText("方法一更新了");
                    }
                });


            }
        }).start();
    }

    /**
     * 方法三
     */

    private void methodThree(){
        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        update_3.setText("方法三更新了");
                    }
                });
            }
        }).start();
    }

    /**
     * 切换到主线程
     */
    private void switchMainThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("CZAYAPP",Thread.currentThread().getName() );
                    }
                });
            }
        }).start();
    }

    /**
     * 方法四
     */
    private void methodFour(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                update_4.post(new Runnable() {
                    @Override
                    public void run() {
                        update_4.setText("方法四更新了");
                    }
                });
            }
        }).start();
    }

}
