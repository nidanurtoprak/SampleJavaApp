// src/main/java/org/example/Main.java
package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();
        int nextId = 1;

        while (true) {
            System.out.println("\n=== Simple To‑Do CLI ===");
            System.out.println("1) Add task");
            System.out.println("2) List tasks");
            System.out.println("3) Mark task done");
            System.out.println("4) Delete task");
            System.out.println("5) Exit");
            System.out.print("Choose an option: ");

            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1":
                    System.out.print("Enter task description: ");
                    String desc = sc.nextLine().trim();
                    tasks.add(new Task(nextId++, desc));
                    System.out.println("Task added.");
                    break;

                case "2":
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks.");
                    } else {
                        tasks.forEach(t -> System.out.println(t));
                    }
                    break;

                case "3":
                    System.out.print("Enter task ID to mark done: ");
                    int doneId = Integer.parseInt(sc.nextLine());
                    tasks.stream()
                            .filter(t -> t.getId() == doneId)
                            .findFirst()
                            .ifPresentOrElse(
                                    Task::markDone,
                                    () -> System.out.println("Task not found.")
                            );
                    break;

                case "4":
                    System.out.print("Enter task ID to delete: ");
                    int delId = Integer.parseInt(sc.nextLine());
                    if (tasks.removeIf(t -> t.getId() == delId)) {
                        System.out.println("Task deleted.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case "5":
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
