package ca.dal.csci3130.coursesmanagementsystem;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * This is the main activity of Faculty
 * including 4 majors: Computer Year2, Year2, Year3, Year4
 * and design in the form of buttons
 */
public class courseRecommand extends AppCompatActivity {

    private static int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faculty);
    }

    /**
     * we create 4 buttons of faculties and after clicking,
     * jump into course level page
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
