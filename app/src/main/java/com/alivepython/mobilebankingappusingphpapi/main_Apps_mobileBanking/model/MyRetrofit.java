package com.alivepython.mobilebankingappusingphpapi.main_Apps_mobileBanking.model;

import com.alivepython.mobilebankingappusingphpapi.main_Apps_mobileBanking.interfaces.WebService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {

    public static Retrofit api;
    public static WebService service;

    public static WebService getInstance(){

        if (service==null){
            if (api==null){
                Gson gson= new GsonBuilder()
                        .setLenient()
                        .create();

                api= new Retrofit.Builder()
                        .baseUrl("https://testing.alivepython.com/testapi/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
            service= api.create(WebService.class);
            return service;
        }else {
            return service;
        }
    }
}
