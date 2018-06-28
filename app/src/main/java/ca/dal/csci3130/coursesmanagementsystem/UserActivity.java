package ca.dal.csci3130.coursesmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class UserActivity extends AppCompatActivity {

    private static final String TAG = "UserActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        final ListView coursesView = (ListView)findViewById(R.id.coursesList);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference accountRef = database.getReference("User").child("FIshkceAxKURrck2MP029a8cqPi2").child("Courses");
        accountRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> arrayList = new ArrayList<String>();

                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String courses = ds.child("userCourseName").getValue().toString();
                    arrayList.add(courses);
                }
                ListAdapter arrayAdapter = new ArrayAdapter<String>(UserActivity.this, android.R.layout.simple_list_item_1, arrayList);
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

                Intent intent = new Intent(UserActivity.this, CourseRegisterActivity.class);
                String message = "showButton";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);

            }
        });

    }
}
