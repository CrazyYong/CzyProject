package com.czy.admin.czyproject.JetPack;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.czy.admin.czyproject.Activity.BaseActivity;
import com.czy.admin.czyproject.R;

public class JetPackTestActivity extends BaseActivity implements View.OnClickListener{
    private NameViewModel model;
    private TextView tv_jetpack;
    private Button btn_click;
    private Button btn_click2;


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_click:
                String anotherName = "John Doe";
                model.getCurrentName().setValue(anotherName);
                break;
            case R.id.btn_click2:
                String anotherName2 = "hhhhh";
                model.getCurrentName().setValue(anotherName2);
                break;
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_jetpack;
    }

    @Override
    public void initData() {
        model = ViewModelProviders.of(this).get(NameViewModel.class);
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tv_jetpack.setText(s);
            }
        };
        model.getCurrentName().observe(this, nameObserver);
    }


    @Override
    public void initView() {
        tv_jetpack=(TextView)findViewById(R.id.tv_jetpack);
        btn_click=(Button)findViewById(R.id.btn_click);
        btn_click2=(Button)findViewById(R.id.btn_click2);
        btn_click2.setOnClickListener(this);
        btn_click.setOnClickListener(this);
    }
}
