package taskServices;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("T001", "Task One", "First task description");
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("T001"));
    }

    @Test
    public void testAddDuplicateTask() {
        Task task = new Task("T001", "Task One", "First task description");
        taskService.addTask(task);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task);
        });
        assertEquals("Task with this ID already exists", exception.getMessage());
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("T001", "Task One", "First task description");
        taskService.addTask(task);
        taskService.deleteTask("T001");
        assertNull(taskService.getTask("T001"));
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task("T001", "Task One", "First task description");
        taskService.addTask(task);
        taskService.updateTask("T001", "Updated Task Name", "Updated description");
        Task updatedTask = taskService.getTask("T001");
        assertEquals("Updated Task Name", updatedTask.getName());
        assertEquals("Updated description", updatedTask.getDescription());
    }

    @Test
    public void testUpdateNonExistentTask() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTask("T999", "Name", "Description");
        });
        assertEquals("Task not found", exception.getMessage());
    }
}
