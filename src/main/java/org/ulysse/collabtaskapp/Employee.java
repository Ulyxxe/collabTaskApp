package org.ulysse.collabtaskapp;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int id;
    private String role;
    private List<Project> projectHistory;

    public Employee (int id, String role){
        this.id = id;
        this.role = role;
        this.projectHistory = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Project> getProjectHistory() {
        return projectHistory;
    }

    public void addProjectToHistory(Project project) {
        if (!projectHistory.contains(project)) {
            projectHistory.add(project);
        }
    }

    public void removeProjectFromHistory(Project project) {
        projectHistory.remove(project);
    }

}
