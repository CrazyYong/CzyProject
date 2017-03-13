package com.czy.admin.czyproject.Http;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.czy.admin.czyproject.R;

/**
 * Created by cmx on 2017/3/13.
 */

public class HttpActivity extends Activity implements HttpResultInterface {
    private Button btn_test;
    private HttpUtil httpUtil =null;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    String message = (String) msg.obj;
                    Toast.makeText(HttpActivity.this, message + "", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        btn_test = (Button) findViewById(R.id.btn_test);
        httpUtil = new HttpUtil(this);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        httpUtil.requestData();

                    }
                }).start();
            }
        });
    }

    public void returnData(String name){
        Message msg = handler.obtainMessage();
        msg.obj = name;
        msg.what = 1;
        handler.sendMessage(msg);
    }


}
