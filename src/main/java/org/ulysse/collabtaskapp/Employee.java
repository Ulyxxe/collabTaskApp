package org.ulysse.collabtaskapp;

import java.util.ArrayList;

public class Employee {

    private int id;
    private String role;
    private List<Project> projectHistory;

    public Employee (int id, String role){
        this.id = id;
        this.role = role;
        this.projectHistory = new ArrayList<>();

    }
}
