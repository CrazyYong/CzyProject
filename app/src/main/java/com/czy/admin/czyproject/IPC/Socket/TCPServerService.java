package com.czy.admin.czyproject.IPC.Socket;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Created by cmx on 2018/3/30.
 */

public class TCPServerService extends Service{

    private boolean mIsServiceDestoeyed = false;
    private String[] mDefinedMessages = {"你好呀", "你叫神马？", "今天的天气", "汽车站怎么走？"};

    @Override
    public void onCreate() {
        new Thread(new TcpServer()).start();
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        mIsServiceDestoeyed = true;
        super.onDestroy();
    }

    private class TcpServer implements Runnable{

        @Override
        public void run() {
            ServerSocket serverSocket = null;
            try {
                //监听本地8868端口号
                serverSocket = new ServerSocket(8688);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            while (!mIsServiceDestoeyed){
                try {
                    //接收客户端的请求
                    final Socket client = serverSocket.accept();
                    new Thread(){
                        @Override
                        public void run() {
                            try {
                                responseClient(client);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void responseClient(Socket client) throws IOException{
        //用于接收客户端的信息
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        //用于给客户端发送消息
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())),true);
        out.print("欢迎来到聊天室");
        while (!mIsServiceDestoeyed){
            String str = in.readLine();
            if(str == null){
                break;
            }
            int i = new Random().nextInt(mDefinedMessages.length);
            String msg = mDefinedMessages[i];
            out.print(msg);
        }
        in.close();
        out.close();
        client.close();
    }
}
