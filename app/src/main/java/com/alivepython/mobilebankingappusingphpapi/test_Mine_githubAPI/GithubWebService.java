package com.alivepython.mobilebankingappusingphpapi.test_Mine_githubAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubWebService {

    @GET("testapi/shakawat.json")
    Call<List<GithubModel>> listOfGithub();
}
