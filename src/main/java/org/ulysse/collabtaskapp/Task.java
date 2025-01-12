package org.ulysse.collabtaskapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task {

    private int id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDate dueDate;
    private String category;
    private List<String> comments;
    private List<Employee> assignedMembers;

    public Task(int id, String title, String description, Status status, Priority priority, LocalDate dueDate, String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
        this.category = category;
        this.comments = new ArrayList<>();
        this.assignedMembers = new ArrayList<>();
    }

    public int getId() {
        return id; }

    public void setId(int id) {
        this.id = id; }

    public String getTitle() {
        return title; }

    public void setTitle(String title) {
        this.title = title; }

    public String getDescription() {
        return description; }

    public void setDescription(String description) {
        this.description = description; }

    public Status getStatus() {
        return status; }

    public void setStatus(Status status) {
        this.status = status; }

    public Priority getPriority() {
        return priority; }

    public void setPriority(Priority priority) {
        this.priority = priority; }

    public LocalDate getDueDate() {
        return dueDate; }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate; }

    public String getCategory() {
        return category; }

    public void setCategory(String category) {
        this.category = category; }

    public List<String> getComments() {
        return comments; }

    public List<Employee> getAssignedMembers() {
        return assignedMembers; }


    public void addComment(String comment) {
        this.comments.add(comment);
    }

    public void removeComment(String comment) {
        this.comments.remove(comment);
    }

    public void addAssignedMember(Employee employee) {
        if (!assignedMembers.contains(employee)) {
            assignedMembers.add(employee);
        }
    }

    public void removeAssignedMember(Employee employee) {
        assignedMembers.remove(employee);
    }
}