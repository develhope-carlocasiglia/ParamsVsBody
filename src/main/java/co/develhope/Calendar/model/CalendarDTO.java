package co.develhope.Calendar.model;

// DATA TRANSFER OBJECT

public class CalendarDTO {

    private String name;
    private int userId;
    private String message;

    public CalendarDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
