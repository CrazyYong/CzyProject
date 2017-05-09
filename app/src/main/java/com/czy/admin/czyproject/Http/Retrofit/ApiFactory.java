package com.czy.admin.czyproject.Http.Retrofit;

/**
 * Created by admin on 2017/5/7.
 */

public class ApiFactory {

    private final NewsAPI newsAPI;

    public ApiFactory() {
        this.newsAPI = RetrofitClient.INSTANCE.getRetrofit().create(NewsAPI.class);
    }

    public NewsAPI newsAPI(){
        return newsAPI;
    }
}
