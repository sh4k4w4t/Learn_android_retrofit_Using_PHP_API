package com.alivepython.mobilebankingappusingphpapi.test_JsonPlaceHolder_bs_posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Posts_Interface {

    @GET("posts")
    Call<List<Posts_model>> getAllPostModelList();
}
