package org.ulysse.collabtaskapp;

import org.ulysse.collabtaskapp.db.TaskDAO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Status projectStatus = Status.IN_PROGRESS;
        System.out.printf(projectStatus.toString());
        KanbanBoard kanbanBoard = new KanbanBoard();
        Project project1 = new Project(1, "Our collabTaskApp", LocalDate.of(2025, 2, 15));
        Task task1 = new Task(1, "Design UI", "Create UI mockups", Status.TO_DO, Priority.HIGH, LocalDate.now().plusDays(7));
        Task task2 = new Task(2, "Kanban Class","Finish the Kanban", Status.TO_DO, Priority.HIGH, LocalDate.now().plusDays(7));
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

        TaskDAO taskDAO = new TaskDAO();


        taskDAO.addTask("Finish project", "Complete the final report", Date.valueOf("2025-01-20"), String.valueOf(Status.TO_DO), Priority.HIGH, 1);


        List<String> tasks = taskDAO.getAllTasks();
        for (String task : tasks) {
            System.out.println("Task: " + task);
    }
}}
