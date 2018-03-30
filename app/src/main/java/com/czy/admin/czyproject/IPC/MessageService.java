package com.czy.admin.czyproject.IPC;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.czy.admin.czyproject.Utils.UtilsTool;

/**
 * Created by cmx on 2018/3/29.
 */

public class MessageService extends Service{


    private static class MessengerHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    UtilsTool.Log("数据:" +msg.getData().get("msg"));

                    Messenger messenger = msg.replyTo;
                    Message reply = Message.obtain(null,200);
                    Bundle data = new Bundle();
                    data.putString("reply","收到消息了，等下回复");
                    reply.setData(data);

                    try {
                        messenger.send(reply);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:

                    super.handleMessage(msg);
            }
        }
    }

    private final Messenger messenger = new Messenger(new MessengerHandler());


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }
}
