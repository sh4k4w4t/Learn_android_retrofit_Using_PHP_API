package com.alivepython.mobilebankingappusingphpapi.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {

    @GET("test.php")
    Call<ResponseBody> loginNow(@Query("number") String number,
                                @Query("pin") String pin);


}
