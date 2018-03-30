package com.czy.admin.czyproject.FourComponents;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.czy.admin.czyproject.FourComponents.Activity.FirstActivity;
import com.czy.admin.czyproject.FourComponents.Service.ServiceActivity;
import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.Utils.UtilsTool;

/**
 * Created by cmx on 2018/3/23.
 */

public class FourComponents extends Activity {
    private Button btn_to_activity,btn_to_service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_components);
        btn_to_activity=(Button)findViewById(R.id.btn_to_activity);
        btn_to_service=(Button)findViewById(R.id.btn_to_service);

        btn_to_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilsTool.goActivity(FourComponents.this, FirstActivity.class);
            }
        });

        btn_to_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilsTool.goActivity(FourComponents.this, ServiceActivity.class);
            }
        });
    }
}
