package com.czy.admin.czyproject.jetPack.dataBinding;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.databinding.ActivityDataShowBinding;

/**
 * @author Create by cpSir on 2019/3/8
 */
public class DataBindingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataShowBinding activityDataShowBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_show);
        activityDataShowBinding.setPresenter(new Presenter());
        User user =new User("陈","志永");
        activityDataShowBinding.setUser(user);
        activityDataShowBinding.setStudent(new ObservableIser());

        ObservableIser iser = new ObservableIser();
        activityDataShowBinding.setStudent(iser);

        ObservableField<String> field = new ObservableField<>();
        activityDataShowBinding.setField(field);

    }

    public void onClick(View view){

    }
}
