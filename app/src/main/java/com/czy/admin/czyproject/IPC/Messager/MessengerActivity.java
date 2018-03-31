package com.czy.admin.czyproject.IPC.Messager;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.Utils.UtilsTool;

/**
 * Created by cmx on 2018/3/29.
 */

public class MessengerActivity extends Activity {

    private Messenger mService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        Intent intent = new Intent(this,MessageService.class);
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
    }



    private Messenger mGetReplyMessenger = new Messenger(new MessengerHandler());

    private static class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 200:
                    UtilsTool.Log("Service:" + msg.getData().getString("reply"));
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = new Messenger(service);
            Message msg = Message.obtain(null,100);
            Bundle data = new Bundle();
            data.putString("msg","hell this is client");

            msg.replyTo=mGetReplyMessenger;//注意这句话
            msg.setData(data);

            try {
                mService.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mConnection);
    }
}
