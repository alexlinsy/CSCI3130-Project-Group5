package ca.dal.csci3130.coursesmanagementsystem;

import org.junit.Test;

import ca.dal.csci3130.coursesmanagementsystem.pureJava.registeredCourse;

import static org.junit.Assert.assertEquals;

public class TestForRegisteredCourse {

    registeredCourse registeredCourse = new registeredCourse("CSCI1100","CS","0935-1025(MWF)","year1");
    @Test
    public void getTime(){
        registeredCourse.parseTime();
        assertEquals("0935-1025(MWF)",registeredCourse.getCourseTime());
    }
    @Test
    public void getStartTime(){
        registeredCourse.parseTime();
        assertEquals("0935",registeredCourse.getStartTime());
    }
    @Test
    public void getEndTime(){
        registeredCourse.parseTime();
        assertEquals("1025",registeredCourse.getEndTime());
    }

    @Test
    public void getAvailableDaysOnEachWeek(){
        registeredCourse.parseTime();
        assertEquals('M',registeredCourse.getAvaliableTime()[0]);
        assertEquals('W',registeredCourse.getAvaliableTime()[1]);
        assertEquals('F',registeredCourse.getAvaliableTime()[2]);
    }
    @Test
    public void getMajor(){
        assertEquals("CS",registeredCourse.getCourseMajor());
    }
    @Test
    public void getYear(){
        assertEquals("year1",registeredCourse.getCourseYear());
    }
    @Test
    public void getCourseId(){
        assertEquals("CSCI1100",registeredCourse.getCourseID());
    }



}
