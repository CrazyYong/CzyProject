package com.czy.admin.czyproject.Proprety;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.Pools;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.czy.admin.czyproject.Activity.NetWorkActivity;
import com.czy.admin.czyproject.R;
/**
 * Created by cmx on 2018/3/2.
 */

public class PropretyActivity extends Activity implements View.OnClickListener{
    private Button btn_pools_get;
    private Button btn_pools_put;
    private static final Pools.SynchronizedPool<PropretyActivity> sPool = new Pools.SynchronizedPool<PropretyActivity>(10);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proprety);
        btn_pools_get=(Button)findViewById(R.id.btn_pools_get);
        btn_pools_get.setOnClickListener(this);

        btn_pools_put=(Button)findViewById(R.id.btn_pools_put);
        btn_pools_put.setOnClickListener(this);
    }

    /**
     * 取出对象
     * @return
     */
    public static PropretyActivity obtain() {
        PropretyActivity instance = sPool.acquire();
        return (instance != null) ? instance : new PropretyActivity();
    }

    /**
     * 放入对象
     */
    public void recycle() {
        sPool.release(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_pools_get:
                Toast.makeText(PropretyActivity.this,obtain().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_pools_put:
                recycle();
                Toast.makeText(PropretyActivity.this,"放入对象池中", Toast.LENGTH_SHORT).show();
                break;
                default:
                    break;
        }
    }
}
