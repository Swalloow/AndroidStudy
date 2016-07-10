package com.swalloow.myretrofit.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.swalloow.myretrofit.Adapter.RecyclerAdapter;
import com.swalloow.myretrofit.R;
import com.swalloow.myretrofit.models.JSONResponse;
import com.swalloow.myretrofit.models.Repo;
import com.swalloow.myretrofit.networks.GitHubService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Repo> repos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        repos = new ArrayList<>();

        GitHubService.api().listRepos("Swalloow").enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                if(response != null && response.isSuccessful() && response.body() != null) {
                    JSONResponse jsonResponse = response.body();
                    Toast.makeText(MainActivity.this, jsonResponse.toString() + " repo calling", Toast.LENGTH_LONG).show();
                    repos = jsonResponse.getRepos();
                    recyclerView.setAdapter(new RecyclerAdapter(getApplicationContext(), repos, R.layout.activity_main));
                }
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}