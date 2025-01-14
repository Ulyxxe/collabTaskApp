package org.ulysse.collabtaskapp;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Status projectStatus = Status.IN_PROGRESS;
        System.out.printf(projectStatus.toString());
        KanbanBoard kanbanBoard = new KanbanBoard();

        Task task1 = new Task(1, "Design UI", "Create UI mockups", Status.TO_DO, Priority.HIGH, LocalDate.now().plusDays(7), "Design");
        Task task2 = new Task(2, "Kanban Class","Finish the Kanban", Status.TO_DO, Priority.HIGH, LocalDate.now().plusDays(7), "Design");


        kanbanBoard.addTask(task1);
        kanbanBoard.addTask(task2);

        kanbanBoard.listAllTasks();

        kanbanBoard.moveTask(task1, Status.IN_PROGRESS);
        kanbanBoard.listAllTasks();
    }
}
