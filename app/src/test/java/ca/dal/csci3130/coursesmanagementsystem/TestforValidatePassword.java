package ca.dal.csci3130.coursesmanagementsystem;

import org.junit.Test;

import ca.dal.csci3130.coursesmanagementsystem.MainActivity;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * This test is used to test for the password validation
 * The password must include at least one uppercase and lowercase character and digit, and length has to be no longer than 12
 */

public class TestforValidatePassword {

    private MainActivity valid = new MainActivity();
    @Test
    public void test1(){
        assertFalse(valid.validate("passwor3434343d"));
    }
    @Test
    public void test2(){
        assertFalse(valid.validate("qwertewewewewewe"));
    }
    @Test
    public void test3(){
        assertFalse(valid.validate("password"));
    }
    @Test
    public void test4(){
        assertFalse(valid.validate("qwe23w"));
    }
    @Test
    public void test5(){
        assertTrue(!valid.validate("Qfef233354535"));
    }
    @Test
    public void test6(){
        assertTrue(!valid.validate("ASdc1234993933333"));
    }
    @Test
    public void test7(){
        assertTrue(!valid.validate("Kiw92929292929292"));
    }
    @Test
    public void test8(){
        assertTrue(!valid.validate("Odmei1929283213213"));
    }
    @Test
    public void test9(){
        assertTrue(!valid.validate("Iwewqem22223121111"));
    }
    @Test
    public void test10(){
        assertTrue(!valid.validate("Oidk19191919191919222"));
    }
}

