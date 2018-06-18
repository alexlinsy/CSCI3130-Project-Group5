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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;
    private Button buttonRegister;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
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
        progressDialog.setMessage("Registering User...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            //user is successfully reg and logged in
                           // Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            //progressDialog.cancel();
                            //execute profile
                            //startActivity(new Intent(getApplicationContext(), Login.class));
                            createUserStructure();
                            Toast.makeText(MainActivity.this, "Registered Successfully\nNow you can login", Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();
                        }else{
                            Toast.makeText(MainActivity.this, "Registered failed, try again", Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();
                        }
                    }
                });
    }

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

    public void onClick(View view) {
     if(view == buttonRegister) {
         registerUser();
     }
    if(view ==textViewSignin){
         startActivity(new Intent(this, Login.class));
    }


     }
    }

