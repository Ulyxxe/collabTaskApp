package org.ulysse.collabtaskapp;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private final List<String> events;

    public Calendar(){
        this.events = new ArrayList<>();
    }

    public List<String> getEvents() {
        return events;
    }
    public void addEvent(String event) {
        if (!events.contains(event)) {
            events.add(event);
        }
    }
    public void removeEvent(String event) {
        events.remove(event);
    }


}
