package com.czy.admin.czyproject;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.czy.admin.czyproject.AsyncHandler.AsyncTaskActivity;
import com.czy.admin.czyproject.AsyncHandler.HandlerActivity;
import com.czy.admin.czyproject.FileOperate.FileOperateActivity;
import com.czy.admin.czyproject.Gson.GsonActivity;
import com.czy.admin.czyproject.Http.HttpActivity;
import com.czy.admin.czyproject.Http.OkHttp.OkHttpActivity;
import com.czy.admin.czyproject.RxJava.RxJavaActivity;
import com.czy.admin.czyproject.View.Fragment.FragmentMainActivity;
import com.czy.admin.czyproject.View.RecycleViewActivity;


public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button main_rxjava_btn,main_http_btn,main_gson_btn,main_okhttp_btn,main_create_file_btn,main_recycler_view_btn
            ,main_handler_view_btn,main_async_btn
            ,main_fragment_btn;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        main_rxjava_btn=(Button)findViewById(R.id.main_rxjava_btn);
        main_http_btn=(Button)findViewById(R.id.main_http_btn);
        main_gson_btn=(Button)findViewById(R.id.main_gson_btn);
        main_okhttp_btn=(Button)findViewById(R.id.main_okhttp_btn);
        main_create_file_btn=(Button)findViewById(R.id.main_create_file_btn);
        main_recycler_view_btn=(Button)findViewById(R.id.main_recycler_view_btn);
        main_handler_view_btn=(Button)findViewById(R.id.main_handler_view_btn);
        main_async_btn=(Button)findViewById(R.id.main_async_btn);
        main_fragment_btn=(Button)findViewById(R.id.main_fragment_btn);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        main_rxjava_btn.setOnClickListener(this);
        main_http_btn.setOnClickListener(this);
        main_gson_btn.setOnClickListener(this);
        main_okhttp_btn.setOnClickListener(this);
        main_create_file_btn.setOnClickListener(this);
        main_recycler_view_btn.setOnClickListener(this);
        main_handler_view_btn.setOnClickListener(this);
        main_async_btn.setOnClickListener(this);
        main_fragment_btn.setOnClickListener(this);
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
                Intent httpIntent = new Intent(this,HttpActivity.class);
                startActivity(httpIntent);

                break;
            case R.id.main_gson_btn:
                Intent gsonIntent= new Intent(this,GsonActivity.class);
                startActivity(gsonIntent);

                break;
            case R.id.main_okhttp_btn:
                Intent okhttpIntent= new Intent(this,OkHttpActivity.class);
                startActivity(okhttpIntent);
                break;
            case R.id.main_create_file_btn:
                Intent fileOperateIntent= new Intent(this,FileOperateActivity.class);
                startActivity(fileOperateIntent);

                break;
            case  R.id.main_recycler_view_btn:
                Intent recycleViewIntent= new Intent(this,RecycleViewActivity.class);
                startActivity(recycleViewIntent);

                break;
            case R.id.main_handler_view_btn:
                Intent handlerActivity = new Intent(this, HandlerActivity.class);
                startActivity(handlerActivity);
                break;
            case R.id.main_async_btn:
                Intent asyncActivity = new Intent(this, AsyncTaskActivity.class);
                startActivity(asyncActivity);
                break;
            case R.id.main_fragment_btn:
                Intent fragmentActivity = new Intent(this, FragmentMainActivity.class);
                startActivity(fragmentActivity);
                break;
            default:
                break;

        }
    }

}
