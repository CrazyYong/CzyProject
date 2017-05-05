package com.czy.admin.czyproject;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by czy on 2017/5/5.
 */

public abstract class BaseActivity extends Activity{

    public abstract int getLayoutId();

    public abstract void initData();

    public abstract void initView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initData();
        initView();
    }
}
