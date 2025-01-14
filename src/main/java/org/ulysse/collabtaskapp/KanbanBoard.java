package org.ulysse.collabtaskapp;
import java.util.ArrayList;
import java.util.List;

public class KanbanBoard {
    private List<Task> toDo;
    private List<Task> inProgress;
    private List<Task> done;

    public KanbanBoard() {
        this.toDo = new ArrayList<>();
        this.inProgress = new ArrayList<>();
        this.done = new ArrayList<>();
    }

    public void addTask(Task task) {
        if (task == null) return;

        Status TODO;
        switch (task.getStatus()) {
            case TO_DO -> toDo.add(task);
            case IN_PROGRESS -> inProgress.add(task);
            case DONE -> done.add(task);
        }
        System.out.println("Task added: " + task.getTitle() + " [" + task.getStatus() + "]");
    }


    public boolean moveTask(Task task, Status newStatus) {
        if (task == null || newStatus == null) return false;

        switch (task.getStatus()) {
            case TO_DO -> toDo.remove(task);
            case IN_PROGRESS -> inProgress.remove(task);
            case DONE -> done.remove(task);
        }
        task.setStatus(newStatus);
        addTask(task);
        return true;
    }

    public void listAllTasks() {
        System.out.println("To-Do:");
        toDo.forEach(task -> System.out.println(" - " + task.getTitle()));

        System.out.println("In Progress:");
        inProgress.forEach(task -> System.out.println(" - " + task.getTitle()));

        System.out.println("Done:");
        done.forEach(task -> System.out.println(" - " + task.getTitle()));
    }
}
