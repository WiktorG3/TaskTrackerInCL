import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskTracker {
    public static void main(String[] args) {
        loadTasksFromFile();
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
                    saveTasksListToFile();
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
        int taskPriority = 0;
        boolean validPriority = false;
        // Loop until the user enters a valid priority between 1 and 5
        while (!validPriority) {
            System.out.print("Enter Task Priority (1(highest) - 5(lowest)): ");
            if (scanner.hasNextInt()) {
                taskPriority = scanner.nextInt();
                scanner.nextLine();
                if (taskPriority >= 1 && taskPriority <= 5) {
                    validPriority = true;
                } else {
                    System.out.println("Invalid priority. Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next();
            }
        }
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
        scanner.nextLine();

        Task task = findTaskById(taskId);
        if(task != null){
            System.out.println("Enter New Task Title (leave blank to keep current): ");
            String newTitle = scanner.nextLine();
            if(!newTitle.trim().isEmpty()){
                task.setTitle(newTitle);
            }

            System.out.println("Enter New Task Description (leave blank to keep current): ");
            String newDescription = scanner.nextLine();
            if(!newDescription.trim().isEmpty()){
                task.setDescription(newDescription);
            }

            // Update Task Priority (as Integer between 1-5)
            System.out.print("Enter new Task Priority (1(highest) - 5(lowest), leave blank to keep current): ");
            String newPriority = scanner.nextLine();
            if (!newPriority.trim().isEmpty()) {
                try {
                    int priority = Integer.parseInt(newPriority);
                    if (priority >= 1 && priority <= 5) {
                        task.setPriority(priority);
                        System.out.println("Task priority updated to: " + priority);
                    } else {
                        System.out.println("Invalid priority. Please enter a number between 1 and 5.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Priority must be a number.");
                }
            }

            System.out.print("Enter new Task Start Date (leave blank to keep current): ");
            String newStartDate = scanner.nextLine();
            if (!newStartDate.trim().isEmpty()) {
                task.setStartDate(newStartDate);
            }
            System.out.println("Task updated successfully.");
        }else{
            System.out.println("Task not found!");
        }
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

        Task task = findTaskById(taskId);
        if(task != null){
            task.setStatus("Completed");
            System.out.println("Task Marked as Completed: " + task);
        }else{
            System.out.println("Task not found.");
        }
    }

    private static void deleteTask(Scanner scanner) {
        System.out.println("Enter Task Id to delete: ");
        int taskId = scanner.nextInt();
        scanner.nextLine();

        Task task = findTaskById(taskId);
        if(task != null){
            taskList.remove(task);
            System.out.println("Task Deleted: " + task);
        }else{
            System.out.println("Task not found.");
        }
    }

    private static Task findTaskById(int taskId) {
        for(Task task : taskList){
            if(task.getId() == taskId){
                return task;
            }
        }
        return null;
    }

    public static void saveTasksListToFile(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("tasks.json"), taskList);
            System.out.println("Tasks saved to file.");
        } catch(IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static void loadTasksFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File("tasks.json");
            if (file.exists()) {
                // Read the task list from the tasks.json file
                Task[] tasksArray = mapper.readValue(file, Task[].class);
                taskList = new ArrayList<>(List.of(tasksArray)); // Load into ArrayList
                taskIdCounter = taskList.size() + 1; // Update the counter for unique task IDs
                System.out.println("Tasks loaded from file.");
            } else {
                System.out.println("No existing tasks found. Starting fresh.");
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

}