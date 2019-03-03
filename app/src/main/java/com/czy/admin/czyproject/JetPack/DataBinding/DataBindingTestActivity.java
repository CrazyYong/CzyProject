package com.czy.admin.czyproject.JetPack.DataBinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.databinding.ActivityDatabindingBinding;

/**
 * Created by cpsir on 2019/3/4
 */
public class DataBindingTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDatabindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        binding.setStu(new Student("loader","广东深圳"));
    }
}
