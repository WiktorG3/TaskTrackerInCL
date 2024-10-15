package src.test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Task;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTrackerClassTest {

    private List<Task> taskList;

    @BeforeEach
    public void setup() {
        taskList = new ArrayList<>();
        Task task1 = new Task(1, "Task 1", "Description 1", 1, "01-01-2024");
        Task task2 = new Task(2, "Task 2", "Description 2", 2, "02-01-2024");
        taskList.add(task1);
        taskList.add(task2);
    }

    @Test
    public void testAddTask() {
        Task task3 = new Task(3, "Task 3", "Description 3", 3, "03-01-2024");
        taskList.add(task3);
        assertEquals(3, taskList.size());
        assertEquals("Task 3", taskList.get(2).getTitle());
    }

    @Test
    public void testUpdateTaskTitle() {
        Task task = taskList.get(0); // Task 1
        task.setTitle("Updated Task 1");
        assertEquals("Updated Task 1", task.getTitle());
    }

    @Test
    public void testDeleteTask() {
        taskList.remove(0); // Remove Task 1
        assertEquals(1, taskList.size());
        assertEquals("Task 2", taskList.get(0).getTitle());
    }
}