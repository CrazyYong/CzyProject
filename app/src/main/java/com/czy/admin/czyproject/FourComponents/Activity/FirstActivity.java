package com.czy.admin.czyproject.FourComponents.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.Utils.UtilsTool;

/**
 * Created by cmx on 2018/3/21.
 */

public class FirstActivity extends Activity{

    private Button btn_to_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        UtilsTool.Log("FirstActivity---onCreate");
        btn_to_second=(Button)findViewById(R.id.btn_to_second);
        btn_to_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilsTool.goActivity(FirstActivity.this,SecondActivity.class);
            }
        });

        if (savedInstanceState != null) {
            String test = savedInstanceState.getString("extra_test");
            UtilsTool.Log(test);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        UtilsTool.Log("onSaveInstanceState");
        outState.putString("extra_test", "test");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String test = savedInstanceState.getString("extra_test");
        UtilsTool.Log(test+"");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        UtilsTool.Log("FirstActivity---onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        UtilsTool.Log("FirstActivity---onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        UtilsTool.Log("FirstActivity---onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        UtilsTool.Log("FirstActivity---onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        UtilsTool.Log("FirstActivity---onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UtilsTool.Log("FirstActivity---onDestroy");
    }
}
