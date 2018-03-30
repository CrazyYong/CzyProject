package com.czy.admin.czyproject.FourComponents.Activity;

import android.app.Activity;
import android.os.Bundle;

import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.Utils.UtilsTool;

/**
 * Created by cmx on 2018/3/23.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        UtilsTool.Log("SecondActivity---onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        UtilsTool.Log("SecondActivity---onRestart");
    }
    @Override
    protected void onStart() {
        super.onStart();
        UtilsTool.Log("SecondActivity---onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        UtilsTool.Log("SecondActivity---onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        UtilsTool.Log("SecondActivity---onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        UtilsTool.Log("SecondActivity---onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UtilsTool.Log("SecondActivity---onDestroy");
    }
}
