package ca.dal.csci3130.coursesmanagementsystem;

import org.junit.Test;

import ca.dal.csci3130.coursesmanagementsystem.CoursesRegister.userCourses;

import static org.junit.Assert.assertEquals;

public class userCoursesTest {

    userCourses usr = new userCourses();

    @Test
    public void getUserCourseName() {

        usr.setUserCourseName("user name");
        assertEquals("user name",usr.getUserCourseName());
    }


    @Test
    public void testcourseID(){
        usr.setCourseID("123456");
        assertEquals("123456",usr.getCourseID());
    }
    @Test
    public void testcourseYear(){
        usr.setCourseYear("2018");
        assertEquals("2018",usr.getCourseYear());
    }
    @Test
    public void testcourseMajor(){
        usr.setCourseMajor("Computer Science");
        assertEquals("Computer Science",usr.getCourseMajor());
    }
    @Test
    public void testcourseTime(){
        usr.setCourseTime("9:00-10:25");
        usr.getCourseTime();
    }
    @Test
    public void testuserCourseID(){
        usr.setUserCourseID("77889911");
        assertEquals("77889911",usr.getUserCourseID());
    }

}