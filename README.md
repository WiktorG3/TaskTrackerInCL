# TaskTrackerInCL
### Overview
**TaskTrackerInCL** is a simple command-line based Java application that allows users to easily manage their tasks. Users can add, list, update, delete tasks with priorities, descriptions and start dates. The application supports task priority ranging from 1 (highest) to 5 (lowest), and it ensures that dates are entered in a valid format (DD-MM-YYYY).
Additionally, the application automatically saves tasks to a tasks.json file upon exiting and loads tasks from the file when the program starts. This ensures that all your tasks are preserved between sessions.

### Features
* Add New Task - Creates task with unique id, title, description, priority and start date.
* List Tasks - Displays all tasks that have been created in JSON file.
* Update Task - Modifies an existing task's title, description, priority or start date.
* Delete Task - Removes task by its ID.
* Mark Task - Marks task as in Progress/Completed.
* Input Validation - Ensures correct input formats for task priority (1-5) and task start date (DD-MM-YYYY).

### How To Use
  1. **Clone the Repo**

     `git clone https://github.com/WiktorG3/TaskTrackerInCL.git

  
  3. **Setup the Project**
     * Make sure you have Java Development Kit (JDK) installed on your machine.
     * Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse) or use a command-line tool to compile and run the project.

  4. **Compile and Run**
     
      You can use your IDE or using the following command:

       To compile:
     
      `javac TaskTracker.java`
     
       To Run:
     
      `java TaskTracker`

  5. **Main menu**
    Once the project is running, you will see a menu with several options, from now you can add, list, update, mark and delete your tasks. Just pick your option (1-6) or 0 to exit and save the file:

      ```
      Welcome to Task Tracker!
      Choose what you would like to do:
      1. Add New Task
      2. List All Tasks
      3. Update Task
      4. Mark Task as In Progress
      5. Mark Task as Completed
      6. Delete Task
      0. Exit
      What's your choice:
      ```

  7. **Exiting the program**
    Choose 0 to exit the program. Upon exiting, your tasks will be saved to tasks.json, and they will be automatically loaded the next time you run the program.

### Conclusion
Task Tracker CLI is a simple and efficient way to manage tasks from the command line. It provides input validation, saves tasks between sessions using a JSON file, and offers a user-friendly interface for managing tasks.

