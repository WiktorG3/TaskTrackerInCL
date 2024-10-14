import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            System.out.println("\nWelcome to Task Tracker!");
            System.out.println("Choose what you would like to do:");
            System.out.println("1. Add New Task");
            System.out.println("2. List All Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Mark Task as In Progress");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. Delete Task");
            System.out.println("0. Exit");
            System.out.println("What's your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    listTasks();
                    break;
                case 3:
                    updateTask(scanner);
                    break;
                case 4:
                    markTaskAsInProgress(scanner);
                    break;
                case 5:
                    markTaskAsCompleted(scanner);
                    break;
                case 6:
                    deleteTask(scanner);
                    break;
                case 0:
                    System.out.println("See ya!");
                    done = true;
                    break;
                default:
                    System.out.println("Invalid choice! Choose again!");
            }
        }
        scanner.close();
    }

    private static int taskIdCounter = 1;
    private static List<Task> taskList = new ArrayList<>();

    private static void addTask(Scanner scanner) {
        System.out.println("Enter Task Title: ");
        String taskTitle = scanner.next();
        System.out.println("Enter Task Description: ");
        String taskDescription = scanner.next();
        System.out.println("Enter Task Priority ( 1(highest) - 5(lowest)): ");
        int taskPriority = scanner.nextInt();
        System.out.println("Enter Task Start Date: ");
        String taskStartDate = scanner.next();

        //Add Task
        Task newTask = new Task(taskIdCounter++, taskTitle, taskDescription, taskPriority, taskStartDate);
        taskList.add(newTask);
        System.out.println("Task Added: " + newTask);
    }

    private static void listTasks() {
        System.out.println("\nList of Tasks: ");

        //Show Tasks
        if(taskList.isEmpty()){
            System.out.println("No Tasks found!");
        } else {
            for(Task task : taskList){
                System.out.println(task);
            }
        }
    }

    private static void updateTask(Scanner scanner) {
        System.out.println("Enter Task Id to update: ");
        int taskId = scanner.nextInt();
    }

    private static void markTaskAsInProgress(Scanner scanner) {
        System.out.println("Enter Task Id to mark task as in progress: ");
        int taskId = scanner.nextInt();

        Task task = findTaskById(taskId);
        if(task != null){
            task.setStatus("In Progress");
            System.out.println("Task Marked as in Progress: " + task);
        } else {
            System.out.println("Task not found.");
        }
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        System.out.println("Enter Task Id to mark task as completed: ");
        int taskId = scanner.nextInt();
    }
    private static void deleteTask(Scanner scanner) {
        System.out.println("Enter Task Id to delete: ");
        int taskId = scanner.nextInt();
    }

    private static Task findTaskById(int taskId) {
        for(Task task : taskList){
            if(task.getId() == taskId){
                return task;
            }
        }
        return null;
    }

}
