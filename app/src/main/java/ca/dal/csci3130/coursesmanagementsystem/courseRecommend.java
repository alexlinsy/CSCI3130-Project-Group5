package ca.dal.csci3130.coursesmanagementsystem;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**The courseRecommend.java
 * show the course template for 4 majors: Computer Science, Commerce, Science, Art
 * and design in the form of buttons
 */
public class courseRecommend extends AppCompatActivity {
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
        switch (v.getId()) {
            case R.id.BComputerScience :
                id = v.getId();
                Intent i = new Intent(courseRecommend.this, level.class);
                startActivity(i);
                break;
        }
        switch (v.getId()) {
            case R.id.BArts :
                id = v.getId();
                Intent i = new Intent(courseRecommend.this, level.class);
                startActivity(i);
                break;
        }
        switch (v.getId()) {
            case R.id.BScience :
                id = v.getId();
                Intent i = new Intent(courseRecommend.this, level.class);
                startActivity(i);
                break;
        }
        switch (v.getId()) {
            case R.id.BCommerce :
                id = v.getId();
                Intent i = new Intent(courseRecommend.this, level.class);
                startActivity(i);
                break;
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
        courseRecommend.id = id;
    }
}
