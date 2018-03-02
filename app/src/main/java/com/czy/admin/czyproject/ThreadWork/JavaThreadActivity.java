package com.czy.admin.czyproject.ThreadWork;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.Utils.UtilsTool;

/**
 * Created by cmx on 2018/3/2.
 */

public class JavaThreadActivity extends Activity implements View.OnClickListener{
    private Button btn_create1,btn_create2,btn_create3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_thread);
        btn_create1=(Button)findViewById(R.id.btn_create1);
        btn_create1.setOnClickListener(this);

        btn_create2=(Button)findViewById(R.id.btn_create2);
        btn_create2.setOnClickListener(this);

        btn_create3=(Button)findViewById(R.id.btn_create3);
        btn_create3.setOnClickListener(this);
    }


    /**
     * 创建方式一
     */
    private void create1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                UtilsTool.Log("创建方式一");
            }
        }).start();
    }


    private void create2(){
        RunnableDemo R1 = new RunnableDemo( "Thread-1");
        R1.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_create1:
                create1();
                break;
            case R.id.btn_create2:
                create2();
                break;
                default:
                    break;
        }
    }


    class RunnableDemo implements Runnable{
        private Thread t;
        private String threadName;

        RunnableDemo( String name) {
            threadName = name;
            UtilsTool.Log("Creating " +  threadName );
        }

        @Override
        public void run() {
            UtilsTool.Log("Running " +  threadName );
            try {
                for(int i = 4; i > 0; i--) {
                    UtilsTool.Log("Thread: " + threadName + ", " + i);
                    // 让线程睡眠一会
                    Thread.sleep(50);
                }
            }catch (InterruptedException e) {
                UtilsTool.Log("Thread " +  threadName + " interrupted.");
            }
            UtilsTool.Log("Thread " +  threadName + " exiting.");
        }

        public void start () {
            UtilsTool.Log("Starting " +  threadName );
            if (t == null) {
                t = new Thread (this, threadName);
                t.start ();
            }
        }
    }
}
