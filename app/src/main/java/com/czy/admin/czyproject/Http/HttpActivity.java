package com.czy.admin.czyproject.Http;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.czy.admin.czyproject.Http.SAX.SaxService;
import com.czy.admin.czyproject.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

/**
 * Created by czy on 2017/3/13.
 */

public class HttpActivity extends Activity implements HttpResultInterface {
    private Button btn_test;
    private Button btn_sax;
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
        btn_sax=(Button)findViewById(R.id.btn_sax);
        httpUtil = new HttpUtil(this);

        btn_sax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
              try{
                        URL url = new URL(HttpUtil.XML_URL);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.connect();
                        httpURLConnection.setConnectTimeout(4000);
                        httpURLConnection.setReadTimeout(4000);
                        InputStream inputStream = httpURLConnection.getInputStream();
                 List<HashMap<String,String>> list = SaxService.readXML(inputStream,"ad");
              for(HashMap<String,String>map:list){
                  Log.i("CZYAPP",map.get("ad_code"));
              }
                    }catch (Exception e){

                    }



                    }
                }).start();
            }
        });

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
