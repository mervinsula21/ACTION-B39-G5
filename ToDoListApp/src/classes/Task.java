package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Task {
    private static int idCounter = 1;
    private int id;
    private String description;
    private LocalDate deadline; // **Changed to LocalDate for better date handling**
    private boolean isCompleted;
    private String priority;

    public Task(String description, String priority) {
        this.id = idCounter++;
        this.description = description;
        setDeadline(deadline); // **Updated to call the new setDeadline method**
        this.priority = priority;
        this.isCompleted = false;
    }

    public int getId() {
    	return id;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public LocalDate getDeadline() {
    	return deadline;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
    
    // Method to set the deadline with validation
    public void setDeadline(LocalDate deadline) {
    	try {
    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    			this.deadline = LocalDate.parse(deadline, formatter);
    	} catch (DateTimeParseException e) {
    			System.out.println("Invalid date format. Please use 'yyyy-MM-dd'.");
    			this.deadline = null; // or set to a default date if necessary
    	}
    }

    public String getPriority() {
    	 return priority;
    	 }

    public void markAsCompleted() {
        this.isCompleted = true;
        System.out.println("Task ID " + id + " marked as completed.");
    }

    @Override
    public String toString() {
        return "Task ID: " + id +
               ", Description: " + description +
               ", Deadline: " + deadline +
               ", Completed: " + (isCompleted ? "Yes" : "No") + // Modified to accommodate LocalDate
               ", Priority: " + priority;
    }
}