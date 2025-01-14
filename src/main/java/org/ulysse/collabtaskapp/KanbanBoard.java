package org.ulysse.collabtaskapp;
import java.util.ArrayList;
import java.util.List;

public class KanbanBoard {
    private List<Task> toDo;
    private List<Task> inProgress;
    private List<Task> done;

    public KanbanBoard() {}

    public List<String> addTaskToDo(Task task) {
        if (task != null) {
            toDo.add(task);
            System.out.println("Task added: " + task.getTitle());
        };
    }

}

