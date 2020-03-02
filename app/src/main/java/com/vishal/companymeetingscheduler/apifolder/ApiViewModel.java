package com.vishal.companymeetingscheduler.apifolder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.google.gson.JsonArray;

public class ApiViewModel extends ViewModel {

    private ApiModal apiModal;
    private MediatorLiveData<JsonArray> getScheduleMediatorLiveData;

    public ApiViewModel(){

        apiModal = new ApiModal();
        getScheduleMediatorLiveData = new MediatorLiveData<>();
    }

    public LiveData<JsonArray> scheduleApiResult(){

        return getScheduleMediatorLiveData;
    }

    public void callScheduleApi(String date){

        final LiveData<JsonArray> scheduleApiLiveData = apiModal.getSchedule(date);
        getScheduleMediatorLiveData.addSource(scheduleApiLiveData, new Observer<JsonArray>() {
            @Override
            public void onChanged(JsonArray jsonArray) {

                if(getScheduleMediatorLiveData.hasObservers()){
                    getScheduleMediatorLiveData.removeSource(scheduleApiLiveData);
                }

                getScheduleMediatorLiveData.setValue(jsonArray);
            }
        });
    }

}
