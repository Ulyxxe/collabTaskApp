package org.ulysse.collabtaskapp;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Status projectStatus = Status.IN_PROGRESS;
        System.out.printf(projectStatus.toString());
        KanbanBoard kanbanBoard = new KanbanBoard();
        Project project1 = new Project(1, "Our collabTaskApp", LocalDate.of(2025, 2, 15));
        Task task1 = new Task(1, "Design UI", "Create UI mockups", Status.TO_DO, Priority.HIGH, LocalDate.now().plusDays(7), "Design");
        Task task2 = new Task(2, "Kanban Class","Finish the Kanban", Status.TO_DO, Priority.HIGH, LocalDate.now().plusDays(7), "Design");
        task2.setStatus(Status.IN_PROGRESS);

        project1.addTask(task1);
        project1.addTask(task2);

        project1.addMember(new Employee(101, "Jean  ", "Designer"));
        project1.addMember(new Employee(102, "Bon", "Developer"));
        project1.listMembers();

        System.out.println("Completion Percentage: " + project1.getCompletionPercentage() + "%");
        System.out.println("Is Project Overdue? " + project1.isOverdue());

        kanbanBoard.addTask(task1);
        kanbanBoard.addTask(task2);

        kanbanBoard.listAllTasks();

        kanbanBoard.moveTask(task1, Status.IN_PROGRESS);
        kanbanBoard.listAllTasks();
    }
}
