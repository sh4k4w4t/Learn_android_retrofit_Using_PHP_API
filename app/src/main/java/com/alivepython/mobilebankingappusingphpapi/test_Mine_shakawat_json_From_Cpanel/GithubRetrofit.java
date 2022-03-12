package com.alivepython.mobilebankingappusingphpapi.test_Mine_shakawat_json_From_Cpanel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubRetrofit {

    public static Retrofit api;
    public static GithubWebService service;

    public static GithubWebService getService(){
        if (service==null){
            if (api==null){
                Gson gson= new GsonBuilder()
                        .setLenient()
                        .create();
                api= new Retrofit.Builder()
                        .baseUrl("https://testing.alivepython.com/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
            service= api.create(GithubWebService.class);
            return service;
        }
        return service;
    }
}
