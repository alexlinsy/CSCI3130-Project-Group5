package ca.dal.csci3130.coursesmanagementsystem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class courseInfoTest {
    courseInfo course = new courseInfo();

    @Test
    public void getCourseIntro() {
        course.setCourseIntro("Csci3130");
        assertEquals("Csci3130",course.getCourseIntro());
    }

    @Test
    public void getCourseName() {
        course.setCourseName("Software Engineering");
        assertEquals("Software Engineering",course.getCourseName());
    }

    @Test
    public void getLocation() {
        course.setCourseLocation("cheb");
        assertEquals("cheb",course.getLocation());
    }

    @Test
    public void getProfessor() {
        course.setProfessor("Junanio");
        assertEquals("Junanio",course.getProfessor());
    }

    @Test
    public void getTime() {
        course.setTime("10:05-11:25");
        assertEquals("10:05-11:25",course.getTime());
    }


    @Test
    public void getImageUrl() {
    }
}