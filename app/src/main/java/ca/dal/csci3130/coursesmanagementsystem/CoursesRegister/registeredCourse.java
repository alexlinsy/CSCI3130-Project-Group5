package ca.dal.csci3130.coursesmanagementsystem.CoursesRegister;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *This class is designed to add some method to register the course from courselist
 */
public class registeredCourse implements Serializable{
    private String courseID;
    private String courseMajor;
    private String courseTime;
    private String courseYear;
    private String startTime;
    private String endTime;
    private char[] avaliableTime;
    private static  ArrayList<registeredCourse> registeredCourses = new ArrayList<>();
    private static ArrayList<registeredCourse>Monday = new ArrayList<>();
    private static ArrayList<registeredCourse>Tuesday = new ArrayList<>();
    private static ArrayList<registeredCourse>Wednesday = new ArrayList<>();
    private static ArrayList<registeredCourse>Thursday = new ArrayList<>();
    private static ArrayList<registeredCourse>Friday = new ArrayList<>();
    private boolean checkConflit = false;

    public registeredCourse(){

    }

    /**
     * constructor for class
     * @param courseID The course number(id)
     * @param courseMajor The major of the course
     * @param courseTime  The course time
     * @param courseYear  The course for specific year
     */
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

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseID() {

        return courseID;
    }

    public static ArrayList<registeredCourse>getMonday(){
        return Monday;
    }
    public static ArrayList<registeredCourse>getTuesday(){
        return Tuesday;
    }
    public static ArrayList<registeredCourse>getWednesday(){
        return Wednesday;
    }
    public static ArrayList<registeredCourse>getThursday(){
        return Thursday;
    }
    public static ArrayList<registeredCourse>getFriday(){
        return Friday;
    }

    /**
     * Get the course time and store in an array
     */
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

    /**
     * add the registered course to an arraylist
     * @param course for the specific course user registered
     */
    public static void addToList(registeredCourse course){
        registeredCourses.add(course);
    }



    public static ArrayList<registeredCourse> getList(){
        return registeredCourses;
    }

    /**
     * method of insert sort
     */
    public static  void InsertionSort(){
        int i, j;
        registeredCourse reg;
        for(i = 1 ; i<getList().size();i++){
            reg = getList().get(i);
            int startTimeOnReg = Integer.parseInt(getList().get(i).getStartTime());
            j = i - 1;

            while(j >= 0 &&Integer.parseInt(getList().get(j).getStartTime()) >startTimeOnReg ){
                getList().set(j+1, getList().get(j));
                j = j -1;
            }
            getList().set(j+1,reg);
        }
    }

    public static void insertionSort(ArrayList<registeredCourse>courses){
        int i, j;
        registeredCourse reg;
        for(i = 1 ; i<courses.size();i++){
            reg = courses.get(i);
            int startTimeOnReg = Integer.parseInt(courses.get(i).getStartTime());
            j = i - 1;

            while(j >= 0 &&Integer.parseInt(courses.get(j).getStartTime()) >startTimeOnReg ){
                courses.set(j+1, courses.get(j));
                j = j -1;
            }
            courses.set(j+1,reg);
        }
    }

    /**
     * Get the exact week day of the course
     */
    public void addBasedOnAvailableTime(){

        for(int i =0; i<getAvaliableTime().length;i++){
            if(getAvaliableTime()[i]=='M') {
                getMonday().add(this);
            }
            else if(getAvaliableTime()[i]=='T'){
                getTuesday().add(this);
            }
            else if(getAvaliableTime()[i]=='W'){
                getWednesday().add(this);
            }
            else if(getAvaliableTime()[i]=='R'){
                getThursday().add(this);
            }else if(getAvaliableTime()[i]=='F'){
                getFriday().add(this);
            }

        }
    }

