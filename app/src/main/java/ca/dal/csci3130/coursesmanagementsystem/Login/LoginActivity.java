package ca.dal.csci3130.coursesmanagementsystem.Login;

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

import ca.dal.csci3130.coursesmanagementsystem.MainActivity;
import ca.dal.csci3130.coursesmanagementsystem.R;

/**
 * Class that allow users to login their account
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
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
        if(user != null) {
            Intent intent = new Intent(this, IntermediaryActivity.class);
            startActivity(intent);
        }
    }
    /**
     * The method that let user to login their account.
     */
    private void loginUser(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        //If user does not input email, then tells him to enter email
        if(TextUtils.isEmpty( email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            return;
        }

        //If user does not input password, then tells him to enter password
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            return;
        }

        //if the email and password are entered
        //showing the dialog
        progressDialog.setMessage("LoginActivity...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful( )) {
                            Toast.makeText(LoginActivity.this, "LoginActivity Successfully\n Now you can edit your information", Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();
                            startActivity(new Intent(LoginActivity.this, IntermediaryActivity.class));
                            }
                        else{
                            Toast.makeText(LoginActivity.this,"LoginActivity Failed\nPassword or Account Name is incrrect",Toast.LENGTH_SHORT).show();
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

    /**
     * Method for Going back to the courses list page when the back button on navigation bar is pressed.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
