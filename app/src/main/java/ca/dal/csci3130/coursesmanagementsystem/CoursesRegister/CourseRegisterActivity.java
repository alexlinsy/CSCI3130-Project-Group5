package ca.dal.csci3130.coursesmanagementsystem.CoursesRegister;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    private Long seats;
    private int duration =  Toast.LENGTH_SHORT;
    private CharSequence text;
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


        final FirebaseDatabase database = FirebaseDatabase.getInstance();


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
        } else {
            dropButton.setVisibility(View.GONE);
        }

        final DatabaseReference myRef = database.getReference("faculty").child(major).child(study_year).child(courseID);
        final DatabaseReference userRef = database.getReference("User").child(currentFirebaseUser.getUid());

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

                String courseIntroduction = "Course Schedual: " + courseInfomation.getTime() + "\n\n" + courseInfomation.getCourseIntro() + "\n\n" + "TA: " + taList.toString() + "\n\n" + courseInfomation.getProfessorEmail();
                coursesIntro.setText(courseIntroduction);
                TextView courseName = (TextView)findViewById(R.id.courseDisplay);
                courseName.setText(courseInfomation.getCourseName());
                userCoursesName = courseInfomation.getCourseName();

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
                userCourses user = new userCourses();
                user.setUserCourseName(userCoursesName);
                user.setCourseID(courseID);
                user.setCourseYear(study_year);
                user.setCourseMajor(major);
                courseId = userRef.push().getKey();
                userRef.child("Courses").child(courseId).setValue(user);
                Intent intent = new Intent(CourseRegisterActivity.this, UserActivity.class);
                intent.putExtra("COURSE_ID", courseId);

                //When a course is registered, the avaliable seats decreas by one
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        seats = (Long) dataSnapshot.child("seat").getValue();
                        if(seats > 0) {
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
                        if(dataSnapshot.child("Courses").exists()) {
                            //Show toast message if the drop function is failed
                            Context context = getApplicationContext();
                            text = "Your course is not successful dropped";
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {

                            Context context = getApplicationContext();
                            text = "Your course is successful dropped!";
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                            Intent intent = new Intent(CourseRegisterActivity.this, UserActivity.class);
                            intent.putExtra("COURSE_ID", courseId);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

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
