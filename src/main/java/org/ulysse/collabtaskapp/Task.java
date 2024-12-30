package org.ulysse.collabtaskapp;

import javafx.scene.layout.Priority;

import java.util.List;

public class Task {

    private int id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private List<Employee> assignedMembers;
}
