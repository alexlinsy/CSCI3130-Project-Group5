package ca.dal.csci3130.coursesmanagementsystem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class userCoursesTest {



    @Test
    public void getUserCourseName() {
        userCourses usr = new userCourses();
        usr.setUserCourseName("user name");
        assertEquals("user name",usr.getUserCourseName());
    }
}