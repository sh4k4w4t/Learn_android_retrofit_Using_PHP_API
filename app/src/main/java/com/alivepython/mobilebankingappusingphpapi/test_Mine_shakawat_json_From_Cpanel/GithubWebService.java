package com.alivepython.mobilebankingappusingphpapi.test_Mine_shakawat_json_From_Cpanel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubWebService {

    @GET("testapi/shakawat.json")
    Call<List<GithubModel>> listOfGithub();
}
