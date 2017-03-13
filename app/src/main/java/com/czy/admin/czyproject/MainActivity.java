package com.czy.admin.czyproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.czy.admin.czyproject.Http.HttpActivity;
import com.czy.admin.czyproject.RxJava.RxJavaActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button main_rxjava_btn,main_http_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_rxjava_btn=(Button)findViewById(R.id.main_rxjava_btn);
        main_http_btn=(Button)findViewById(R.id.main_http_btn);

        main_rxjava_btn.setOnClickListener(this);
        main_http_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.main_rxjava_btn:
                //跳转到RxJavaActivity
                Intent intent = new Intent(this,RxJavaActivity.class);
                startActivity(intent);

                break;
            case R.id.main_http_btn:
                Intent intent1 = new Intent(this,HttpActivity.class);
                startActivity(intent1);

                break;
            default:
                break;

        }
    }

}
