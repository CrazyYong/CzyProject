package com.czy.admin.czyproject.Http.Retrofit;

import com.czy.admin.czyproject.Gson.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by czy on 2017/4/19.
 */

public interface IUserBiz {

    @GET("users")
    Call<List<User>> getUsers();
}
