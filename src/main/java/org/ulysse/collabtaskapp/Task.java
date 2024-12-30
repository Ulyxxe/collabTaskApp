package org.ulysse.collabtaskapp;

import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.List;

public class Task {

    private int id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private List<Employee> assignedMembers;

    public Task(int id, String title, String description, Status status, Priority priority){
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.assignedMembers = new ArrayList<>();
    }
}
