package com.czy.admin.czyproject.FourComponents.Service;


import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.czy.admin.czyproject.Activity.BaseActivity;
import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.Utils.UtilsTool;

/**
 * Created by czy on 2018/3/19.
 */

public class ServiceActivity extends BaseActivity implements View.OnClickListener{
    private Button service_start_btn,service_stop_btn,service_bind_btn,service_unbind_btn;
    private MyService.MyBinder myBinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        UtilsTool.Log("MainActivity thread id is " + Thread.currentThread().getId());
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_service;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        service_start_btn=(Button)findViewById(R.id.service_start_btn);
        service_stop_btn=(Button)findViewById(R.id.service_stop_btn);
        service_bind_btn=(Button)findViewById(R.id.service_bind_btn);
        service_unbind_btn=(Button)findViewById(R.id.service_unbind_btn);

        service_start_btn.setOnClickListener(this);
        service_stop_btn.setOnClickListener(this);
        service_bind_btn.setOnClickListener(this);
        service_unbind_btn.setOnClickListener(this);
    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder=(MyService.MyBinder)service;
            myBinder.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.service_start_btn:
                Intent startIntent = new Intent(this,MyService.class);
                startService(startIntent);
                break;

            case R.id.service_stop_btn:
                Intent stopIntent = new Intent(this,MyService.class);
                stopService(stopIntent);
                break;

            case R.id.service_bind_btn:
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE);
                break;

            case R.id.service_unbind_btn:
                try{
                    unbindService(connection);
                }catch (IllegalArgumentException e){

                }

                break;
        }
    }
}
