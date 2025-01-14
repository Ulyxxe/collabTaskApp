package org.ulysse.collabtaskapp;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int id;
    private String name;
    private String role;
    private List<Project> projectHistory;

    public Employee (int id, String name, String role){
        this.id = id;
        this.name = name;
        this.role = role;
        this.projectHistory = new ArrayList<>();

    }

    public int getId() {
        return id;
    }
public String getName() {
        return name;
}

public void setName(String name) {
        this.name = name;
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
        if (project != null && !projectHistory.contains(project)) {
            projectHistory.add(project);
            System.out.println("Project added to history for employee " + name);
        }
    }

    public void removeProjectFromHistory(Project project) {
        if (projectHistory.remove(project)) {
            System.out.println("Project removed from history for employee " + name);
        } else {
            System.out.println("Project not removed from history for employee " + name);
        }
    }
    public void listProjectHistory() {
        if (projectHistory.isEmpty()) {
            System.out.println("No projects in history for employee: " + name);
        } else {
            System.out.println("Project history for employee: " + name);
            projectHistory.forEach(project -> System.out.println(" - " + project.getName()));
        }
    }
}