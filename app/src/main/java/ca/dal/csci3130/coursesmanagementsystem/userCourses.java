package ca.dal.csci3130.coursesmanagementsystem;

public class userCourses {
    private String userCourseName;
    public userCourses() {

    }
    public void setUserCourseName(String courseName) {
        userCourseName = courseName;
    }
    public String getUserCourseName() {
        return userCourseName;
    }
}
/**
 * Class for add courses to a user
 * @param userCourseName course Name of the added course
 * @return String userCourseName
 * */