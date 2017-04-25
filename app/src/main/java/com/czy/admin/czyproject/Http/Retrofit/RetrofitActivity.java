package com.czy.admin.czyproject.Http.Retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import com.czy.admin.czyproject.Gson.User;
import com.czy.admin.czyproject.Http.HttpUtil;
import com.czy.admin.czyproject.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by czy on 2017/4/19.
 */

public class RetrofitActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_retrofit);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpUtil.REMOTE_CONFIG_URL_GAMEPAD1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IUserBiz userBiz = retrofit.create(IUserBiz.class);
        Call<List<User>> call = userBiz.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.i("CZYAPP","返回的结果:"+response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.i("CZYAPP","报错结果:"+t);
            }
        });
    }
}
