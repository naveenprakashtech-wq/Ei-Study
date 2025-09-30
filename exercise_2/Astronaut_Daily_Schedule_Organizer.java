package exercise_2;

import java.time.LocalTime;
import java.util.*;
interface Observer {
    void notifyConflict(Task newTask, Task existingTask);
}
class ConflictObserver implements Observer {
    
    public void notifyConflict(Task newTask, Task existingTask) {
        System.out.println("Conflict detected: \"" + newTask.getDescription() +"\" overlaps with \"" + existingTask.getDescription() + "\"");
    }
}
class Task {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private String priority;
    public Task(String description, LocalTime startTime, LocalTime endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }
    public String getDescription() { 
    	return description; 
    	}
    public LocalTime getStartTime() { 
    	return startTime; 
    	}
    public LocalTime getEndTime() { 
    	return endTime; 
    	}
    public String getPriority() { 
    	return priority;
    	}
    public String toString() {
        return startTime + " - " + endTime + ": " + description + " [" + priority + "]";
    }
}


class TaskFactory {
    public static Task createTask(String description, String start, String end, String priority) {
        try {
            LocalTime startTime = LocalTime.parse(start);
            LocalTime endTime = LocalTime.parse(end);

            if (endTime.isBefore(startTime)) {
                throw new IllegalArgumentException("End time cannot be before start time.");
            }

            return new Task(description, startTime, endTime, priority);
        } catch (Exception e) {
            System.out.println("Error: Invalid time format. Use HH:mm (e.g., 09:30).");
            return null;
        }
    }
}


class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<Observer> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    private void notifyConflict(Task newTask, Task existingTask) {
        for (Observer obs : observers) {
            obs.notifyConflict(newTask, existingTask);
        }
    }

    public boolean addTask(Task task) {
        if (task == null) return false;

        for (Task existing : tasks) {
            boolean overlap = !(task.getEndTime().isBefore(existing.getStartTime()) ||
                                task.getStartTime().isAfter(existing.getEndTime()));
            if (overlap) {
                notifyConflict(task, existing);
                return false;
            }
        }

        tasks.add(task);
        tasks.sort(Comparator.comparing(Task::getStartTime));
        System.out.println(" Task added successfully.");
        return true;
    }

    public void removeTask(String description) {
        boolean removed = tasks.removeIf(t -> t.getDescription().equalsIgnoreCase(description));
        if (removed) {
            System.out.println(" Task removed successfully.");
        } else {
            System.out.println(" Error: Task not found.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println(" No tasks scheduled for the day.");
        } else {
            tasks.forEach(System.out::println);
        }
    }
}

public class Astronaut_Daily_Schedule_Organizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ScheduleManager manager = ScheduleManager.getInstance();
        manager.addObserver(new ConflictObserver());

        while (true) {
            System.out.println("\n===== Astronaut Daily Schedule Organizer =====");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter start time (HH:mm): ");
                    String start = sc.nextLine();
                    System.out.print("Enter end time (HH:mm): ");
                    String end = sc.nextLine();
                    System.out.print("Enter priority (High/Medium/Low): ");
                    String priority = sc.nextLine();

                    Task task = TaskFactory.createTask(desc, start, end, priority);
                    manager.addTask(task);
                    break;

                case 2:
                    System.out.print("Enter task description to remove: ");
                    String removeDesc = sc.nextLine();
                    manager.removeTask(removeDesc);
                    break;

                case 3:
                    manager.viewTasks();
                    break;

                case 4:
                    System.out.println(" Exiting Scheduler...");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }
        }
    }
}
