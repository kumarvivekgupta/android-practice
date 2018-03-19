package com.example.vivek.githubrepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Vivek on 2/3/2018.
 */

public interface GithubClient {
    @GET("users/{user}/repos")
    Call<List<GithubRepo>> reposForUser(@Path("user") String user);


}
