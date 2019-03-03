package com.czy.admin.czyproject.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by czy on 2017/5/5.
 */

public abstract class BaseActivity extends AppCompatActivity {

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
