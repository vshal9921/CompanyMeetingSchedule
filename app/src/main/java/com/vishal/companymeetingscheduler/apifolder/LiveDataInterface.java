package com.vishal.companymeetingscheduler.apifolder;

import androidx.lifecycle.LiveData;

import com.google.gson.JsonArray;

public interface LiveDataInterface {

    LiveData<JsonArray> getSchedule(String date);
}