    /**
     * Method for check time conflict
     * @return boolean value
     */
    public boolean timeConflit() {
        int currentCourseEndTime;
        int allCoursesStartTime;
        //Sort the list by time order
        insertionSort(getMonday());
        insertionSort(getTuesday());
        insertionSort(getWednesday());
        insertionSort(getThursday());
        insertionSort(getFriday());

        //Check if the course time is conflict in each arrayList crated by Date.
        if(getMonday().size()>1) {
            for (int i = 0; i < getMonday().size()-1; i++) {
                currentCourseEndTime = Integer.parseInt(getMonday().get(i).getEndTime());
                if(i<getMonday().size()-1) {
                    for (int j = i + 1; j < getMonday().size()-1; j++) {
                        allCoursesStartTime = Integer.parseInt(getMonday().get(j).getStartTime());
                        if (currentCourseEndTime > allCoursesStartTime) {
                            checkConflit = true;
                            break;
                        } else {
                            checkConflit = false;
                        }
                    }
                    if(checkConflit = true) {
                        break;
                    }
                    if(i > getMonday().size()-2) {
                        break;
                    }
                }
            }
        }

        if(getTuesday().size() > 1) {
            for (int i = 0; i < getTuesday().size()-1; i++) {
                currentCourseEndTime = Integer.parseInt(getTuesday().get(i).getEndTime());
                if(i<getTuesday().size()-1) {
                    for (int j = i + 1; j < getTuesday().size()-1; j++) {
                        allCoursesStartTime = Integer.parseInt(getTuesday().get(j).getStartTime());
                        if (currentCourseEndTime > allCoursesStartTime) {
                            checkConflit = true;
                            break;
                        } else {
                            checkConflit = false;
                        }
                    }
                    if(checkConflit = true) {
                        break;
                    }
                    if(i > getTuesday().size()-2) {
                        break;
                    }
                }
            }
        }

        if(getWednesday().size() > 1) {
            for (int i = 0; i < getWednesday().size()-1; i++) {
                currentCourseEndTime = Integer.parseInt(getWednesday().get(i).getEndTime());
                if(i<getWednesday().size()-1) {
                    for (int j = i + 1; j < getWednesday().size()-1; j++) {
                        allCoursesStartTime = Integer.parseInt(getWednesday().get(j).getStartTime());
                        if (currentCourseEndTime > allCoursesStartTime) {
                            checkConflit = true;
                            break;
                        } else {
                            checkConflit = false;
                        }
                    }
                    if(checkConflit = true) {
                        break;
                    }
                    if(i > getWednesday().size()-2) {
                        break;
                    }
                }

            }
        }

        if(getThursday().size() > 1) {
            for (int i = 0; i < getThursday().size()-1; i++) {
                currentCourseEndTime = Integer.parseInt(getThursday().get(i).getEndTime());
                if(i<getThursday().size()-1) {
                    for (int j = i + 1; j < getThursday().size()-1; j++) {
                        allCoursesStartTime = Integer.parseInt(getThursday().get(j).getStartTime());
                        if (currentCourseEndTime > allCoursesStartTime) {
                            checkConflit = true;
                            break;
                        } else {
                            checkConflit = false;
                        }
                    }
                    if(checkConflit = true) {
                        break;
                    }
                    if(i > getThursday().size()-2) {
                        break;
                    }
                }
            }
        }

        if(getFriday().size() > 1) {
            for (int i = 0; i < getFriday().size()-1; i++) {
                currentCourseEndTime = Integer.parseInt(getFriday().get(i).getEndTime());
                if(i<getFriday().size()-1) {
                    for (int j = i + 1; j < getFriday().size()-1; j++) {
                        allCoursesStartTime = Integer.parseInt(getFriday().get(j).getStartTime());
                        if (currentCourseEndTime > allCoursesStartTime) {
                            checkConflit = true;
                            break;
                        } else {
                            checkConflit = false;
                        }
                    }
                    if(checkConflit = true) {
                        break;
                    }
                    if(i > getFriday().size()-2) {
                        break;
                    }
                }
            }
        }
        return checkConflit;
    }
}
