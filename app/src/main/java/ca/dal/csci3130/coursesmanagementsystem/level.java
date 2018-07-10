package ca.dal.csci3130.coursesmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**The level.java
 * show the course template for 4 levels: 1000+, 2000+, 3000+, 4000+
 * and design in the form of buttons
 */
public class level extends courseRecommend {

    /**
     * @param id is used for which recognize 4 different levels
     * set it as static variable used for other class
     */
    private static int id;
    /**
     *
     * @param savedInstanceState Define the input fields
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level);
    }
    /**
     * we create 4 buttons of levels and after clicking,
     * jump into course pages corresponding with each level of faculty
     * to show all the suggested courses we need
     */
    public void onButtonClick(View v) {

        //when click button 1000+ jump to Year1.java
        switch (v.getId()) {
            case R.id.B1000:
            Intent i = new Intent(level.this, Year1.class);
            startActivity(i);
            break;
        }

        //when click button 2000+ jump to Year2.java
        switch (v.getId()) {
            case R.id.B2000:
            Intent i = new Intent(level.this, Year2.class);
            startActivity(i);
            break;
        }

        //when click button 3000+ jump to Year3.java
        switch (v.getId()) {
            case R.id.B3000:
                Intent i = new Intent(level.this, Year3.class);
                startActivity(i);
                break;
        }

        //when click button 4000+ jump to Year4.java
        switch (v.getId()) {
            case R.id.B4000:
                Intent i = new Intent(level.this, Year4.class);
                startActivity(i);
                break;
        }

    }

    /**
     * when other classes call this method
     * @return id value of different levels
     */
    public static int getId() {
        return id;
    }

}
