package ca.dal.csci3130.coursesmanagementsystem.MyCourses;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
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

import ca.dal.csci3130.coursesmanagementsystem.DisplayCourses.AcademicTimeTableActivity;
import ca.dal.csci3130.coursesmanagementsystem.R;

import static android.content.ContentValues.TAG;

public class GradesActivity extends MyCourseActivity_1 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grades);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("User").child(currentUser.getUid()).child("Grade");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> arrayList = new ArrayList<String>();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String item = ds.getKey();
                    Long grade = (Long)ds.getValue();
                    if(grade>=90)
                        item+="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tA+";
                    else if(grade>=85)
                        item+="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tA";
                    else if(grade>=80)
                        item+="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tA-";
                    else if(grade>=77)
                        item+="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tB+";
                    else if(grade>=73)
                        item+="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tB";
                    else if(grade>=70)
                        item+="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tB-";
                    else if(grade>=65)
                        item+="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tC+";
                    else if(grade>=60)
                        item+="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tC";
                    else if(grade>=55)
                        item+="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tC-";
                    else if(grade>=50)
                        item+="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tD";
                    else
                        item+="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tF";

                    arrayList.add(item);
                }
                ListAdapter arrayAdapter = new ArrayAdapter<String>(GradesActivity.this, android.R.layout.simple_list_item_1, arrayList);
                ListView lv=(ListView)findViewById(R.id.lv3);
                lv.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });



    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.B6) {
            Intent intent = new Intent(GradesActivity.this, AcademicTimeTableActivity.class);
            startActivity(intent);
        }
    }



}