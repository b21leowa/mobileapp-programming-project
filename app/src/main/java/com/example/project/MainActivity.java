package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener, SelectListener {

    private ArrayList<Event> eventList = new ArrayList<>();
    private ArrayList<Event> filterList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=b21leowa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        eventAdapter = new EventAdapter(this, filterList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(eventAdapter);
        new JsonTask(this).execute(JSON_URL);
    }

    public void onPostExecute(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Event>>() {}.getType();
        ArrayList<Event> fetchedEventList = gson.fromJson(json, type);
        filterList.addAll(fetchedEventList);
        eventList.addAll(fetchedEventList);
        eventAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about_page) {
            Intent intent = new Intent(MainActivity.this, AboutPage.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.small_cost) {
            removeBigCost(filterList);
        }

        if(id == R.id.big_cost) {
           removeSmallCost(filterList);
        }

        if(id == R.id.reset_list) {
            filterList.clear();
            filterList.addAll(eventList);
            eventAdapter.notifyDataSetChanged();
        }

        return super.onOptionsItemSelected(item);
    }

    public void removeBigCost(ArrayList<Event> event) {
        for (int i = 0; i < filterList.size(); i++){
            if (filterList.get(i).getCost() > 50) {
                filterList.remove(filterList.get(i));
                i--;
            }
        }
        eventAdapter.notifyDataSetChanged();
    }

    public void removeSmallCost(ArrayList<Event> event) {
        for (int i = 0; i < filterList.size(); i++) {
            if(filterList.get(i).getCost() <= 50) {
                filterList.remove(filterList.get(i));
                i--;
            }
        }
        eventAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClicked(Event event) {
        Gson gson = new Gson();
        String eventJson = gson.toJson(event);
        Intent intent = new Intent(MainActivity.this, EventDetail.class);
        intent.putExtra("Event", eventJson);
        startActivity(intent);
        System.out.println(event.getName());
    }
}
