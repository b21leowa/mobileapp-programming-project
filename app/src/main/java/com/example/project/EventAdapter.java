package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {

    private ArrayList<Event> events;


    EventAdapter(Context context, ArrayList<Event> events) {
        this.events = events;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_events, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = events.get(position).getName();
        String location = events.get(position).getLocation();
        String datum = events.get(position).getAuxdata().getDatum();

        holder.eventName.setText(name);
        holder.eventLocation.setText(location);
        holder.eventDate.setText(datum);

    }

    @Override
    public int getItemCount() {
        return this.events.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        private final TextView eventName;
        private final TextView eventLocation;
        private final TextView eventDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.event_title);
            eventLocation = itemView.findViewById(R.id.event_location);
            eventDate = itemView.findViewById(R.id.event_date);
        }
    }
}
