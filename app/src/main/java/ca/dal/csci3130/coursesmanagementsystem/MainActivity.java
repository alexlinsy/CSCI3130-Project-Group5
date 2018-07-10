package ca.dal.csci3130.coursesmanagementsystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        //If user does not input email, then tells him to enter email
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            return;
            }
        //If user does not input password, then tells him to enter password
            if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            return;
        }
        //If password is satisfied rule, then it will register and store the information in database
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
                            }
                            //if the account has already registered, then it cannot register again.
                            else {
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
     * This boolean method use for junit test
     * with the specific faculties' button id and level's button id
     * it should show corresponding course
     * @param a is a string of course name
     */

    public boolean cTamplate(String a){
        //if it's Computer Science's 1000-level course, it will return true when show these courses
        if(courseRecommend.getId()==R.id.BComputerScience && level.getId() == R.id.B1000){
            if(a.equals("-CSCI 1100.03: Computer Year2"))
                return true;
            else if(a.equals("-MGMT 1000.03: Managing Organizational Issues I"))
                return true;
            else if(a.equals("-INFX 1615.03: Concepts in Computing"))
                return true;
            else if(a.equals("-Two 1000 Level Free Electives"))
                return true;
            else if(a.equals("-CSCI 1101.03: Computer Year2 II"))
                return true;
            else if(a.equals("-MGMT 1001.03: Managing Organizational Issues II"))
                return true;
            else if(a.equals("-INFX 1616.03: Applications of Computing"))
                return true;
            else if(a.equals("-Two 1000 Level Free Electives"))
                return true;
        }
        //if it's Computer Science's 2000-level course, it will return true when show these courses
        if(courseRecommend.getId()==R.id.BComputerScience && level.getId() == R.id.B2000){
            if(a.equals("-CSCI 2100.03: Communication Skills: Written and Oral"))
                return true;
            else if(a.equals("-CSCI 2110.03: Computer Year2 III"))
                return true;
            else if(a.equals("-CSCI 2132.03: Software Development"))
                return true;
            else if(a.equals("-CSCI 2141.03: Introduction to Database Systems"))
                return true;
            else if(a.equals("-MGMT 2303.03: People, Work, and Organizations: Micro Organizational Behaviour"))
                return true;
            else if(a.equals("-CSCI 2201.03: Introduction to Information Security"))
                return true;
            else if(a.equals("-CSCI 2170.03: Introduction to Server Side Scripting"))
                return true;
            else if(a.equals("-CSCI 2690.03: Introduction to Software Projects"))
                return true;
            else if(a.equals("-CSCI 2691.03: Introductory Project"))
                return true;
            else if(a.equals("-One 1000 Level Free Electives"))
                return true;
        }
        //if it's Computer Science's 3000-level course, it will return true when show these courses
        if(courseRecommend.getId()==R.id.BComputerScience && level.getId() == R.id.B3000){
            if(a.equals("-CSCI 3101.03: Social, Ethical, and Professional Issues in Computer Year2"))
                return true;
            else if(a.equals("-CSCI 3160.03: Designing User Interfaces"))
                return true;
            else if(a.equals("CSCI 3172.03: Web-Centric Computing"))
                return true;
            else if(a.equals("-CSCI 3691.03: Intermediate Project"))
                return true;
            else if(a.equals("-One 2000 Level Free Elective"))
                return true;
            else if(a.equals("-CSCI 3171.03: Network Computing"))
                return true;
            else if(a.equals("-CSCI 3130.03: Introduction to Software Engineering"))
                return true;
            else if(a.equals("-MGMT 3511.03: Management Information Systems"))
                return true;
            else if(a.equals("-Two 2000 Level Free Electives"))
                return true;
        }
        //if it's Computer Science's 4000-level course, it will return true when show these courses
        if(courseRecommend.getId()==R.id.BComputerScience && level.getId() == R.id.B4000){
            if(a.equals("-CSCI 4163.03: Human Computer Interaction"))
                return true;
            else if(a.equals("-CSCI 4140.03: Advanced Database Systems"))
                return true;
            else if(a.equals("-Three 2000 Level Free Electives"))
                return true;
            else if(a.equals("-CSCI 4691.03: Advanced Project"))
                return true;
            else if(a.equals("-Two 2000 Level Free Electives"))
                return true;
            else if(a.equals("-MGMT 3603.03: Beyond Google"))
                return true;
        }
        //if it's Art's 1000-level course, it will return true when show these courses
        if(courseRecommend.getId()==R.id.BArts && level.getId() == R.id.B1000){
            if(a.equals("-GERM 1010 X: German for Beginners"))
                return true;
            else if(a.equals("-HIST 1510: History of the Future"))
                return true;
            else if(a.equals("-GERM 1010 Y: German for Beginners"))
                return true;
            else if(a.equals("-THEA 1051: Intro to Thea Org and Stgcrft"))
                return true;
            else if(a.equals("-ECON 1102.03: Principles of Macroeconomics"))
                return true;
        }
        //if it's Art's 3000-level course, it will return true when show these courses
        if(courseRecommend.getId()==R.id.BArts && level.getId() == R.id.B3000){
            if(a.equals("-GERM 3550: Germany and the Environment"))
                return true;
            else if(a.equals("-HIST3045: The French Revolution"))
                return true;
            else if(a.equals("-THEA 3314: Shakespeare on Film"))
                return true;
        }
        //if it's Science's 1000-level course, it will return true when show these courses
        if(courseRecommend.getId()==R.id.BScience && level.getId() == R.id.B1000){
            if(a.equals("-MATH 1000.03: Differential and Integral Calculus I"))
                return true;
            else if(a.equals("-STAT 1060.03: Introductory Statistics for Year2 and Health Sciences"))
                return true;
            else if(a.equals("-One Writing Requirement"))
                return true;
            else if(a.equals("-One Free Elective"))
                return true;
            else if(a.equals("-MATH 1010.03: Differential and Integral Calculus II"))
                return true;
            else if(a.equals("-CSCI 1101.03: Computer Year2 II"))
                return true;
            else if(a.equals("-One Humanity Elective"))
                return true;
        }
        //if it's Science's 3000-level course, it will return true when show these courses
        if(courseRecommend.getId()==R.id.BScience && level.getId() == R.id.B3000){
            if(a.equals("-STAT 3340.03: Regression and Analysis of Variance"))
                return true;
            else if(a.equals("-STAT 3360.03: Probability"))
                return true;
            else if(a.equals("-STAT 3345.03: Environmental Risk Assessment"))
                return true;
            else if(a.equals("-STAT 3380.03: Sample Survey Methods"))
                return true;
            else if(a.equals("-STAT 3720.03: Life Contingencies I"))
                return true;
            else if(a.equals("-STAT 3460.03: Intermediate Statistical Theory"))
                return true;
            else if(a.equals("-STAT 3350.03: Design of Experiments*"))
                return true;
            else if(a.equals("-STAT 3703.03: Actuarial Models I"))
                return true;
            else if(a.equals("-STAT 3750.03: Credibility Theory"))
                return true;
            else if(a.equals("-One Humanity Elective"))
                return true;
        }
        //if it's Commerce's 1000-level course, it will return true when show these courses
        if(courseRecommend.getId()==R.id.BCommerce && level.getId() == R.id.B1000){
            if(a.equals("-COMM 1010.03: Business in a Global Context"))
                return true;
            else if(a.equals("-COMM 1101.03: Financial Accounting"))
                return true;
            else if(a.equals("-INFX 1615.03: Concepts in Computing"))
                return true;
            else if(a.equals("-COMM 1502.03: Core Business Applications"))
                return true;
            else if(a.equals("-One non-commerce elective"))
                return true;
            else if(a.equals("-COMM 1710.03: Business Communications I"))
                return true;
            else if(a.equals("-COMM 1102.03: Managerial Accounting"))
                return true;
            else if(a.equals("-ECON 1102.03: Principles of Macroeconomics"))
                return true;
            else if(a.equals("-MATH 1115.03: Mathematics for Year3"))
                return true;
        }
        //if it's Commerce's 3000-level course, it will return true when show these courses
        if(courseRecommend.getId()==R.id.BCommerce && level.getId() == R.id.B3000){
            if(a.equals("-COMM 3111.03: Intermediate Financial Accounting II"))
                return true;
            else if(a.equals("-COMM 3114.03: External Auditing"))
                return true;
            else if(a.equals("-Two non-commerce electives"))
                return true;
            else if(a.equals("-COMM 3501.03: Operations Management"))
                return true;
            else if(a.equals("-COMM 3511.03: Management Information Systems"))
                return true;
            else if(a.equals("-COMM 3105.03: Intermediate Financial Accounting I"))
                return true;
            else if(a.equals("-COMM 3116.03: Cost Management"))
                return true;
            else if(a.equals("-One Free Elective"))
                return true;
        }
        //the course name dose not correspond with current faculty button id and level button id will return false
        return false;
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
            if(length > 12){
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

