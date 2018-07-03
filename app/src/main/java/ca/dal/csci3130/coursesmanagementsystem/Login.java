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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
/**
 * Class that allow users to login their account
 */
public class Login extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignup;
    private Button buttonLogin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    /**
     *
     * @param savedInstanceState Define the input fields
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
     firebaseAuth=FirebaseAuth.getInstance();
     editTextEmail= (EditText) findViewById(R.id.editTextEmail);
     editTextPassword= (EditText) findViewById(R.id.editTextPassword);
     buttonLogin = (Button) findViewById(R.id.buttonLogin);
     textViewSignup = (TextView) findViewById(R.id.textViewSignup);
     progressDialog = new ProgressDialog(this);
     buttonLogin.setOnClickListener(this);
     textViewSignup.setOnClickListener(this);
     FirebaseUser user = firebaseAuth.getCurrentUser();
    }
    /**
     * The method that let user to login their account.
     */
    private void loginUser(){
         String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
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
        progressDialog.setMessage("Login...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful( )) {
                            //start the profile act

                           // startActivities(new Intent(getApplicationContext(),Profile_act.class));
                            Toast.makeText(Login.this, "Login Successfully\n Now you can edit your information", Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();
                            //finish();

                           // startActivity(new Intent(getApplicationContext(), Profile_act.class));
                            }
                        else{
                            Toast.makeText(Login.this,"Login Failed\nPassword or Account Name is incrrect",Toast.LENGTH_SHORT).show();
                        }
                        }
                });
    }
    /**
     *Execute the login method
     * @param v Once users click login button, then they can login their own account
     *          if view equals signup, then interface will return to the register page
     */
    public void onClick(View v) {
    if(v ==buttonLogin ){
        loginUser();

    }
    if(v == textViewSignup){
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }
    }

}
