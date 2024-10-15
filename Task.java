import java.util.*;

public class Task {
    private int id;
    private String title;
    private String description;
    private int priority;
    private String status;
    private String startDate;

    //Required by JSON
    public Task(){}

    public Task(int id, String title, String description, int priority, String startDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = "Not started";
        this.startDate = startDate;
    }
    //Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public String getStartDate() {
        return startDate;
    }

    //Setters
    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    public void setStartDate(String startDate){
        this.startDate = startDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }




    @Override
    public String toString() {
        return id + ":" + title + ":" + description + ":" + priority + ":" + status + ":" + startDate;
    }
}
