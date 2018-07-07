package ca.dal.csci3130.coursesmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * This class is defined to get the new activity after you click login button
 * It will give you 3 button to choose
 * including check the courselist, course recommandation, and information about my courses
 */
public class IntermediaryActivity extends AppCompatActivity implements View.OnClickListener {


    /**
     * Create three button to choose
     * @param savedInstanceState use to define a new activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediary);

        Button timeTable = (Button)findViewById(R.id.coursesButton);
        Button recommendation = (Button)findViewById(R.id.recommandationButton);
        Button myCourseButton = (Button) findViewById(R.id.myCoursesButton);
    }

    /**
     * Create other three activities, and user can click one of three button
     * @param view To get the button information when you click the button
     */
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.coursesButton:
                Intent timeTable = new Intent(this,academicTimeTable.class);
                startActivity(timeTable);
                break;
            case R.id.recommandationButton:
                Intent courseRecommand = new Intent(this, ca.dal.csci3130.coursesmanagementsystem.courseRecommand.class);
                startActivity(courseRecommand);
                break;
           /* case R.id.myCoursesButton:
                Intent myCourse = new Intent(this, ca.dal.csci3130.coursesmanagementsystem.myCourse.class);
                startActivity(myCourse);
                break;*/
        }
    }
}
