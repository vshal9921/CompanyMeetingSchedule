package com.vishal.companymeetingscheduler.apifolder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRetrofit {

    static Gson gson = new GsonBuilder().setLenient().create();

    public static Retrofit adapter = new Retrofit.Builder()
            .baseUrl("http://fathomless-shelf-5846.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(configureTimeouts())
            .build();


    public static OkHttpClient configureTimeouts() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(90, TimeUnit.SECONDS)
                .writeTimeout(90, TimeUnit.SECONDS)
                .readTimeout(90, TimeUnit.SECONDS)
                .build();
        return okHttpClient;
    }
}
