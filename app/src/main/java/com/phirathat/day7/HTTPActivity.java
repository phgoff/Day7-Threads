package com.phirathat.day7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.phirathat.day7.Model.GitHubUser;
import com.phirathat.day7.Service.GitHubService;
import com.phirathat.day7.Utils.HttpManager;

import org.w3c.dom.Text;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HTTPActivity extends AppCompatActivity {

    private EditText edtname;
    private TextView tvhttp;
    private Button btnsubmit;
    private Retrofit retrofit;
    private HttpManager httpManager;
    private GitHubService service;
    private GitHubUser gitHubUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);


        initializeInstance();
        httpManager = HttpManager.getInstance();
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitLoadGitHubUser(httpManager.getService(), edtname.getText().toString().trim() );

            }
        });
    }
    private void initializeInstance() {
        edtname = findViewById(R.id.edtname);
        tvhttp = findViewById(R.id.tvhttp);
        btnsubmit = findViewById(R.id.btnsubmit);
    }

    private void retrofitLoadGitHubUser(GitHubService service, String user) {
        Call<GitHubUser> call = service.loadUser(user);

        call.enqueue(new Callback<GitHubUser>() {
            @Override
            public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {
                if ( response.isSuccessful() ) {
                    gitHubUser = response.body();
                    Toast.makeText(getApplicationContext(), gitHubUser.toString() , Toast.LENGTH_SHORT).show();
                    tvhttp.setText(gitHubUser.toString());
                }
                else {
                    try {
                        Toast.makeText(getApplicationContext(), response.errorBody().string() , Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<GitHubUser> call, Throwable t) {
                Toast.makeText( getApplicationContext() , t.toString() , Toast.LENGTH_LONG).show();
                System.out.println(t.toString());
            }

        });
    }

}
