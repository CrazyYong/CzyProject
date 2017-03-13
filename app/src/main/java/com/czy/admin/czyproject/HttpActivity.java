package com.czy.admin.czyproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cmx on 2017/3/13.
 */

public class HttpActivity extends Activity {
    private Button btn_test;
    private static final String REMOTE_CONFIG_URL_GAMEPAD1 = "http://211.170.59.204:18080/ota/company/innoplay/project/tim/device/gamepad1/firmware/latest";
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

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        testHttpConnection();
                    }
                }).start();
            }
        });
    }

    /**
     * HttpConnection访问网络请求
     */
    private void testHttpConnection() {
        try {
            URL url = new URL(REMOTE_CONFIG_URL_GAMEPAD1);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            httpURLConnection.setConnectTimeout(4000);
            httpURLConnection.setReadTimeout(4000);
            InputStream inputStream = httpURLConnection.getInputStream();
            byte data[] = new byte[256];
            inputStream.read(data);//InputString流读到data中
            String message = new String(data);//将data转换为String类型

            Message msg = handler.obtainMessage();
            msg.obj = message;
            msg.what = 1;
            handler.sendMessage(msg);
        } catch (Exception e) {

        }
    }


}
