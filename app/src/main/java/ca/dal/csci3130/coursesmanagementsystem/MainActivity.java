package ca.dal.csci3130.coursesmanagementsystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.icu.util.Freezable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;
/**
 * Class that create a frame for people who register the course management system.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;
    private Button buttonRegister;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    /**
     * Define the input fields
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    progressDialog = new ProgressDialog(this);
    firebaseAuth = FirebaseAuth.getInstance();
    /*if(firebaseAuth.getCurrentUser() !=null){
        //execute profile
        finish();
       // startActivities(new Intent(getApplicationContext(),Profile_act.class));
        startActivity(new Intent(getApplicationContext(), Profile_act.class));
        }*/
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
    editTextEmail = (EditText)findViewById(R.id.editTextEmail);
    editTextPassword=(EditText)findViewById(R.id.editTextPassword);
    textViewSignin = (TextView)findViewById(R.id.textViewSignin);
    buttonRegister.setOnClickListener(this);
    textViewSignin.setOnClickListener(this);
    databaseReference = FirebaseDatabase.getInstance().getReference("User");
    FirebaseUser user = firebaseAuth.getCurrentUser();
    }
    /**
     * Method that authorized user to create a personal account, and validate the input password.
     */
    private void registerUser(){
        String email = editTextEmail.getText().toString().trim();
        String password= editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            return;
        //email is empty, stopping the function execution
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            return;
            //email is empty, stopping the function execution
        }
        if(validate(password)==true) {
            progressDialog.setMessage("Registering User...");
            progressDialog.show();
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                createUserStructure();
                                Toast.makeText(MainActivity.this, "Registered Successfully\nNow you can login", Toast.LENGTH_SHORT).show();
                                progressDialog.cancel();
                            } else {
                                Toast.makeText(MainActivity.this, "Registered failed, try again", Toast.LENGTH_SHORT).show();
                                progressDialog.cancel();
                            }
                        }
                    });
        }
        if(validate(password)==false){
            Toast.makeText(MainActivity.this, "Password invalid, try to input new password\nValid password must contain at least one uppercase and lowercase character, digit.\n And length cannot longer than 12.", Toast.LENGTH_SHORT).show();
            }
        }

    /**
     * Method that validate user's password
     * @param password This user's password.Should include at least one uppercase and lowercase character and digit, and length cannot longer than 12.
     * @return Return the result of validation (true or false)
     */
        public boolean validate(String password){
            Pattern uppercase = Pattern.compile("[A-Z]");//requirement1: include uppercase
            Pattern lowercase = Pattern.compile("[a-z]");//requirement2: include lowercase
            Pattern digitCase = Pattern.compile("[0-9]");//requirement3: include digits
            Pattern whitespace = Pattern.compile( "[ \\t\\n\\x0B\\f\\r]");//requirement4: whitespace is not allowed
            int length = password.length();//requirement5: check the length of password
            if(!uppercase.matcher(password).find()){
                return false;
            }
            if(!lowercase.matcher(password).find()){
                return false;
            }
            if(!digitCase.matcher(password).find()){

                return false;
            }
            if(whitespace.matcher(password).find()){

                return false;
            }
            if(length<12){
                return false;
            }
            else{
                return true;
            }
        }
    /**
     * Method that create a frame for user and it contains some default variables
     */
        private void createUserStructure(){
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String name = "Your Name:";
        String faculty ="Your Faculty";
        String id = user.getUid();
        String mailAddress = user.getEmail();
        String course = "Your Course";
        UserInformation userInformation = new UserInformation(id,name,faculty,mailAddress,course);
        databaseReference.child(id).setValue(userInformation);
    }
    @Override
    /**
     * Execute the registerUser method or turn to login page
     * @param view If user clicks register button, then Firebase will generate a default user frame
     *              If user clicks Signin text, then the interface will turn to login page
     */
    public void onClick(View view) {
     if(view == buttonRegister) {
         registerUser();
     }
    if(view ==textViewSignin){
         startActivity(new Intent(this, Login.class));
    }
    }
    }

