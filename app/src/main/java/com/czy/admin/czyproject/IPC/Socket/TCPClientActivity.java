package com.czy.admin.czyproject.IPC.Socket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.czy.admin.czyproject.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cmx on 2018/3/30.
 */

public class TCPClientActivity extends Activity{

    public static final int MESSAGE_RECEIVE_NEW_MSG = 1;
    public static final int MESSAGE_SOCKET_CONNECTED = 2;


    private Button btn_send;
    private TextView txt_tv;
    private EditText edit_txt;

    private PrintWriter mPrintWriter;
    private Socket mClientSocket;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_RECEIVE_NEW_MSG:
                    txt_tv.setText(txt_tv.getText() + (String) msg.obj);
                    break;
                case MESSAGE_SOCKET_CONNECTED:
                    btn_send.setEnabled(true);
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tcp);
        initView();
    }


    private void initView(){
        btn_send=(Button)findViewById(R.id.btn_send);
        txt_tv=(TextView)findViewById(R.id.txt_tv);
        edit_txt=(EditText)findViewById(R.id.edit_txt);


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = edit_txt.getText().toString();
                if (!TextUtils.isEmpty(msg)) {
                    mPrintWriter.println(msg);
                    edit_txt.setText("");
                    String time = formatDateTime(System.currentTimeMillis());
                    String showesMsg = "self" + time + ":" + msg + "\n";
                    txt_tv.setText(txt_tv.getText() + showesMsg);
                }
            }
        });

        Intent intent = new Intent(this, TCPServerService.class);
        startService(intent);

        new Thread() {
            @Override
            public void run() {
                connectTCPServer();
            }
        }.start();
    }

    private String formatDateTime(long l) {
        return new SimpleDateFormat("(HH:mm:ss)").format(new Date(l));
    }
    @Override
    protected void onDestroy() {
        if (mClientSocket != null) {
            try {
                mClientSocket.shutdownInput();
                mClientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onDestroy();
    }


    private void connectTCPServer() {
        Socket socket = null;
        while (socket == null) {
            try {
                socket = new Socket("localhost", 8688);
                mClientSocket = socket;
                mPrintWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                handler.sendEmptyMessage(MESSAGE_SOCKET_CONNECTED);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            //接收服务端的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (!TCPClientActivity.this.isFinishing()) {
                String msg = br.readLine();
                if (msg != null) {
                    String time = formatDateTime(System.currentTimeMillis());
                    String showMsg = "server " + time + "：" + msg + "\n";
                    handler.obtainMessage(MESSAGE_RECEIVE_NEW_MSG, showMsg).sendToTarget();
                }
            }

            mPrintWriter.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
