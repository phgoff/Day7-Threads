package com.phirathat.day7.Utils;

/**
 * Created by 5835512090 on 4/27/2018.
 */
import android.content.Context;
import com.phirathat.day7.Service.GitHubService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {
    private static HttpManager instance;

    public static HttpManager getInstance() {
        if ( instance == null )
            instance = new HttpManager();
        return instance;
    }

    private GitHubService service;

    private HttpManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")   // MUST end url with '/'
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(GitHubService.class);
    }

    public GitHubService getService() {
        return service;
    }
}
