package com.alivepython.mobilebankingappusingphpapi.test_Mine_HistoryPhp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Mine_Retrofit {
    public static Retrofit mine_api;
    public static Mine_Web_Service mine_service;

    public static Mine_Web_Service getMine_service(){
        if (mine_service==null){
            if (mine_api==null){
                Gson gson= new GsonBuilder()
                        .setLenient()
                        .create();

                mine_api= new Retrofit.Builder()
                        .baseUrl("https://testing.alivepython.com/testapi/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
            mine_service= mine_api.create(Mine_Web_Service.class);
            return mine_service;
        }
        return mine_service;
    }

}
