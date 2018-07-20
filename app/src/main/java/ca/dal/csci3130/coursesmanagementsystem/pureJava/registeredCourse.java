package ca.dal.csci3130.coursesmanagementsystem.pureJava;

public class registeredCourse {
    private String courseID;
    private String courseMajor;
    private String courseTime;
    private String courseYear;
    private String startTime;
    private String endTime;
    private char[] avaliableTime;

    public registeredCourse(){
    }
    public registeredCourse(String courseID,String courseMajor,String courseTime,String courseYear){
        this.courseID = courseID;
        this.courseMajor = courseMajor;
        this.courseTime = courseTime;
        this.courseYear = courseYear;
    }
    /*public static String parseTimeToStart(registeredCourse course,String courseTime){
        String [] info = courseTime.split("()");
        int num =

    }*/
}
