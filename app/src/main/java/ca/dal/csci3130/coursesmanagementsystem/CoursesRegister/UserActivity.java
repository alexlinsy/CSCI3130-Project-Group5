package ca.dal.csci3130.coursesmanagementsystem.CoursesRegister;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
    public String courseTime = "";
    public registeredCourse currentCourses;
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final ListView coursesView = (ListView)findViewById(R.id.coursesList);

        Button backToMain = (Button)findViewById(R.id.backToMain);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        final DatabaseReference accountRef = database.getReference("User").child(currentUser.getUid()).child("Course");

        final ArrayList<userCourses> arrayList = new ArrayList<userCourses>();

        //Create Alert Dialog box
        final AlertDialog.Builder Alertbuilder = new AlertDialog.Builder(this);
        Alertbuilder.setCancelable(true);

        Alertbuilder.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });


        //Show courses' names
        accountRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    //String courses = ds.child("userCourseName").getValue().toString();
                    courseID = ds.child("courseID").getValue().toString();
                    major = ds.child("courseMajor").getValue().toString();
                    courseTime = ds.child("courseTime").getValue().toString();
                    study_year = ds.child("courseYear").getValue().toString();
                    //Create courseRegister Object to check the time conflict


                    //Create userCourses Object to add courses to listView
                    userCourses studentCourses = ds.getValue(userCourses.class);
                    arrayList.add(studentCourses);
                }

                currentCourses = new registeredCourse(courseID, major, courseTime, study_year);
                if(arrayList.size()>1) {
                    currentCourses.parseTime();
                    currentCourses.addBasedOnAvailableTime();
                }

                ListAdapter arrayAdapter = new ArrayAdapter<userCourses>(UserActivity.this, android.R.layout.simple_list_item_1, arrayList);

                coursesView.setAdapter(arrayAdapter);

                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                boolean dialogShown = settings.getBoolean("dialogShown", false);
                if(currentCourses.timeConflit()) {
                    Alertbuilder.setMessage("Your register courses have time conflict, please check the academic time table ");
                    AlertDialog alertBox = Alertbuilder.create();
                    if(!dialogShown) {
                        alertBox.show();
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putBoolean("dialogShown", true);
                        editor.commit();
                    }
                }


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
        Intent intent = new Intent(UserActivity.this, dropCoursesActivity.class);

        Bundle extras = new Bundle();
        extras.putString("EXTRA_COURSEID2", courseID);
        extras.putString("EXTRA_YEAR2", study_year);
        extras.putString("EXTRA_MAJOR2", major);
        extras.putString("EXTRA_userCourseID", courseRegisterID);
        intent.putExtras(extras);

        startActivity(intent);
    }
}