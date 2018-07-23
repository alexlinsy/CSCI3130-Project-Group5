package ca.dal.csci3130.coursesmanagementsystem;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestForParseTime {
    String courseTime = "0935-1025(MWF)";
    String startTime ="";
    String endTime = "";
    ArrayList<Character>avilable =new ArrayList<Character>();
    String [] split = delimterLeftBracket(courseTime);
    String [] days = delimteRightBracket(split[1]);
    String buffer = days[0];
    int len = buffer.length();
    int i = 0;


    @Test
    public void startTimeAndEndTime(){
        String[] times = split[0].split("-");
        startTime = times[0];
        endTime = times[1];
        assertEquals("0935",startTime);
        assertEquals("1025",endTime);
    }
    @Test
    public void split(){
        String[]delimter =delimterLeftBracket(courseTime);
        assertEquals(2,delimter.length);
    }
    @Test
    public void onAddDays(){
        addDays();
        assertEquals('M',avilable.toArray()[0]);
        assertEquals('W',avilable.toArray()[1]);
        assertEquals('F',avilable.toArray()[2]);
    }
    public void addDays(){
        while(i < len ){
            avilable.add(buffer.charAt(i));
            i++;
        }
    }


    @Test
    public void TestOnArray(){
        assertEquals("0935-1025",split[0]);
        assertEquals("MWF)",split[1]);
    }
    @Test
    public void TestOnSecondSplit(){
        assertEquals(1,days.length);
        assertEquals("MWF",days[0]);
    }
    @Test
    public void splitToWeekDay(){
        String[]delimter =delimterLeftBracket(courseTime);
        //assertEquals("MWF",delimter[0].toString());
        assertEquals("MWF)",delimter[1].toString());
        String days = delimter[1].toString();
        assertEquals("MWF)",delimter[1].toString());
        String []deleteRight = delimteRightBracket(days);
        assertEquals("MWF",deleteRight[0]);
    }

    @Test
    public void splitToGetStartAndEnd(){
        String[]delimter =courseTime.split("-");
        assertEquals(delimter.length,2);
        assertEquals(delimter[0],"0935");
        assertEquals(delimter[1],"1025(MWF)");
    }

    public String[]delimterLeftBracket(String string){
        String[]delimter =string.split("\\(");
        return delimter;
    }

    public String[]delimteRightBracket(String string){
        String[]delimter =string.split("\\)");
        return delimter;
    }
}