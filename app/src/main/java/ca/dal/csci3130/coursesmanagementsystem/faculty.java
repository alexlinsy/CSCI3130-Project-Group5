package ca.dal.csci3130.coursesmanagementsystem;

public class faculty {
    private String courseIntro;
    private String courseName;
    private String professor;
    private String taInfo;

    public String getTaInfo() {
        return taInfo;
    }

    public void setTaInfo(String taInfo) {
        this.taInfo = taInfo;
    }

    private String uid;

    private int seat;



   // private int seat;
    public faculty(){
    }

    public faculty(String courseIntro,String courseName,String professor,int seat) {
        this.courseName = courseName;
        this.courseIntro = courseIntro;
        this.professor = professor;
        this.seat = seat;
        //this.courseIntro = courseIntro;
    }
    public String getCourseIntro() {
        return courseIntro;
    }

    public void setCourseIntro(String courseInfo) {
        this.courseIntro = courseInfo;
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseProfessor() {

        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getProfessor() {
        return professor;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    //private String uid;
    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
