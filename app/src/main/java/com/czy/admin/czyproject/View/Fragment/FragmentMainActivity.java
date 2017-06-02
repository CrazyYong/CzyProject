package com.czy.admin.czyproject.View.Fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.czy.admin.czyproject.R;

/**
 * Created by czy on 2017/6/2.
 */

public class FragmentMainActivity extends Activity implements View.OnClickListener {
    private TextView mTabWeixin;
    private TextView mTabFriend;

    private ContentFragment mWeixin;
    private FriendFragment mFriend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        // 初始化控件和声明事件
        mTabWeixin = (TextView) findViewById(R.id.tab_bottom_weixin);
        mTabFriend = (TextView) findViewById(R.id.tab_bottom_friend);
        mTabWeixin.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);

        // 设置默认的Fragment
        setDefaultFragment();
    }

    private void setDefaultFragment()
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mWeixin = new ContentFragment();
        transaction.replace(R.id.id_content, mWeixin);
        transaction.commit();
    }


    @Override
    public void onClick(View view) {
        FragmentManager fm = getFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (view.getId()){
            case R.id.tab_bottom_weixin:
                if (mWeixin == null)
                {
                    mWeixin = new ContentFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.id_content, mWeixin);
                break;
            case R.id.tab_bottom_friend:
                if (mFriend == null)
                {
                    mFriend = new FriendFragment();
                }
                transaction.replace(R.id.id_content, mFriend);
                break;
        }
        // 事务提交
        transaction.commit();
    }
}
