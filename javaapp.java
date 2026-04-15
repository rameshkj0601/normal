import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskApp {

    private static final List<Task> tasks = new ArrayList<>();
    private static int idCounter = 1;

    public static void main(String[] args) {
        System.out.println("Starting TaskApp...");
        System.out.println("Build Time: " + LocalDateTime.now());

        addTask("Learn Java", "Practice core Java concepts");
        addTask("Learn CI/CD", "Trigger pipeline with GitHub Actions or Jenkins");
        addTask("Write Tests", "Add unit tests later");

        System.out.println("\nAll Tasks:");
        listTasks();

        System.out.println("\nMarking task 2 as completed...");
        markTaskCompleted(2);

        System.out.println("\nTask List After Update:");
        listTasks();

        System.out.println("\nDeleting task 1...");
        deleteTask(1);

        System.out.println("\nFinal Task List:");
        listTasks();

        System.out.println("\nApplication finished successfully.");
    }

    private static void addTask(String title, String description) {
        Task task = new Task(idCounter++, title, description, false);
        tasks.add(task);
        System.out.println("Added: " + task);
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void markTaskCompleted(int id) {
        Optional<Task> taskOptional = tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setCompleted(true);
            System.out.println("Updated: " + task);
        } else {
            System.out.println("Task with id " + id + " not found.");
        }
    }

    private static void deleteTask(int id) {
        boolean removed = tasks.removeIf(task -> task.getId() == id);
        if (removed) {
            System.out.println("Deleted task with id: " + id);
        } else {
            System.out.println("Task with id " + id + " not found.");
        }
    }

    static class Task {
        private final int id;
        private final String title;
        private final String description;
        private boolean completed;

        public Task(int id, String title, String description, boolean completed) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.completed = completed;
        }

        public int getId() {
            return id;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", completed=" + completed +
                    '}';
        }
    }
}
