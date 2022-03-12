package com.alivepython.mobilebankingappusingphpapi.test_JsonPlaceHolder_bs_posts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Posts_Retrofit {
    public static Retrofit api;
    public static Posts_Interface services;

    public static Posts_Interface getServices(){
        if (services==null){
            if (api==null){
                Gson gson= new GsonBuilder()
                        .setLenient()
                        .create();

                api= new Retrofit.Builder()
                        .baseUrl("https://jsonplaceholder.typicode.com/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
            services= api.create(Posts_Interface.class);
            return services;
        }
        return services;
    }
}
