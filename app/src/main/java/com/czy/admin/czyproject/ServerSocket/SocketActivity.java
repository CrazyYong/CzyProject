package com.czy.admin.czyproject.ServerSocket;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.czy.admin.czyproject.R;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by czy on 2017/5/27.
 * 和Paython后台进行通信
 */

public class SocketActivity extends Activity {
    private Button btn_connect;
    private TextView txt_tv;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    txt_tv.setText((String)msg.obj);
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        btn_connect=(Button)findViewById(R.id.btn_connect);
        txt_tv=(TextView) findViewById(R.id.txt_tv);
        btn_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNetThread("10.10.10.102",21567,"Hello Servier CZY");
            }
        });
    }

    /**
     * 连接服务器
     * @param host
     * @param port
     * @param data
     */
    private void startNetThread(final String host, final int port, final String data) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Socket socket = new Socket(host, port);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write((data).getBytes());
                    outputStream.flush();
                    System.out.println(socket);

                    InputStream is = socket.getInputStream();
                    byte[] bytes = new byte[1024];
                    int n = is.read(bytes);
                    System.out.println(new String(bytes, 0, n));

                    Message msg = handler.obtainMessage(1, new String(bytes, 0, n));
                    msg.sendToTarget();

                    is.close();
                    socket.close();
                } catch (Exception e) {
                }
            }
        };
        thread.start();
    }
}
