package com.vishal.companymeetingscheduler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.MyViewHolder> {

    private ArrayList<SchedulePojo> scheduleList;

    public ScheduleAdapter(ArrayList<SchedulePojo> scheduleList){

        this.scheduleList = scheduleList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView meeting_time;
        private TextView meeting_description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            meeting_time = itemView.findViewById(R.id.meeting_time);
            meeting_description = itemView.findViewById(R.id.meeting_description);
        }
    }

    @NonNull
    @Override
    public ScheduleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_schedule_adapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleAdapter.MyViewHolder holder, int position) {

        holder.meeting_time.setText(scheduleList.get(position).getStartTime() + " " + scheduleList.get(position).getEndTime());
        holder.meeting_description.setText(scheduleList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }
}
