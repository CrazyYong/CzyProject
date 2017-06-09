package com.czy.admin.czyproject.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.ThreadWork.AsyncTaskActivity;
import com.czy.admin.czyproject.ThreadWork.HandlerActivity;
import com.czy.admin.czyproject.Utils.UtilsTool;

/**
 * Created by czy on 2017/6/9.
 */

public class ThreadWorkActivity extends Activity{
    private Button btn_handler,btn_async;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_work);
        btn_handler=(Button)findViewById(R.id.btn_handler);
        btn_async=(Button)findViewById(R.id.btn_async);
        btn_handler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilsTool.goActivity(ThreadWorkActivity.this,HandlerActivity.class);
            }
        });

        btn_async.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilsTool.goActivity(ThreadWorkActivity.this,AsyncTaskActivity.class);
            }
        });
    }
}
