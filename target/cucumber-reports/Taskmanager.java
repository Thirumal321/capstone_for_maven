import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Task {
    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task: " + name + ", Priority: " + priority;
    }
}

public class TaskManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            String taskName = scanner.nextLine();
            if (taskName.equals("done")) {
                break;
            }
            int priority = Integer.parseInt(scanner.nextLine());
            tasks.add(new Task(taskName, priority));
        }

        Collections.sort(tasks, Comparator.comparingInt(task -> task.priority));

        for (Task task : tasks) {
            System.out.println(task);
        }
        scanner.close();
    }
}