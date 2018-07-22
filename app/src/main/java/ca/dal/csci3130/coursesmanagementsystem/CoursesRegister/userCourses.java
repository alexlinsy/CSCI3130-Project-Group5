package ca.dal.csci3130.coursesmanagementsystem.CoursesRegister;
/**
 * Class for add courses to a user
 *
 * */
public class userCourses {
    private String userCourseName;
    private String courseID;
    private String courseYear;
    private String courseMajor;
    private String courseTime;
    private String userCourseID;

    public userCourses() {

    }

    public void setUserCourseName(String courseName) {
        userCourseName = courseName;
    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }
    public  void setCourseMajor(String courseMajor) {
        this.courseMajor = courseMajor;
    }
    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }
    public void setUserCourseID (String userCourseID) {
        this.userCourseID = userCourseID;
    }

    /**
     *
     * @return String userCourseName
     * @return String course ID
     * @return String courseYear
     * @return String courseMajor
     * @return String courseTime
     * @return Stirng userCourseID
     */
    public String getUserCourseName() {
        return userCourseName;
    }
    public String getCourseID() {
        return courseID;
    }
    public String getCourseYear() {
        return courseYear;
    }
    public String getCourseMajor() {
        return courseMajor;
    }
    public String getCourseTime() {
        return courseTime;
    }
    public String getUserCourseID() {
        return userCourseID;
    }
    public String toString() {
        return userCourseName;
    }

    /**
     * @param userCourseName course Name of the added course
     * @param courseID the ID of the course
     * @param courseYear the year of the course
     * @param courseMajor the major of the course
     * @param userCourseID the user course id
     */

}
