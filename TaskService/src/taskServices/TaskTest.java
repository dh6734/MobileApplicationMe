package taskServices;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {

    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task("T001", "Initial Task", "Initial task description");
    }

    @Test
    public void testCreateTaskValid() {
        assertNotNull(task);
        assertEquals("T001", task.getTaskId());
        assertEquals("Initial Task", task.getName());
        assertEquals("Initial task description", task.getDescription());
    }

    @Test
    public void testCreateTaskInvalidId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Valid Name", "Valid Description");
        });
        assertEquals("Invalid task ID", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("T12345678901", "Valid Name", "Valid Description");
        });
        assertEquals("Invalid task ID", exception.getMessage());
    }

    @Test
    public void testCreateTaskInvalidName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("T002", null, "Valid Description");
        });
        assertEquals("Invalid task name", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("T002", "This name is way too long", "Valid Description");
        });
        assertEquals("Invalid task name", exception.getMessage());
    }

    @Test
    public void testCreateTaskInvalidDescription() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("T003", "Valid Name", null);
        });
        assertEquals("Invalid task description", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("T003", "Valid Name", "This description is way too long, it exceeds the maximum allowed length of fifty characters.");
        });
        assertEquals("Invalid task description", exception.getMessage());
    }

    @Test
    public void testUpdateTaskName() {
        task.setName("Updated Task Name");
        assertEquals("Updated Task Name", task.getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        task.setDescription("Updated task description");
        assertEquals("Updated task description", task.getDescription());
    }

    @Test
    public void testUpdateTaskInvalidName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
        assertEquals("Invalid task name", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            task.setName("This name is way too long");
        });
        assertEquals("Invalid task name", exception.getMessage());
    }

    @Test
    public void testUpdateTaskInvalidDescription() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
        assertEquals("Invalid task description", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("This description is way too long, it exceeds the maximum allowed length of fifty characters.");
        });
        assertEquals("Invalid task description", exception.getMessage());
    }
}
