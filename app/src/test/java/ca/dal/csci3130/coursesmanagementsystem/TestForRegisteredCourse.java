package ca.dal.csci3130.coursesmanagementsystem;

import org.junit.Test;

import ca.dal.csci3130.coursesmanagementsystem.CoursesRegister.registeredCourse;

import static org.junit.Assert.assertEquals;


public class TestForRegisteredCourse {

    registeredCourse registeredCourse1 = new registeredCourse("CSCI1100","CS","0935-1025(MWF)","year1");
    registeredCourse registeredCourse4 = new registeredCourse("CSCI2141","CS","1335-1425(MWF)","year2");
    registeredCourse registeredCourse2 = new registeredCourse("CSCI2100","CS","1035-1125(MWF)","year2");
    registeredCourse registeredCourse3 = new registeredCourse("CSCI2132","CS","1235-1325(MWF)","year2");
    registeredCourse registeredCourse5 = new registeredCourse("CSCI3130", "CS","1005-1135(MWF)","Year3");
    @Test
    public void getTime(){
        registeredCourse1.parseTime();
        assertEquals("0935-1025(MWF)",registeredCourse1.getCourseTime());
    }
    @Test
    public void getStartTime(){
        registeredCourse1.parseTime();
        assertEquals("0935",registeredCourse1.getStartTime());
    }
    @Test
    public void getEndTime(){
        registeredCourse1.parseTime();
        assertEquals("1025",registeredCourse1.getEndTime());
    }

    @Test
    public void getAvailableDaysOnEachWeek(){
        registeredCourse1.parseTime();
        assertEquals('M',registeredCourse1.getAvaliableTime()[0]);
        assertEquals('W',registeredCourse1.getAvaliableTime()[1]);
        assertEquals('F',registeredCourse1.getAvaliableTime()[2]);
    }
    @Test
    public void getMajor(){
        assertEquals("CS",registeredCourse1.getCourseMajor());
    }
    @Test
    public void getYear(){
        assertEquals("year1",registeredCourse1.getCourseYear());
    }
    @Test
    public void getCourseId(){
        assertEquals("CSCI1100",registeredCourse1.getCourseID());
    }
    @Test
    public void onArrays(){
        addToArray();
        assertEquals(2,registeredCourse.getList().size());
    }
    @Test
    public void onInsertionSort(){
        addToArray();
        //registeredCourse
        registeredCourse.InsertionSort();
        assertEquals("CSCI1100",registeredCourse.getList().get(0).getCourseID());
        assertEquals("CSCI2100",registeredCourse.getList().get(1).getCourseID());
        assertEquals("CSCI2132",registeredCourse.getList().get(2).getCourseID());
        assertEquals("CSCI2141",registeredCourse.getList().get(3).getCourseID());
    }

    public void addToArray(){
        registeredCourse.addToList(registeredCourse4);
        registeredCourse1.parseTime();
        registeredCourse2.parseTime();
        registeredCourse3.parseTime();
        registeredCourse4.parseTime();
        registeredCourse.addToList(registeredCourse2);
        registeredCourse.addToList(registeredCourse1);
        registeredCourse.addToList(registeredCourse3);

    }

    @Test
    public void timeConflict() {
        registeredCourse1.parseTime();
        registeredCourse5.parseTime();
        registeredCourse1.addBasedOnAvailableTime();
        registeredCourse5.addBasedOnAvailableTime();
        assertEquals(true,registeredCourse1.timeConflit());
    }




}