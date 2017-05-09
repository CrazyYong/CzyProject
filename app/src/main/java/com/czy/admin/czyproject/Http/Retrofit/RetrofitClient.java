package com.czy.admin.czyproject.Http.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2017/5/7.
 */

public enum  RetrofitClient {
    INSTANCE;

    private final Retrofit retrofit;
    private static final String baseUrl = "http://japi.juhe.cn/joke/content/";

    RetrofitClient() {
        retrofit = new Retrofit.Builder()
                //baseUrl
                .baseUrl(baseUrl)
                //gson转化器
                .addConverterFactory(GsonConverterFactory.create())

                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
