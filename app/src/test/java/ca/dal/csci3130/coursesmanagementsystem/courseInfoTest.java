package ca.dal.csci3130.coursesmanagementsystem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class courseInfoTest {
    courseInfo course = new courseInfo();

    @Test
    public void getCourseIntro() {
        assertEquals("Csci3130",course.getCourseIntro());
    }

    @Test
    public void getCourseName() {
        assertEquals("Software Engineering",course.getCourseName());
    }

    @Test
    public void getLocation() {
        assertEquals("cheb",course.getLocation());
    }

    @Test
    public void getProfessor() {
        assertEquals("Junanio",course.getProfessor());
    }

    @Test
    public void getTime() {
        assertEquals("10:05-11:25",course.getTime());
    }


    @Test
    public void getImageUrl() {
    }
}