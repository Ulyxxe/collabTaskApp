package org.ulysse.collabtaskapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {
    private int id;
    private String name;
    private LocalDate deadline;
    private List<Task> tasks;
    private List<Employee> members;

    public Project (int id, String name, LocalDate deadline){
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.tasks = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Employee> getMembers() {
        return members;
    }

    public void addTask(Task task) {
        if (!tasks.contains(task)) {
            tasks.add(task);
            System.out.println("Task added: " + task.getTitle());

        }
    }
    public boolean isOverdue() {
        return LocalDate.now().isAfter(deadline);
    }

    public void removeTask(Task task) {
        if (tasks.remove(task)) {
            System.out.println("Task removed from project: " + task.getTitle());
        } else {
            System.out.println("Task not found in project");
        }
    }

    public void addMember(Employee employee) {
        if (employee != null) {
            members.add(employee);
            System.out.println("Member added to project: "+ employee.getId());
        }
    }

    public void removeMember(Employee employee) {
        if (members.remove(employee)) {
            System.out.println("Member removed from project: " + employee.getId());
        } else {
            System.out.println("Member not found in project");
        }
    }

    public List<Task> getTasksByStatus(Status status) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getStatus() == status) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }
}
