package com.czy.admin.czyproject.View.CustomView;

import android.app.Activity;
import android.os.Bundle;

import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.Utils.UtilsTool;

/**
 * Created by cmx on 2018/3/6.
 */

public class MyFirstCustomerViewActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_view);
        UtilsTool.Log(""+this.getClass());
    }
}
