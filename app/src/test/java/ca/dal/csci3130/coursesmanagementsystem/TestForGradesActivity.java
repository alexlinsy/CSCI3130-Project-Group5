package ca.dal.csci3130.coursesmanagementsystem;

import org.junit.Test;

import ca.dal.csci3130.coursesmanagementsystem.MyCourses.GradesActivity;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;



    /**
        * TestForGradesActivity.java is the junit test for GradesActivity Part
        * Create 10 tests for 10 grade marks according to 10 grade levels
    */
    public class TestForGradesActivity {

        @Test
        public void test1() {
            assertFalse(GradesActivity.convert(77).equals("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tA+"));
        }

        @Test
        public void test2() {
            assertTrue(GradesActivity.convert(86).equals("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tA"));
        }

        @Test
        public void test3() {
            assertFalse(GradesActivity.convert(99).equals("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tA-"));
        }

        @Test
        public void test4() {
            assertTrue(GradesActivity.convert(78).equals("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tB+"));
        }

        @Test
        public void test5() {
            assertFalse(GradesActivity.convert(99).equals("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tB"));
        }

        @Test
        public void test6() {
            assertTrue(GradesActivity.convert(70).equals("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tB-"));
        }

        @Test
        public void test7() {
            assertFalse(GradesActivity.convert(99).equals("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tC+"));
        }

        @Test
        public void test8() {
            assertTrue(GradesActivity.convert(62).equals("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tC"));
        }

        @Test
        public void test9() {
            assertFalse(GradesActivity.convert(99).equals("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tD"));
        }

        @Test
        public void test10() {
            assertTrue(GradesActivity.convert(33).equals("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tF"));
        }


    }


