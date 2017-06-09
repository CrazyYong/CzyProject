package com.czy.admin.czyproject.View.NavigationView;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.czy.admin.czyproject.R;

/**
 * Created by czy on 2017/6/8.
 */

public class NavigationViewActivity extends Activity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Button btn_left;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_layout);
        btn_left=(Button)findViewById(R.id.btn_left);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);

        View headerView = navigationView.getHeaderView(0);//获取头部控件

        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                return true;
            }
        });

    }
}
