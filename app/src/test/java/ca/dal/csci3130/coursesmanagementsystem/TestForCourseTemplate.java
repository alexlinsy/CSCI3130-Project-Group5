package ca.dal.csci3130.coursesmanagementsystem;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * TestForCourseTemplate.java is the junit test for courseRecommendation Part
 * Create 10 tests for this class
 */
public class TestForCourseTemplate {

    /**
     * create object template for MainActivity class
     */
    private MainActivity template = new MainActivity();

    /**
     * 10 tests when clicking buttons and checking the id of faculties and levels
     * if show the corret course name, return true, else return false
     */
    @Test
    public void test1(){
        courseRecommend.setId(R.id.BComputerScience );
        level.setId(R.id.B1000);
        assertFalse(template.cTamplate("-CSCI 2100.03: Communication Skills: Written and Oral"));
    }
    @Test
    public void test2(){
        courseRecommend.setId(R.id.BComputerScience );
        level.setId(R.id.B2000);
        assertTrue(!template.cTamplate("-CSCI 2201.03: Introduction to Information Security"));
    }
    @Test
    public void tes3(){
        courseRecommend.setId(R.id.BComputerScience );
        level.setId(R.id.B3000);
        assertFalse(template.cTamplate("-CSCI 2100.03: Communication Skills: Written and Oral"));
    }
    @Test
    public void test4(){
        courseRecommend.setId(R.id.BComputerScience );
        level.setId(R.id.B4000);
        assertTrue(!template.cTamplate("-CSCI 4163.03: Human Computer Interaction"));
    }
    @Test
    public void test5(){
        courseRecommend.setId(R.id.BArts );
        level.setId(R.id.B1000);
        assertFalse(template.cTamplate("-CSCI 2100.03: Communication Skills: Written and Oral"));
    }
    @Test
    public void test6(){
        courseRecommend.setId(R.id.BArts );
        level.setId(R.id.B3000);
        assertTrue(!template.cTamplate("-GERM 3550: Germany and the Environment"));
    }
    @Test
    public void test7(){
        courseRecommend.setId(R.id.BScience );
        level.setId(R.id.B1000);
        assertFalse(template.cTamplate("-CSCI 2100.03: Communication Skills: Written and Oral"));
    }
    @Test
    public void test8(){
        courseRecommend.setId(R.id.BScience );
        level.setId(R.id.B3000);
        assertTrue(!template.cTamplate("-STAT 3460.03: Intermediate Statistical Theory"));
    }
    @Test
    public void test9(){
        courseRecommend.setId(R.id.BCommerce );
        level.setId(R.id.B1000);
        assertFalse(template.cTamplate("-CSCI 2100.03: Communication Skills: Written and Oral"));
    }
    @Test
    public void test10(){
        courseRecommend.setId(R.id.BCommerce );
        level.setId(R.id.B3000);
        assertTrue(!template.cTamplate("-COMM 3511.03: Management Information Systems"));
    }

}
