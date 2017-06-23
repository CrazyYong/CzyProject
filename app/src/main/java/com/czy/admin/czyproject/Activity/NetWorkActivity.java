package com.czy.admin.czyproject.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.czy.admin.czyproject.NetWork.HttpConnection.HttpActivity;
import com.czy.admin.czyproject.NetWork.OkHttp.OkHttpActivity;
import com.czy.admin.czyproject.NetWork.Retrofit.Info;
import com.czy.admin.czyproject.NetWork.Retrofit.RetrofitUtils;
import com.czy.admin.czyproject.R;
import com.czy.admin.czyproject.Utils.UtilsTool;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by czy on 2017/6/8.
 */

public class NetWorkActivity extends Activity implements View.OnClickListener{
private Button btn_retroift,btn_okhttp,btn_http;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        btn_retroift=(Button)findViewById(R.id.btn_retroift);
        btn_okhttp=(Button)findViewById(R.id.btn_okhttp);
        btn_http=(Button)findViewById(R.id.btn_http);
        btn_retroift.setOnClickListener(this);
        btn_okhttp.setOnClickListener(this);
        btn_http.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_retroift:
                requestByGet();
            break;
            case R.id.btn_okhttp:
                UtilsTool.goActivity(this,OkHttpActivity.class);
                break;
            case R.id.btn_http:
                UtilsTool.goActivity(this,HttpActivity.class);
                break;
            default:
                break;
        }
    }



    /**
     * Retrofit  get请求
     */
    private void requestByGet(){
        Call<Info> call = RetrofitUtils.getInstance().get("list.from","488c65f3230c0280757b50686d1f1cd5","asc","1418816972");
        call.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                Toast.makeText(NetWorkActivity.this,  response.body().getResult().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {
                Toast.makeText(NetWorkActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
