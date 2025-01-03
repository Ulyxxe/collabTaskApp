package org.ulysse.collabtaskapp;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private List<String> events;

    public Calendar(){
        this.events = new ArrayList<>();
    }

    public List<String> getEvents() {
        return events;
    }
    
}
