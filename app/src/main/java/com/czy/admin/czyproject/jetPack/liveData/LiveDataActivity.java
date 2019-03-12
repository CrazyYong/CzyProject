package com.czy.admin.czyproject.jetPack.liveData;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.czy.admin.czyproject.Activity.BaseActivity;
import com.czy.admin.czyproject.R;

public class LiveDataActivity extends BaseActivity implements View.OnClickListener{
    private NameViewModel model;
    private TextView tv_jetpack;
    private Button btn_click;
    private Button btn_click2;


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_click:
                String anotherName = "John Doe";
                model.getCurrentName().setValue(anotherName);//3:LiveData发送数据，触发监听者发生改变
                break;
            case R.id.btn_click2:
                String anotherName2 = "hhhhh";
                model.getCurrentName().setValue(anotherName2);//3:LiveData发送数据，触发监听者发生改变
                break;
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_livedata;
    }

    @Override
    public void initData() {
        //1:获取ViewModel
        model = ViewModelProviders.of(this).get(NameViewModel.class);

        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //当LiveData发送数据的时候,在此处触发改变
                tv_jetpack.setText(s);
            }
        };
        //2:LiveData监听数据的改变
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
