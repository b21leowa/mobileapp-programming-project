package com.example.project;

import java.util.Date;

public class Event {

    private final String ID;
    private final String name;
    private final String location;
    private final String category;
    private final int size;
    private final int cost;
    private final Auxdata auxdata;

    public Event(String ID, String name, String location, String category, int size, int cost, Auxdata auxdata) {
        this.ID = ID;
        this.name = name;
        this.location = location;
        this.category = category;
        this.size = size;
        this.cost = cost;
        this.auxdata = auxdata;
    }

    public class Auxdata {
       private final String img;
       private final String datum;

       public Auxdata(String img, String datum) {
           this.img = img;
           this.datum = datum;
       }

       public String getImg() {
           return img;
       }

       public String getDatum() {
           return datum;
       }
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public int getSize() {
        return size;
    }

    public String getSizeString() {
        return "" +size;
    }

    public int getCost() {
        return cost;
    }

    public String getCostString() {
        return ""+cost;
    }
    public Auxdata getAuxdata() {
        return auxdata;
    }

    public String getID() {
        return ID;
    }
}
