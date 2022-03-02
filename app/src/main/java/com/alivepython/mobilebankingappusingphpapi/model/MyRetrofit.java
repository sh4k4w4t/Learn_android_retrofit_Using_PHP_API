package com.alivepython.mobilebankingappusingphpapi.model;

import com.alivepython.mobilebankingappusingphpapi.interfaces.WebService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {

    public static Retrofit api;
    public static WebService service;

    public static WebService getinstance(){

        if (service==null){
            if (api==null){
                Gson gson= new GsonBuilder()
                        .setLenient()
                        .create();

                api= new Retrofit.Builder()
                        .baseUrl("https://www.alivepython.com//testapi/")
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
