package com.phirathat.day7.Service;

/**
 * Created by 5835512090 on 4/27/2018.
 */

import com.phirathat.day7.Model.GitHubUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    @GET("users/{user}")        // MUST end URL WITHOUT '/'
    Call<GitHubUser> loadUser(@Path("user") String user);
}

