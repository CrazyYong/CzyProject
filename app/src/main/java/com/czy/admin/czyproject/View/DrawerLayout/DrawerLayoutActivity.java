package com.czy.admin.czyproject.View.DrawerLayout;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.czy.admin.czyproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by czy on 2017/6/7.
 */

public class DrawerLayoutActivity extends Activity {
    private DrawerLayout drawerLayout;
    private RelativeLayout rightLayout;
    private List<ContentModel> list;
    private ContentAdapter adapter;
    private ImageView leftMenu, rightMenu;
    private ListView listView;
    private FragmentManager fm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
//        getActionBar().hide();
        leftMenu = (ImageView) findViewById(R.id.leftmenu);
        rightMenu = (ImageView) findViewById(R.id.rightmenu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        rightLayout = (RelativeLayout) findViewById(R.id.right);
        listView = (ListView) findViewById(R.id.left_listview);
        fm = getFragmentManager();

        initData();
        adapter = new ContentAdapter(this, list);
        listView.setAdapter(adapter);
        leftMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                FragmentTransaction bt = fm.beginTransaction();
                switch ((int) id) {
                    case 1:
                        bt.replace(R.id.content, new NewsFragment());
                        break;
                    case 2:
                        bt.replace(R.id.content, new SubscriptionFragment());
                        break;

                    default:
                        break;
                }
                bt.commit();
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
        rightMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });
        rightLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(Gravity.RIGHT);
            }
        });

    }

    private void initData() {
        list = new ArrayList<ContentModel>();

        list.add(new ContentModel(R.drawable.doctoradvice2, "新闻", 1));
        list.add(new ContentModel(R.drawable.infusion_selected, "订阅", 2));
        list.add(new ContentModel(R.drawable.mypatient_selected, "图片", 3));
        list.add(new ContentModel(R.drawable.mywork_selected, "视频", 4));
        list.add(new ContentModel(R.drawable.nursingcareplan2, "跟帖", 5));
        list.add(new ContentModel(R.drawable.personal_selected, "投票", 6));
    }
}
