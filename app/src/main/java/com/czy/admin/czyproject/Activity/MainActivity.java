package com.czy.admin.czyproject.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.czy.admin.czyproject.ContentProvider.ContentProviderActivity;
import com.czy.admin.czyproject.FileOperate.FileOperateActivity;
import com.czy.admin.czyproject.Gson.GsonActivity;
import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.RxJava.RxJavaActivity;
import com.czy.admin.czyproject.Utils.UtilsTool;
public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button main_rxjava_btn,main_gson_btn,main_create_file_btn
           ,main_content_btn
            ,main_view_btn,main_newwork_btn,main_thread_btn;
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
        main_gson_btn=(Button)findViewById(R.id.main_gson_btn);
        main_create_file_btn=(Button)findViewById(R.id.main_create_file_btn);
        main_content_btn=(Button)findViewById(R.id.main_content_btn);
        main_view_btn=(Button)findViewById(R.id.main_view_btn);
        main_newwork_btn=(Button)findViewById(R.id.main_newwork_btn);
        main_thread_btn=(Button)findViewById(R.id.main_thread_btn);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main_rxjava_btn.setOnClickListener(this);
        main_gson_btn.setOnClickListener(this);
        main_create_file_btn.setOnClickListener(this);
        main_content_btn.setOnClickListener(this);
        main_view_btn.setOnClickListener(this);
        main_newwork_btn.setOnClickListener(this);
        main_thread_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_rxjava_btn:
                UtilsTool.goActivity(this,RxJavaActivity.class);
                break;
            case R.id.main_gson_btn:
                UtilsTool.goActivity(this,GsonActivity.class);
                break;
            case R.id.main_create_file_btn:
                UtilsTool.goActivity(this,FileOperateActivity.class);
                break;
            case R.id.main_content_btn:
                UtilsTool.goActivity(this,ContentProviderActivity.class);
                break;
            case R.id.main_view_btn:
                UtilsTool.goActivity(this,ViewActivity.class);
                break;
            case R.id.main_newwork_btn:
                UtilsTool.goActivity(this,NetWorkActivity.class);
                break;
            case R.id.main_thread_btn:
                UtilsTool.goActivity(this,ThreadWorkActivity.class);
                break;
            default:
                break;

        }
    }

}