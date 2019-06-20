package com.czy.admin.czyproject.View.RecycleView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.czy.admin.czyproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by czy on 2017/4/26.
 */

public class RecycleViewActivity extends Activity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter());
    }


    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }


    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {


        /**
         * 这个方法主要生成为每个Item inflater出一个View，但是该方法返回的是一个ViewHolder。
         * 该方法把View直接封装在ViewHolder中，然后我们面向的是ViewHolder这个实例，当然这个ViewHolder需要我们自己去编写。
         *
         * @param parent
         * @param viewType
         * @return
         */
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    RecycleViewActivity.this).inflate(R.layout.item_home, parent,
                    false));
            return holder;
        }

        /**
         * 这个方法主要用于适配渲染数据到View中。方法提供给你了一viewHolder而不是原来的convertView。
         * @param holder
         * @param position
         */
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(mDatas.get(position));
        }

        /**
         * 这个方法就类似于BaseAdapter的getCount方法了，即总共有多少个条目。
         * @return
         */
        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
            }
        }

        public void addData(int position) {
            mDatas.add(position, "Insert One");
            notifyItemInserted(position);
        }

        public void removeData(int position) {
            mDatas.remove(position);
            notifyItemRemoved(position);
        }
    }

}
