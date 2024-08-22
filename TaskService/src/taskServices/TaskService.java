package taskServices;


import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task with this ID already exists");
        }
        tasks.put(task.getTaskId(), task);
    }

    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task not found");
        }
        tasks.remove(taskId);
    }

    public void updateTask(String taskId, String newName, String newDescription) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found");
        }
        if (newName != null) {
            task.setName(newName);
        }
        if (newDescription != null) {
            task.setDescription(newDescription);
        }
    }

    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
