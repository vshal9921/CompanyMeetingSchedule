package com.vishal.companymeetingscheduler.apifolder;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/schedule")
    Call<JsonArray> getSchedule(@Query("date") String date);
}
