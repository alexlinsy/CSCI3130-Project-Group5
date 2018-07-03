package ca.dal.csci3130.coursesmanagementsystem;

import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FacultyData extends Application {
    public DatabaseReference firebaseReference;
    public FirebaseDatabase  firebaseDBInstance;
}
