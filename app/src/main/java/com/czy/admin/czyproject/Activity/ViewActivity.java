package com.czy.admin.czyproject.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.Utils.UtilsTool;
import com.czy.admin.czyproject.View.DrawerLayout.DrawerLayoutActivity;
import com.czy.admin.czyproject.View.Fragment.FragmentDialog.FragmentDialogActivity;
import com.czy.admin.czyproject.View.Fragment.FragmentMainActivity;
import com.czy.admin.czyproject.View.MaterialDesign.MaterialDesignActivity;
import com.czy.admin.czyproject.View.NavigationView.NavigationViewActivity;
import com.czy.admin.czyproject.View.RecycleView.RecycleViewActivity;

/**
 * Created by czy on 2017/6/8.
 * View页面，用于各种控件页面跳转
 */

public class ViewActivity extends Activity implements  View.OnClickListener{
    private Button btn_view_recycle,btn_fragment,btn_dialog_fragment,btn_drawerlayout
            ,btn_navigation,btn_material;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        btn_view_recycle=(Button)findViewById(R.id.btn_view_recycle);
        btn_fragment=(Button)findViewById(R.id.btn_fragment);
        btn_dialog_fragment=(Button)findViewById(R.id.btn_dialog_fragment);
        btn_drawerlayout=(Button)findViewById(R.id.btn_drawerlayout);
        btn_navigation=(Button)findViewById(R.id.btn_navigation);
        btn_material=(Button)findViewById(R.id.btn_material);

        btn_view_recycle.setOnClickListener(this);
        btn_fragment.setOnClickListener(this);
        btn_dialog_fragment.setOnClickListener(this);
        btn_drawerlayout.setOnClickListener(this);
        btn_navigation.setOnClickListener(this);
        btn_material.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_view_recycle:
                UtilsTool.goActivity(this,RecycleViewActivity.class);
                break;
            case R.id.btn_fragment:
                UtilsTool.goActivity(this,FragmentMainActivity.class);
                break;
            case R.id.btn_dialog_fragment:
                UtilsTool.goActivity(this,FragmentDialogActivity.class);
                break;
            case R.id.btn_drawerlayout:
                UtilsTool.goActivity(this,DrawerLayoutActivity.class);
                break;
            case R.id.btn_navigation:
                UtilsTool.goActivity(this,NavigationViewActivity.class);
                break;
            case R.id.btn_material:
                UtilsTool.goActivity(this,MaterialDesignActivity.class);
                break;
            default:
                break;
        }
    }
}
