package com.czy.admin.czyproject.NetWork.OkHttp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.czy.admin.czyproject.R;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by czy on 2017/4/17.
 */

public class OkHttpActivity extends Activity{
    private OkHttpClient mOkHttpClient;

    private Button get_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        //创建okHttpClient对象
        mOkHttpClient = new OkHttpClient();
        get_txt=(Button) findViewById(R.id.get_txt);

        get_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getByGet();
            }
        });
    }


    /**
     * get请求
     */
    private void getByGet(){

        //创建一个Request
        final Request request = new Request.Builder()
                .url("https://api.github.com")
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "请求失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }




}
