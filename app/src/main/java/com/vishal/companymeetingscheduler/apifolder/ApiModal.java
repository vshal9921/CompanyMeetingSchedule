package com.vishal.companymeetingscheduler.apifolder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiModal implements LiveDataInterface{
    @Override
    public LiveData<JsonArray> getSchedule(String date) {

        final MutableLiveData<JsonArray> getScheduleMutableLiveData = new MutableLiveData<>();
        ApiInterface apiInterface = ApiRetrofit.adapter.create(ApiInterface.class);
        Call<JsonArray> getScheduleResponseCall = apiInterface.getSchedule(date);

        getScheduleResponseCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if(response.body()!= null){
                    getScheduleMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });

        return getScheduleMutableLiveData;
    }
}
