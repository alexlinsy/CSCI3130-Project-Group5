package ca.dal.csci3130.coursesmanagementsystem;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TestForParseTime {
    String courseTime = "0935-1025(MWF)";
    @Test
    public void split(){
        String[]delimter =courseTime.split("(/^a-zA-Z$/)");
        assertEquals(delimter.length,2);
    }
    @Test
    public void splitToGetStartAndEnd(){
        String[]delimter =courseTime.split("-");
        assertEquals(delimter.length,2);
        assertEquals(delimter[0],"0935");
        assertEquals(delimter[1],"1025(MWF)");
    }
}
