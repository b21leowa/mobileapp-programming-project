package com.example.project;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class EventDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);

        ImageView eventImg = findViewById(R.id.event_img);
        TextView eventTitle = findViewById(R.id.event_title);
        TextView eventLocation = findViewById(R.id.event_location);
        TextView eventDate = findViewById(R.id.event_date);
        TextView eventGuest = findViewById(R.id.event_guest);
        TextView eventCost = findViewById(R.id.event_cost);
        TextView eventCategory = findViewById(R.id.event_category);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            Gson gson = new Gson();
            Type type = new TypeToken<Event>() {}.getType();
            Event event = gson.fromJson(extras.getString("Event"), type);
            Glide.with(this).load(event.getAuxdata().getImg()).into(eventImg);
            eventTitle.setText(event.getName());
            eventLocation.setText("Plats: " + event.getLocation());
            eventDate.setText("Datum: " + event.getAuxdata().getDatum());
            eventGuest.setText("Antal Gäster: " + event.getSizeString());
            eventCost.setText("Kostnad: " + event.getCostString() + "kr");
            eventCategory.setText("Typ av fest: " + event.getCategory());
        }

    }
}
