package ca.dal.csci3130.coursesmanagementsystem.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ca.dal.csci3130.coursesmanagementsystem.DisplayCourses.AcademicTimeTableActivity;
import ca.dal.csci3130.coursesmanagementsystem.CourseRecommandation.CourseRecommendActivity;
import ca.dal.csci3130.coursesmanagementsystem.MyCourses.MyCourseActivity;
import ca.dal.csci3130.coursesmanagementsystem.R;

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
    }

    /**
     * Create other three activities, and user can click one of three button
     * @param view To get the button information when you click the button
     */
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.coursesButton:
                Intent timeTable = new Intent(this,AcademicTimeTableActivity.class);
                startActivity(timeTable);
                break;
            case R.id.recommandationButton:
                Intent courseRecommand = new Intent(this, CourseRecommendActivity.class);
                startActivity(courseRecommand);
                break;

            case R.id.myCoursesButton:
                Intent myCourse = new Intent(this, MyCourseActivity.class);
                startActivity(myCourse);
                break;
        }
    }
}