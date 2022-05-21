package com.example.project;

import java.util.Date;

public class Event {

    private String ID;
    private final String name;
    private String location;
    private String category;
    private final int size;
    private final int cost;
    private Auxdata auxdata;

    public Event(String ID, String name, String location, String category, int size, int cost, Auxdata auxdata) {
        this.ID = ID;
        this.name = name;
        this.location = location;
        this.category = category;
        this.size = size;
        this.cost = cost;
        this.auxdata = auxdata;
    }

    private class Auxdata {
       private String img;
       private Date datum;

       public Auxdata(String img, Date datum) {
           this.img = img;
           this.datum = datum;
       }

       public String getImg() {
           return img;
       }

       public Date getDatum() {
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

    public int getCost() {
        return cost;
    }

    public Auxdata getAuxdata() {
        return auxdata;
    }

    public String getID() {
        return ID;
    }
}
