package ca.dal.csci3130.coursesmanagementsystem.CoursesRegister;

/***
 * Class for get course detail infomation
 */
public class courseInfo{

    private String courseIntro;
    private String courseName;
    private String location;
    private String professor;
    private String professorEmail;
    private String time;
    private String imageUrl;

    public courseInfo() {

    }

    public void setCourseIntro(String courseIntro){
        this.courseIntro = courseIntro;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public void setCourseLocation(String courseLocation){
        this.location= courseLocation;
    }
    public void setProfessor(String professor){
        this.professor = professor;
    }
    public void setTime(String time){
        this.time = time;
    }
    public void setProfessorEmail(String professorEmail) { this.professorEmail = professorEmail; }





    /**
     * @return the detail of course info
     * @return the name of course
     * @return the location of the course
     * @return the name of professor
     * @return the schedule of the course
     */
    public String getCourseIntro() {
        return courseIntro;
    }
    public String getCourseName() {
        return courseName;
    }
    public String getLocation() {
        return location;
    }
    public String getProfessor() {
        return professor;
    }
    public String getTime() {
        return time;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public String getProfessorEmail() { return professorEmail; }

    /**
     * @param courseInfo the course introduction
     * @param courseName the name of the course
     * @param location the course's location
     * @param professor the name of professor
     * @param time the schedule of the course
     */

}

