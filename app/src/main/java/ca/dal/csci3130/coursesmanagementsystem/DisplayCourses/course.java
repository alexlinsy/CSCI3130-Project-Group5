package ca.dal.csci3130.coursesmanagementsystem.DisplayCourses;

/**
 * This class is used to make a same structure of our data in database
 * in order to get the information from the database
 * The information include course introduction, course name, course professor and seat
 */
public class course {
    private String courseIntro;
    private String courseName;
    private String professor;
    private String taInfo;
    private String uid;
    private String professorEmail;
    private int seat;

    public course(){ };
    public course(String courseIntro,String courseName,String professor,String professorEmail,int seat){
        this.courseName = courseName;
        this.courseIntro = courseIntro;
        this.professor = professor;
        this.seat = seat;
        this.professorEmail = professorEmail;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getUid() {

        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTaInfo() {

        return taInfo;
    }

    public void setTaInfo(String taInfo) {
        this.taInfo = taInfo;
    }

    public String getProfessor() {

        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getCourseName() {

        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseIntro() {

        return courseIntro;
    }

    public void setCourseIntro(String courseIntro) {
        this.courseIntro = courseIntro;
    }
    public String getProfessorEmail() {
        return professorEmail;
    }
    public void setProfessorEmail(String professorEmail) {
        this.professorEmail = professorEmail;
    }
}
