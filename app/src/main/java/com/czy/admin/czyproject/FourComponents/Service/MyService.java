package com.czy.admin.czyproject.FourComponents.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.czy.admin.czyproject.Utils.UtilsTool;

/**
 * Created by czy on 2018/3/19.
 */

public class MyService extends Service{

    private MyBinder myBinder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        UtilsTool.Log("onCreate");
        UtilsTool.Log("MainActivity thread id is " + Thread.currentThread().getId());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        UtilsTool.Log("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        UtilsTool.Log("onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }


    class MyBinder extends Binder{
        public void startDownload() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 执行具体的下载任务
                    UtilsTool.Log("startDownload() executed");
                }
            }).start();

        }
    }
}
