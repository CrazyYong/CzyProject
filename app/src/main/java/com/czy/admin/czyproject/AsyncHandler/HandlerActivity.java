package com.czy.admin.czyproject.AsyncHandler;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.czy.admin.czyproject.R;

import java.lang.ref.WeakReference;

/**
 * Created by czy on 2017/5/15.
 */

public class HandlerActivity extends Activity{
    private ProgressDialog pd;

    MyHandler myHandler = new MyHandler(this);

    private Button btn_download,btn_send_message,btn_post_message;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    pd.dismiss();
                    break;
                case 1:
       int upperNum = msg.getData().getInt("upper");
                    Toast.makeText(HandlerActivity.this, "值是多少--"+upperNum, Toast.LENGTH_SHORT).show();
                    break;

            }

        }
    };


    /**
     * 利用弱引用构造的静态内部类
     */
    public static class MyHandler extends Handler{

        private WeakReference<HandlerActivity> reference;

        public MyHandler(HandlerActivity activity) {
            reference = new WeakReference<HandlerActivity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    break;
                case 1:
                    break;

            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        btn_download=(Button)findViewById(R.id.btn_download);
        btn_send_message=(Button)findViewById(R.id.btn_send_message);
        btn_post_message=(Button)findViewById(R.id.btn_post_message);
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processThread();
            }
        });

        btn_send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal();
            }
        });

        btn_post_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Log.e("TAG", Thread.currentThread().getName());
                        btn_post_message.setText("恭喜你更新成功");
                    }
                });
            }
        });
    }


    /**
     *传输数据
     */
    public void cal() {
        Bundle bundle = new Bundle();
        bundle.putInt("upper", 2);
        //创建消息
        Message message = new Message();
        message.what = 1;
//       message.obj=2; 传输一个对象
//        Message msg = handler.obtainMessage(); 可以复用系统的message，不用重新New一个也可以
        message.setData(bundle);
        //发送消息
        handler.sendMessage(message);
    }


    private void processThread(){
        //构建一个下载进度条
        pd= ProgressDialog.show(HandlerActivity.this, "下载文件", "正在下载……");
        Log.i("tag", "processThread()-->"+Thread.currentThread().getName());
        new Thread(){
            @Override
            public void run(){
                Log.i("tag", "run()-->"+Thread.currentThread().getName());
                //在新线程里执行长耗时方法
                longTimeMethod();
                //执行完毕后给handler发送一个空消息
                handler.sendEmptyMessage(0);
            }
        }.start();
    }
    //模拟下载文件的长耗时方法
    private void longTimeMethod(){
        try {
            Log.i("tag", "longTimeMethod-->"+Thread.currentThread().getName());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
