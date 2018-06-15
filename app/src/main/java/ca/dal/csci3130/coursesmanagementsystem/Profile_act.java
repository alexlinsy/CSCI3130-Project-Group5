package ca.dal.csci3130.coursesmanagementsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Profile_act extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private TextView textViewUseremail;
    private Button buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_act);

        textViewUseremail = (TextView) findViewById(R.id.textViewUseremail );
        buttonLogout = (Button) findViewById(R.id.button_Logout);

        buttonLogout.setOnClickListener(this);
    }
}
