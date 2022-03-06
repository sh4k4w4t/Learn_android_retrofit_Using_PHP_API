package com.alivepython.mobilebankingappusingphpapi.interfaces;

import com.alivepython.mobilebankingappusingphpapi.model.UserModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WebService {

    @GET("test.php")
    Call<ResponseBody> loginNow(@Query("number") String number,
                                @Query("pin") String pin);

    @GET("jsontest.php")
    Call<UserModel> jsontest(@Query("number") String number,
                             @Query("pin") String pin);

    @FormUrlEncoded
    @POST("recharge.php")
    Call<ResponseBody> rechargeNow(@Field("number") String number,
                                   @Field("amount") String amount,
                                   @Field("userPhone") String userPhone,
                                   @Field("userPin") String userPin);

    @FormUrlEncoded
    @POST("cashout.php")
    Call<ResponseBody> cashOutNow(@Field("number") String number,
                                   @Field("amount") String amount,
                                   @Field("userPhone") String userPhone,
                                   @Field("userPin") String userPin);

    @GET("history.php")
    Call<ResponseBody> getHistoryList(@Query("number") String number,
                                      @Query("pin") String pin);


}
