package ca.dal.csci3130.coursesmanagementsystem.DisplayCourses;

/**
 * This class is defined by get the information from database, and store the data to TA object
 */

public class TA {

    private String email;
    private String name;

    public TA(String name,String email){
        this.name = name;
        this.email = email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
}

