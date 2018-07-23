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

    public char[] getAvaliableTime() {
        return avaliableTime;
    }

    public void setAvaliableTime(char[] avaliableTime) {
        this.avaliableTime = avaliableTime;
    }

    public String getEndTime() {

        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {

        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getCourseYear() {

        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    public String getCourseTime() {

        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseMajor() {

        return courseMajor;
    }

    public void setCourseMajor(String courseMajor) {
        this.courseMajor = courseMajor;
    }

    public String getCourseID() {

        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void parseTime(){
       String forParse = getCourseTime();
       String[]stage1Parse = forParse.split("\\(");
       //stage1Parse[0] now is 0935-1025
        //stage1Parse[1] is MWF);
        String [] stage2Parse1 = stage1Parse[0].split("-");
        //start time,end time
        setStartTime(stage2Parse1[0]);
        setEndTime(stage2Parse1[1]);
        String []stage2Parse2 = stage1Parse[1].split("\\)");
        int len = stage2Parse2[0].length();
        avaliableTime = new char[len];
        for(int i =0 ;i < len;i++){
            avaliableTime [i] = stage2Parse2[0].charAt(i);
        }
    }
}
