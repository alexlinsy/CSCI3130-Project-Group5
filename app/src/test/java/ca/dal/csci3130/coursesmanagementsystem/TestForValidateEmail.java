package ca.dal.csci3130.coursesmanagementsystem;



import org.junit.Test;

import ca.dal.csci3130.coursesmanagementsystem.Login.ResetPassword;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
public class TestForValidateEmail {
    private ResetPassword valid = new ResetPassword();
    @Test
    public void test1(){
        assertFalse(valid.validate("ddwqd@123"));

    }
    @Test
    public void test2(){
        assertFalse(valid.validate("ewqewqe@122"));

    }
    @Test
    public void test3(){
        assertTrue(valid.validate("eu3134@dal.ca"));

    }
    @Test
    public void test4(){
        assertTrue(valid.validate("938rke@gmaail.com"));

    }
    @Test
    public void test5(){
        assertTrue(valid.validate("iwqew12@yahoo.com"));

    }


}
