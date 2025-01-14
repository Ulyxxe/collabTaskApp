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

    public boolean moveTask(Task task, String targetColumn) {
        if (task != null || targetColumn == null) {
            return false;
        }
        if (toDo.remove(task)){
            addToColumn(task, targetColumn);
            return true;
        } else if (inProgress.remove(task)) {
            addToColumn(task, targetColumn);
            return true;
        } else if (done.remove(task)) {
            addToColumn(task, targetColumn);
            return true;
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

