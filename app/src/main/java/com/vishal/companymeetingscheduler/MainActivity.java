package com.vishal.companymeetingscheduler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.vishal.companymeetingscheduler.apifolder.ApiViewModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView date_textview;
    private LinearLayout prev_layout;
    private LinearLayout next_layout;
    private Button schedule_button;
    private RecyclerView schedule_reylerview;
    private ScheduleAdapter scheduleAdapter;
    private ApiViewModel apiViewModel;
    private Gson gson;
    private ArrayList<SchedulePojo> scheduleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date_textview = findViewById(R.id.date_textview);
        prev_layout = findViewById(R.id.prev_layout);
        next_layout = findViewById(R.id.next_layout);
        schedule_button = findViewById(R.id.schedule_button);
        schedule_reylerview = findViewById(R.id.schedule_reylerview);

        prev_layout.setOnClickListener(this);
        next_layout.setOnClickListener(this);
        schedule_button.setOnClickListener(this);

        gson = new Gson();
        scheduleList = new ArrayList<>();

        apiViewModel = new ApiViewModel();
        apiViewModel.callScheduleApi("01/03/2020");
        apiViewModel.scheduleApiResult().observe(this, new Observer<JsonArray>() {
            @Override
            public void onChanged(JsonArray jsonArray) {

                if(jsonArray != null && jsonArray.size() > 0){


                    Type type = new TypeToken<List<SchedulePojo>>(){}.getType();
                    scheduleList = gson.fromJson(jsonArray, type);

                    if(scheduleList.size() > 0){

                        scheduleAdapter = new ScheduleAdapter(scheduleList);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                        schedule_reylerview.setLayoutManager(layoutManager);
                        schedule_reylerview.setAdapter(scheduleAdapter);
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.prev_layout :

                break;

            case R.id.next_layout :

                break;

            case R.id.schedule_button :

                Intent intent = new Intent(this, ScheduleMeetingActivity.class);
                startActivity(intent);

                break;
        }
    }
}
