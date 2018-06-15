package ca.dal.csci3130.coursesmanagementsystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Login extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextemail;
    private EditText editTextPassowrd;
    private TextView textViewSign;
    private Button buttonLogin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
     firebaseAuth=FirebaseAuth.getInstance();

     if(firebaseAuth.getCurrentUser() !=null){
         //execute profile
         finish();
         // startActivities(new Intent(getApplicationContext(),Profile_act.class));
         startActivity(new Intent(getApplicationContext(), Profile_act.class));
     }
     editTextemail= (EditText) findViewById(R.id.editTextEmail);
     editTextPassowrd= (EditText) findViewById(R.id.editTextPassword);
     textViewSign = (TextView) findViewById(R.id.textViewSignin);
     buttonLogin = (Button) findViewById(R.id.buttonRegister);
        progressDialog = new ProgressDialog(this);
     buttonLogin.setOnClickListener(this);
     textViewSign.setOnClickListener(this);
    }

    private void loginUser(){
        String email = editTextemail.getText().toString().trim();
        String password = editTextPassowrd.getText().toString().trim();
        if(TextUtils.isEmpty( email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            return;
            //email is empty, stopping the function execution
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            return;
            //email is empty, stopping the function execution
        }
        //if the email and password are entered
        //showing the dialog
        progressDialog.setMessage("Registering User...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful( )) {
                            //start the profile act
                            finish();
                           // startActivities(new Intent(getApplicationContext(),Profile_act.class));
                            startActivity(new Intent(getApplicationContext(), Profile_act.class));
                            }
                    }
                });
    }
    @Override
    public void onClick(View v) {
    if(v ==buttonLogin ){
        loginUser();

    }
    if(v == textViewSign){
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }
    }

}
