package ca.dal.csci3130.coursesmanagementsystem;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestForIterator {
    @Test
    public void iterator(){
        ArrayList<String> arrays = new ArrayList<String>();
        arrays.add("CSCI2100");
        arrays.add("CSCI2110");
        arrays.add("CSCI2121");
        arrays.add("CSCI2132");
        arrays.add("CSCI2141");
        java.util.Iterator<String> iter =  arrays.iterator();
        int i = 0;
        while(iter.hasNext()){
            String str = (String)iter.next();
            assertEquals(arrays.get(i),str);
            i++;
        }

    }
}
