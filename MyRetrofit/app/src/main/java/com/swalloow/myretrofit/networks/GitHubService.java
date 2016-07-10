package com.swalloow.myretrofit.networks;

import com.swalloow.myretrofit.models.JSONResponse;
import com.swalloow.myretrofit.models.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Junyoung on 2016-07-09.
 */

public class GitHubService extends BaseService {

    public static GitHubApi api() {
        return (GitHubApi) retrofit(GitHubApi.class);
    }

    public interface GitHubApi {
        @GET("/users/{user}/repos")
        Call<JSONResponse> listRepos(@Path("user") String user );
    }
}
