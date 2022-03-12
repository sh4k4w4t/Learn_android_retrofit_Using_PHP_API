package com.alivepython.mobilebankingappusingphpapi.test_Mine_HistoryPhp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Mine_Web_Service {
    @GET("history.php")
    Call<List<Mine_Model>> mine_GetHistoryList(@Query("number") String number,
                                              @Query("pin") String pin);
}
