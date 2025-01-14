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
    }

    public boolean moveTask(Task task, Status newStatus) {
        if (task != null || newStatus == null) return false;

        switch (task.getStatus()) {
            case TO_DO -> toDo.remove(task);
            case IN_PROGRESS -> inProgress.remove(task);
            case DONE -> done.remove(task);
        }
        return false;
    }

    private void addToColumn(Task task, String targetColumn) {
        switch (targetColumn.toLowerCase()) {
            case "todo":
                toDo.add(task);
                break;
            case "inprogress":
                inProgress.add(task);
                break;
            case "done":
                done.add(task);
                break;
            default:
                System.out.println("Invalid column specified");
        }
    }

}

