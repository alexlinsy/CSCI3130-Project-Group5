package ca.dal.csci3130.coursesmanagementsystem;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * This is the activity of Faculty part
 * including 4 majors: Computer Science, Commerce, Science, Art
 * and design in the form of buttons
 */
public class courseRecommand extends AppCompatActivity {
    /**
     * @param id is used for which faulties' year1, year2,year3, and year4
     */
    private static int id;
    /**
     *
     * @param savedInstanceState Define the input fields
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faculty);
    }

    /**
     * we create 4 buttons of faculties and after clicking,
     * jump into course level pages
     */

    public void onButtonClick(View v) {
        if (v.getId() == R.id.BComputerScience || v.getId() == R.id.BArts || v.getId() ==  R.id.BCommerce|| v.getId() == R.id.BScience) {
            id = v.getId();
            Intent i = new Intent(courseRecommand.this, level.class);
            startActivity(i);
        }
    }
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        courseRecommand.id = id;
    }
}
