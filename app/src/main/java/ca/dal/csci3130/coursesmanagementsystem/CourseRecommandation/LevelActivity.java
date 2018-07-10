package ca.dal.csci3130.coursesmanagementsystem.CourseRecommandation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ca.dal.csci3130.coursesmanagementsystem.R;

/**
 * show the course template for 4 levels: 1000+, 2000+, 3000+, 4000+
 * and design in the form of buttons
 */
public class LevelActivity extends CourseRecommendActivity {

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
     * jump into course pages corresponding with each LevelActivity of faculty
     * to show all the suggested courses we need
     * @param v  get the button user clicked
     */
    public void onButtonClick(View v) {

        //when click button 1000+ jump to Year1Activity.java
        switch (v.getId()) {
            case R.id.B1000:
            Intent i = new Intent(LevelActivity.this, Year1Activity.class);
            startActivity(i);
            break;
        }

        //when click button 2000+ jump to Year2Activity.java
        switch (v.getId()) {
            case R.id.B2000:
            Intent i = new Intent(LevelActivity.this, Year2Activity.class);
            startActivity(i);
            break;
        }

        //when click button 3000+ jump to Year3Activity.java
        switch (v.getId()) {
            case R.id.B3000:
                Intent i = new Intent(LevelActivity.this, Year3Activity.class);
                startActivity(i);
                break;
        }

        //when click button 4000+ jump to Year4Activity.java
        switch (v.getId()) {
            case R.id.B4000:
                Intent i = new Intent(LevelActivity.this, Year4Activity.class);
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
