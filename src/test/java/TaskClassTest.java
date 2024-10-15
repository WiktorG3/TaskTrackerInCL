package src.test.java;

import org.junit.jupiter.api.Test;
import src.main.java.Task;

import static org.junit.jupiter.api.Assertions.*;

public class TaskClassTest {

    @Test
    public void testTaskCreation(){
        Task task = new Task(1, "test Task Title", "test Task description", 1, "10-10-2024");
        assertEquals(1, task.getId());
        assertEquals("test Task Title", task.getTitle());
        assertEquals("test Task description", task.getDescription());
        assertEquals(1, task.getPriority());
        assertEquals("Not started", task.getStatus());
        assertEquals("10-10-2024", task.getStartDate());
    }

    @Test
    public void testGetId() {
        Task task = new Task(1, "Test Task", "Test Description", 1, "10-10-2024");
        assertEquals(1, task.getId());
    }

    @Test
    public void testGetTitle() {
        Task task = new Task(1, "Test Task", "Test Description", 1, "10-10-2024");
        assertEquals("Test Task", task.getTitle());
    }

    @Test
    public void testGetDescription() {
        Task task = new Task(1, "Test Task", "Test Description", 1, "10-10-2024");
        assertEquals("Test Description", task.getDescription());
    }

    @Test
    public void testGetPriority() {
        Task task = new Task(1, "Test Task", "Test Description", 1, "10-10-2024");
        assertEquals(1, task.getPriority());
    }

    @Test
    public void testGetStartDate() {
        Task task = new Task(1, "Test Task", "Test Description", 1, "10-10-2024");
        assertEquals("10-10-2024", task.getStartDate());
    }


    @Test
    public void testSetId() {
        Task task = new Task(1, "Title", "Description", 1, "01-01-2024");
        task.setId(2);
        assertEquals(2, task.getId());
    }

    @Test
    public void testSetTaskTitle() {
        Task task = new Task(1, "Old Title", "Description", 1, "01-01-2024");
        task.setTitle("New Title");
        assertEquals("New Title", task.getTitle());
    }

    @Test
    public void testSetDescription() {
        Task task = new Task(1, "Title", "Old Description", 1, "01-01-2024");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }

    @Test
    public void testSetPriority() {
        Task task = new Task(1, "Title", "Description", 3, "01-01-2024");
        task.setPriority(2);
        assertEquals(2, task.getPriority());
    }

    @Test
    public void testSetStatus() {
        Task task = new Task(1, "Test Task", "Test Description", 2, "10-10-2024");
        task.setStatus("In Progress");
        assertEquals("In Progress", task.getStatus());

        task.setStatus("Completed");
        assertEquals("Completed", task.getStatus());
    }

    @Test
    public void testSetStartDate() {
        Task task = new Task(1, "Title", "Description", 1, "01-01-2024");
        task.setStartDate("05-05-2024");
        assertEquals("05-05-2024", task.getStartDate());
    }

    @Test
    public void testToString() {
        Task task = new Task(1, "Test Task Title", "Test Task Description", 3, "10-10-2024");
        String expectedString = "\n----------------------------\n" +
                "ID: 1 Title: Test Task Title\n" +
                "Description:Test Task Description\n" +
                "Priority:3\n" +
                "Status:Not started\n" +  //Default status is "Not started"
                "Start Date:10-10-2024\n" +
                "----------------------------\n";
        assertEquals(expectedString, task.toString());
    }

    @Test
    public void testNoSideEffectsFromSetters() {
        Task task = new Task(1, "Test Task", "Test Description", 3, "10-10-2024");

        // Update title only
        task.setTitle("New Task Title");
        assertEquals("New Task Title", task.getTitle());
        assertEquals(1, task.getId());  // Ensure other fields remain unchanged
        assertEquals("Test Description", task.getDescription());
        assertEquals(3, task.getPriority());
        assertEquals("Not started", task.getStatus());  // Ensure the default status remains

        // Update priority only
        task.setPriority(1);
        assertEquals(1, task.getPriority());
        assertEquals("New Task Title", task.getTitle());
    }
}
