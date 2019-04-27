package com.czy.admin.czyproject.View.CustomView;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.Utils.UtilsTool;
import com.czy.admin.czyproject.databinding.ActivitySelfViewBinding;

/**
 * Created by cmx on 2018/3/6.
 */

public class MyFirstCustomerViewActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySelfViewBinding databinding = DataBindingUtil.setContentView(this,R.layout.activity_self_view);
        UtilsTool.Log(""+this.getClass());

        /**
         * X轴：正值向左移动
         * Y轴:正值向上移动
         */
        databinding.btnScrollTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databinding.btnTest.scrollTo(10,20);
            }
        });

        databinding.btnScrollBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databinding.btnTest.scrollBy(-10,-20);
                UtilsTool.Log(databinding.btnTest.getScrollY()+"");

            }
        });
    }

}
