package org.example;

public class Task {
    private final int id;
    private final String description;
    private boolean done = false;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void markDone() {
        this.done = true;
    }

    @Override
    public String toString() {
        return String.format("%d. [%s] %s",
                id,
                (done ? "x" : " "),
                description
        );
    }
}
