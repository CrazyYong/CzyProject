package com.czy.admin.czyproject.Activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.Utils.UtilsTool;
import com.czy.admin.czyproject.View.Dialog.ActivityDialog;
import com.czy.admin.czyproject.View.DrawerLayout.DrawerLayoutActivity;
import com.czy.admin.czyproject.View.Fragment.FragmentDialog.FragmentDialogActivity;
import com.czy.admin.czyproject.View.Fragment.FragmentMainActivity;
import com.czy.admin.czyproject.View.MaterialDesign.MaterialDesignActivity;
import com.czy.admin.czyproject.View.NavigationView.NavigationViewActivity;
import com.czy.admin.czyproject.View.RecycleView.RecycleViewActivity;
import com.czy.admin.czyproject.View.customView.MyFirstCustomerViewActivity;
import com.czy.admin.czyproject.View.customView.dispatch.DispatchActivity;
import com.czy.admin.czyproject.View.customView.path.PathViewActivity;
import com.czy.admin.czyproject.View.customView.pie.PieViewActivity;
import com.czy.admin.czyproject.databinding.ActivityViewBinding;

/**
 * Created by czy on 2017/6/8.
 * View页面，用于各种控件页面跳转
 */

public class ViewActivity extends Activity implements View.OnClickListener {


    private ActivityDialog activityDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityViewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_view);
        binding.btnViewRecycle.setOnClickListener(this);
        binding.btnFragment.setOnClickListener(this);
        binding.btnDialogFragment.setOnClickListener(this);
        binding.btnDrawerlayout.setOnClickListener(this);
        binding.btnNavigation.setOnClickListener(this);
        binding.btnMaterial.setOnClickListener(this);
        binding.btnCustomer.setOnClickListener(this);
        binding.btnDialog.setOnClickListener(this);
        binding.btnPiew.setOnClickListener(this);
        binding.btnPath.setOnClickListener(this);
        binding.btnDispatch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_view_recycle:
                UtilsTool.goActivity(this, RecycleViewActivity.class);
                break;
            case R.id.btn_fragment:
                UtilsTool.goActivity(this, FragmentMainActivity.class);
                break;
            case R.id.btn_dialog_fragment:
                UtilsTool.goActivity(this, FragmentDialogActivity.class);
                break;
            case R.id.btn_drawerlayout:
                UtilsTool.goActivity(this, DrawerLayoutActivity.class);
                break;
            case R.id.btn_navigation:
                UtilsTool.goActivity(this, NavigationViewActivity.class);
                break;
            case R.id.btn_material:
                UtilsTool.goActivity(this, MaterialDesignActivity.class);
                break;
            case R.id.btn_customer:
                UtilsTool.goActivity(this, MyFirstCustomerViewActivity.class);
                break;
            case R.id.btn_dialog:
                View dialogView = getLayoutInflater().inflate(R.layout.activity_dialog, null);
                activityDialog = new ActivityDialog(this, 0, 0, dialogView, R.style.DialogTheme);
                activityDialog.setCancelable(true);
                activityDialog.show();
                break;
            case R.id.btn_piew:
                UtilsTool.goActivity(this, PieViewActivity.class);
                break;
            case R.id.btn_path:
                UtilsTool.goActivity(this, PathViewActivity.class);
                break;
            case R.id.btn_dispatch:
                UtilsTool.goActivity(this, DispatchActivity.class);
                break;
            default:
                break;
        }
    }
}
