package com.czy.admin.czyproject.View.Fragment;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by czy on 2017/6/5.
 */

public abstract class BaseFragment extends Fragment {

    protected View mView;
    protected Context mContext;

    @Override
    public void onAttach(Activity activity) {
        mContext = getActivity();
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(getLayoutResId(), container, false);
            initView(mView);
            getIntentData();
            initTitle(mView);
            initData();
        }
        ViewGroup parent = (ViewGroup) mView.getParent();
        if (parent != null) {
            parent.removeView(mView);
        }
        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();
        UpdataView();
    }

    /**
     * 获取layout id
     *
     * @return
     */
    protected abstract int getLayoutResId();

    /**
     * 获取Intent中传递的数据
     */
    protected abstract void getIntentData();

    /**
     * 初始化各类view对象
     */
    protected abstract void initView(View view);

    /**
     * 初始化Title layout及title对象
     */
    protected abstract void initTitle(View view);

    /**
     * 初始化其他数据Data,该方法将在 onCreateView()的时候调用
     */
    protected abstract void initData();

    protected void UpdataView() {

    }

    protected void gotoActivity(Class cls, Bundle bundle) {
        Intent intent = new Intent(mContext, cls);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void gotoActivity(Class cls) {
        gotoActivity(cls, null);
    }

}
