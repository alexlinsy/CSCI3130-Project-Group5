package ca.dal.csci3130.coursesmanagementsystem.Login;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import ca.dal.csci3130.coursesmanagementsystem.R;

/**
 *Class that help users reset their password
 */
public class ResetPassword extends AppCompatActivity {
    /**
     * User needs to provide his email address in order to reset password
     */
    private EditText passwordemail;
    private Button passwordbutton;
    private FirebaseAuth firebaseAuth;
    //Define the input variable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        passwordemail = (EditText)findViewById(R.id.passwordEmail);
        passwordbutton = (Button)findViewById(R.id.passwordButton);
        firebaseAuth = FirebaseAuth.getInstance();
        /**
         * If the user enters the valid email address, then the database will send a link to the user's email address.
         * User can follow the link to reset the password.
         */
        passwordbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             *
             */
            public void onClick(View v) {
                String resetEmail = passwordemail.getText().toString().trim();

                if(TextUtils.isEmpty(resetEmail)){
                    Toast.makeText(ResetPassword.this,"Please enter email",Toast.LENGTH_SHORT).show();
                }else{
                    firebaseAuth.sendPasswordResetEmail(resetEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(ResetPassword.this, "Password reset link has sent to your email.", Toast.LENGTH_SHORT).show();
                                finish();
                            }else{
                                Toast.makeText(ResetPassword.this,"Error! Invalid email address.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
