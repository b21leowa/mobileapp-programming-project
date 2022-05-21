package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {

    private ArrayList<Event> event;
    private SelectListener listener;

    EventAdapter(Context context, ArrayList<Event> event, SelectListener listener) {
        this.event = event;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_events, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        String name = event.get(position).getName();
        String location = "Plats: " + event.get(position).getLocation();
        String datum = "Datum: " + event.get(position).getAuxdata().getDatum();
        String img = event.get(position).getAuxdata().getImg();

        holder.eventName.setText(name);
        holder.eventLocation.setText(location);
        holder.eventDate.setText(datum);
        Glide.with(holder.itemView.getContext()).load(img).into(holder.eventImage);

        holder.singleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(event.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.event.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        private final TextView eventName;
        private final TextView eventLocation;
        private final TextView eventDate;
        private final ImageView eventImage;
        public ConstraintLayout singleItem;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.event_title);
            eventLocation = itemView.findViewById(R.id.event_location);
            eventDate = itemView.findViewById(R.id.event_date);
            eventImage = itemView.findViewById(R.id.event_img);
            singleItem = itemView.findViewById(R.id.item_container);
        }
    }
}
