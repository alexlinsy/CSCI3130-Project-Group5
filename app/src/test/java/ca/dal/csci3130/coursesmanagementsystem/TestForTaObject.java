package ca.dal.csci3130.coursesmanagementsystem;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestForTaObject {
    ArrayList<TA>TAs;
    public TestForTaObject(){
        TAs = new ArrayList<>();
        TA ta1 =new TA("lmx","lmx@dal.ca");
        TAs.add(ta1);
        TA ta2 = new TA("abc","abc@dal.ca");
        TAs.add(ta2);
    }
    @Test
    public void compareTaName(){
        assertEquals(TAs.get(0).getName(),"lmx");
        assertEquals(TAs.get(1).getName(),"abc");
    }
    @Test
    public void compareTaEmail(){
        assertEquals(TAs.get(0).getEmail(),"lmx@dal.ca");
        assertEquals(TAs.get(1).getEmail(),"abc@dal.ca");
    }

}
