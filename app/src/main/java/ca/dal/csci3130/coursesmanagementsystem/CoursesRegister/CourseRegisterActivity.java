package ca.dal.csci3130.coursesmanagementsystem.CoursesRegister;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ca.dal.csci3130.coursesmanagementsystem.DisplayCourses.AcademicTimeTableActivity;
import ca.dal.csci3130.coursesmanagementsystem.R;

public class CourseRegisterActivity extends AppCompatActivity {

    private static final String TAG = "CourseRegisterActivity";
    private String userCoursesName;
    public static Button dropButton;
    public static Button registerButton;
    public String courseID = "";
    public String study_year = "";
    public String major = "";
    private String courseId = "";
    private String courseTime = "";
    private Long seats;
    private int duration =  Toast.LENGTH_SHORT;
    private CharSequence text;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private DatabaseReference userRef;
    private DatabaseReference accountRef;
    private boolean exist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_register);

        registerButton = (Button)findViewById(R.id.registerButton1);
        dropButton = (Button)findViewById(R.id.dropButton);

        //Get current firebase user
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        Intent intent = getIntent();
        String message = intent.getExtras().getString("EXTRA_MESSAGE");


        database = FirebaseDatabase.getInstance();

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



        if (message == null) {

            dropButton.setVisibility(View.GONE);
            courseID = intent.getExtras().getString("EXTRA_COURSEID");
            study_year = intent.getExtras().getString("EXTRA_YEAR");
            major = intent.getExtras().getString("EXTRA_MAJOR");

        }else if(message.equals("showButton")) {
            dropButton.setVisibility(View.VISIBLE);
            courseID = intent.getExtras().getString("EXTRA_COURSEID2");
            study_year = intent.getExtras().getString("EXTRA_YEAR2");
            major = intent.getExtras().getString("EXTRA_MAJOR2");
            courseId = intent.getExtras().getString("EXTRA_userCourseID");

        } else {
            dropButton.setVisibility(View.GONE);
        }

        myRef = database.getReference("faculty").child(major).child(study_year).child(courseID);
        userRef = database.getReference("User").child(currentFirebaseUser.getUid());
        accountRef = database.getReference("User").child(currentFirebaseUser.getUid()).child("Courses");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Retrieve data from firebaase to textView and imageView
                courseInfo courseInfomation = dataSnapshot.getValue(courseInfo.class);
                TextView coursesIntro = (TextView)findViewById(R.id.courseIntro);
                ArrayList<String> taList = new ArrayList<String>();

                for (DataSnapshot ds : dataSnapshot.child("ta").getChildren()) {
                    taList.add(ds.getValue().toString());
                }

                String courseIntroduction = "Course Schedual: " + courseInfomation.getTime() + "\n\n" + courseInfomation.getCourseIntro() + "\n\n" + "TA: " + taList.toString();
                coursesIntro.setText(courseIntroduction);
                TextView courseName = (TextView)findViewById(R.id.courseDisplay);
                courseName.setText(courseInfomation.getCourseName());
                userCoursesName = courseInfomation.getCourseName();
                courseTime = courseInfomation.getTime();

                TextView courseProfessor = (TextView)findViewById(R.id.professorName);
                courseProfessor.setText(courseInfomation.getProfessor());

                ImageView professorAvatar = (ImageView)findViewById(R.id.professorAvatar);
                //Get image from Url
                Picasso.get().load(courseInfomation.getImageUrl()).resize(400,400).into(professorAvatar);

            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        /**
         * Button function for registering courses
         */
        registerButton.setOnClickListener(new Button.OnClickListener() {
            public  void onClick(View v) {
                buttonEffect(registerButton);
                //Change to the user page.
                final userCourses user = new userCourses();
                userRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("Courses")) {
                            accountRef.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                        String existCoursesName = ds.child("userCourseName").getValue().toString();
                                        //Check if the course is already registered by user.
                                        if (userCoursesName.equals(existCoursesName)) {
                                            exist = true;
                                            break;
                                        } else {
                                            exist = false;
                                        }
                                    }
                                    if(exist) {
                                        Alertbuilder.setMessage("Sorry, you registered this courses already");
                                        AlertDialog alertBox = Alertbuilder.create();
                                        alertBox.show();
                                    } else {
                                        /*
                                         *If the course is not registed by user,
                                         * Set up user's course property value,
                                         * register the course
                                         */
                                        registerCourse(user);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        } else {
                            registerCourse(user);
                        }

                    }

                        @Override
                        public void onCancelled (@NonNull DatabaseError databaseError){

                        }
                });

            }
        });
        /**
         * Button function for dropping courses
         */
        dropButton.setOnClickListener(new Button.OnClickListener() {
            public  void onClick(View v) {
                buttonEffect(dropButton);

                //When a course is dropped, avaliable seat increase by one
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        seats = (Long) dataSnapshot.child("seat").getValue();
                        if(seats < 100) {
                            seats = seats + 1;
                        }
                        myRef.child("seat").setValue(seats);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                userRef.child("Courses").child(courseId).removeValue();

                userRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child("Courses").child(courseId).exists()) {

                            //Show toast message if the drop function is failed
                            Context context = getApplicationContext();
                            text = "Your course is not successful dropped";
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {

                            //If course is successfully drop, change to userActivity class
                            Context context = getApplicationContext();
                            text = "Your course is successful dropped!";
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                            Intent intent = new Intent(CourseRegisterActivity.this, UserActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        initToolbar();

    }

    /**
     * Method for Going back to the courses list page when the back button on navigation bar is pressed.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, AcademicTimeTableActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }

    /**
     * Initial the navigation tool bar on top
     */
    private void initToolbar(){
        getSupportActionBar().setTitle("Courses Management System");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Add the back option on top navigation bar
     * @param item back option item
     * @return item value, go back to previous page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:{
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Method for registering user's courses
     * @param user the userCourses object
     */
    public void registerCourse (userCourses user) {
        user.setUserCourseName(userCoursesName);
        user.setCourseID(courseID);
        user.setCourseYear(study_year);
        user.setCourseMajor(major);
        user.setCourseTime(courseTime);
        courseId = userRef.push().getKey();
        user.setUserCourseID(courseId);
        userRef.child("Courses").child(courseId).setValue(user);

        Intent intent = new Intent(CourseRegisterActivity.this, UserActivity.class);

        //When a course is registered, the avaliable seats decreas by one
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seats = (Long) dataSnapshot.child("seat").getValue();
                if (seats > 0) {
                    seats = seats - 1;
                }
                myRef.child("seat").setValue(seats);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        startActivity(intent);
    }

    /**
     * Method to create the effect when click the image button
     * */
    public static void buttonEffect(View button){
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        if(v.getId() == R.id.registerButton1) {
                            v.getBackground().setColorFilter(Color.rgb(0, 31, 77), PorterDuff.Mode.SRC_ATOP);
                        } else {
                            v.getBackground().setColorFilter(Color.rgb(204, 0, 0), PorterDuff.Mode.SRC_ATOP);
                        }
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
    }
}
