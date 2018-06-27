package ca.dal.csci3130.coursesmanagementsystem;

public class courseInfo {

    private String courseIntro;
    private String courseName;
    private String location;
    private String professor;
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


}