package src.test.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import src.main.java.Task;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SavingAndLoadingTest {

    @Test
    public void testSaveAndLoadTasks() throws IOException {
        List<Task> taskList = List.of(
                new Task(1, "Task 1", "Description 1", 1, "01-01-2024"),
                new Task(2, "Task 2", "Description 2", 2, "02-01-2024")
        );

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("test-tasks.json");

        // Save tasks to a file
        mapper.writeValue(file, taskList);

        // Load tasks from the file
        Task[] loadedTasks = mapper.readValue(file, Task[].class);

        // Validate that the tasks were saved and loaded correctly
        assertEquals(2, loadedTasks.length);
        assertEquals("Task 1", loadedTasks[0].getTitle());
        assertEquals("Task 2", loadedTasks[1].getTitle());

        // Clean up the test file
        file.delete();
    }
}