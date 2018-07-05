package ca.dal.csci3130.coursesmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * This is the activity of Faculty part
 * including 4 levels: 1000+, 2000+, 3000+, and 4000+
 * and design in the form of buttons
 */
public class level extends courseRecommand {
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

        if (v.getId() == R.id.B1000) {
            Intent i = new Intent(level.this, Year1.class);
            startActivity(i);
        }
        if (v.getId() == R.id.B2000) {
            Intent i = new Intent(level.this, Year2.class);
            startActivity(i);
        }
        if (v.getId() == R.id.B3000) {
            Intent i = new Intent(level.this, Year3.class);
            startActivity(i);
        }
        if (v.getId() == R.id.B4000) {
           Intent i = new Intent(level.this, Year4.class);
           startActivity(i);
        }

    }

}
