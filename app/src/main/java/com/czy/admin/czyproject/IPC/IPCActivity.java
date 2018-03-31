package com.czy.admin.czyproject.IPC;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.czy.admin.czyproject.IPC.Messager.MessengerActivity;
import com.czy.admin.czyproject.IPC.Socket.TCPClientActivity;
import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.Utils.UtilsTool;

/**
 * Created by cmx on 2018/3/30.
 */

public class IPCActivity extends Activity{
    private Button btn_messenger,btn_socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc);
        btn_messenger=(Button)findViewById(R.id.btn_messenger);
        btn_socket=(Button)findViewById(R.id.btn_socket);

        btn_messenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilsTool.goActivity(IPCActivity.this, MessengerActivity.class);
            }
        });

        btn_socket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilsTool.goActivity(IPCActivity.this, TCPClientActivity.class);
            }
        });
    }
}
