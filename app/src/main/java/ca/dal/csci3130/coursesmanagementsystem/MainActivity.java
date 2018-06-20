package ca.dal.csci3130.coursesmanagementsystem;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private String userCoursesName;
    public static Button dropButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("faculty").child("computerScience").child("year2").child("CSCI2110");
        final DatabaseReference userRef = database.getReference("User").child("FIshkceAxKURrck2MP029a8cqPi2");

        final Button registerButton = (Button)findViewById(R.id.registerButton);
        dropButton = (Button)findViewById(R.id.dropButton);

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        if (message == null) {
            dropButton.setVisibility(View.GONE);
        }else if(message.equals("showButton")) {
            dropButton.setVisibility(View.VISIBLE);
        } else {
            dropButton.setVisibility(View.GONE);
        }

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Retrieve data from firebaase to textView and imageView
                courseInfo courseInfomation = dataSnapshot.getValue(courseInfo.class);
                TextView coursesIntro = (TextView)findViewById(R.id.courseIntro);

                String courseIntroduction = "Course Schedual: " + courseInfomation.getTime() + "\n\n" + courseInfomation.getCourseIntro();
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

        registerButton.setOnClickListener(new Button.OnClickListener() {
            public  void onClick(View v) {
                buttonEffect(registerButton);
                //Change to the user page.
                userCourses user = new userCourses();
                user.setUserCourseName(userCoursesName);
                String courseId = userRef.push().getKey();
                userRef.child("Courses").child(courseId).setValue(user);
                startActivity(new Intent(MainActivity.this, UserActivity.class));
               // dropButton.setVisibility(View.VISIBLE);
            }
        });

        dropButton.setOnClickListener(new Button.OnClickListener() {
            public  void onClick(View v) {
                buttonEffect(dropButton);
                userRef.child("Courses").removeValue();
            }
        });


    }

    public static void buttonEffect(View button){
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        if(v.getId() == R.id.registerButton) {
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
