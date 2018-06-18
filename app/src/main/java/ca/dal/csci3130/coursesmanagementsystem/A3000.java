package ca.dal.csci3130.coursesmanagementsystem;

import android.os.Bundle;
import android.util.Log;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import ca.dal.csci3130.coursesmanagementsystem.Art;
import ca.dal.csci3130.coursesmanagementsystem.CS1000;
import ca.dal.csci3130.coursesmanagementsystem.ComputerScience;
import ca.dal.csci3130.coursesmanagementsystem.R;

import static android.content.ContentValues.TAG;


public class A3000 extends Art {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cs1xxx);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("faculty").child("arts").child("year3");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> arrayList = new ArrayList<String>();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String item = ds.getKey();
                    arrayList.add(item);
                }
                ListAdapter arrayAdapter = new ArrayAdapter<String>(ca.dal.csci3130.coursesmanagementsystem.A3000.this, android.R.layout.simple_list_item_1, arrayList);
                ListView lv=(ListView)findViewById(R.id.lv);
                lv.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
    }
}

