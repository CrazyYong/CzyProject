package com.czy.admin.czyproject.jetPack;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.Utils.UtilsTool;
import com.czy.admin.czyproject.databinding.ActivityJetpackBinding;
import com.czy.admin.czyproject.jetPack.dataBinding.DataBindingActivity;
import com.czy.admin.czyproject.jetPack.liveData.LiveDataActivity;

/**
 * 测试中
 * @author Create by cpSir on 2019/3/11
 */
public class JetPackActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityJetpackBinding jetpackBinding = DataBindingUtil.setContentView(this, R.layout.activity_jetpack);
        jetpackBinding.setClick(this);

    }

    public void onClick(int type){
        switch (type){
            case 1:
                UtilsTool.goActivity(this, LiveDataActivity.class);
                break;
            case 2:
                UtilsTool.goActivity(this, DataBindingActivity.class);
                break;
        }

    }
}
