package ca.dal.csci3130.coursesmanagementsystem;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**The courseRecommend.java
 * show the course template for 4 majors: Computer Science, Commerce, Science, Art
 * and design in the form of buttons
 */
public class courseRecommand extends AppCompatActivity {
    /**
     * @param id is used for which recognize 4 different majors
     * set it as static variable used for other class
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
     * jump into course levels page
     */

    public void onButtonClick(View v) {


        //when click button COMPUTER SCIENCE, SCIENCE, ART, COMMERCE jump to level.java
        if (v.getId() == R.id.BComputerScience || v.getId() == R.id.BArts || v.getId() ==  R.id.BCommerce|| v.getId() == R.id.BScience) {
            id = v.getId();
            Intent i = new Intent(courseRecommand.this, level.class);
            startActivity(i);
        }
    }

    /**
     * when other classes call this method
     * @return id value of different majors
     */
    public static int getId() {
        return id;
    }

    /**
     *
     * when other classes call this method
     * it will set value for the id
     * @param id is for faculties' id
     */

    public static void setId(int id) {
        courseRecommand.id = id;
    }
}
