package com.czy.admin.czyproject.View.customView.pie;

import android.app.Activity;
import android.os.Bundle;

import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.View.customView.pie.PieData;
import com.czy.admin.czyproject.View.customView.pie.PieView;

import java.util.ArrayList;

/**
 * @author Create by cpSir on 2019/6/10
 */
public class PieViewActivity extends Activity {
    private PieView custom_pieview;
    private CheckView mCheckView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pieview);
        custom_pieview=(PieView)findViewById(R.id.custom_pieview);
        mCheckView=(CheckView)findViewById(R.id.custom_checkview);
        mCheckView.check();



        ArrayList<PieData> datas = new ArrayList<>();
        PieData pieData = new PieData("sloop", 60);
        PieData pieData2 = new PieData("sloop", 30);
        PieData pieData3 = new PieData("sloop", 40);
        PieData pieData4 = new PieData("sloop", 20);
        PieData pieData5 = new PieData("sloop", 20);
        datas.add(pieData);
        datas.add(pieData2);
        datas.add(pieData3);
        datas.add(pieData4);
        datas.add(pieData5);
        custom_pieview.setData(datas);

    }
}
