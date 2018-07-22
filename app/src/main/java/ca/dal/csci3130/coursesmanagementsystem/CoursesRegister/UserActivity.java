package ca.dal.csci3130.coursesmanagementsystem.CoursesRegister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import ca.dal.csci3130.coursesmanagementsystem.Login.IntermediaryActivity;
import ca.dal.csci3130.coursesmanagementsystem.R;

public class UserActivity extends AppCompatActivity {

    private static final String TAG = "UserActivity";

    public String courseID = "";
    public String study_year = "";
    public String major = "";
    public String courseRegisterID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final ListView coursesView = (ListView)findViewById(R.id.coursesList);

        Button backToMain = (Button)findViewById(R.id.backToMain);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        final DatabaseReference accountRef = database.getReference("User").child(currentUser.getUid()).child("Courses");

        final ArrayList<userCourses> arrayList = new ArrayList<userCourses>();

        //Show courses' names
        accountRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //userCourses studentCourses = dataSnapshot.getValue(userCourses.class);
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    //String courses = ds.child("userCourseName").getValue().toString();
                    userCourses studentCourses = ds.getValue(userCourses.class);
                    arrayList.add(studentCourses);
                }
                ListAdapter arrayAdapter = new ArrayAdapter<userCourses>(UserActivity.this, android.R.layout.simple_list_item_1, arrayList);

                coursesView.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }

        });

        coursesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                userCourses currentCourses = arrayList.get(position);
                //Set the value of course register page
                courseID = currentCourses.getCourseID();
                major = currentCourses.getCourseMajor();
                study_year = currentCourses.getCourseYear();
                courseRegisterID = currentCourses.getUserCourseID();

                jumpActivity(courseID, study_year, major, courseRegisterID);
            }
        });



        backToMain.setOnClickListener(new Button.OnClickListener() {
            public  void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, IntermediaryActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * This class is for transit activity back to register page and pass the value
     * @param courseID the ID of the course
     * @param study_year the year of major
     * @param major the major of the user
     */
    public void jumpActivity(String courseID, String study_year, String major, String courseRegisterID) {
        Intent intent = new Intent(UserActivity.this, CourseRegisterActivity.class);

        String message = "showButton";

        Bundle extras = new Bundle();
        extras.putString("EXTRA_COURSEID2", courseID);
        extras.putString("EXTRA_YEAR2", study_year);
        extras.putString("EXTRA_MAJOR2", major);
        extras.putString("EXTRA_MESSAGE", message);
        extras.putString("EXTRA_userCourseID", courseRegisterID);
        intent.putExtras(extras);

        startActivity(intent);
    }
}