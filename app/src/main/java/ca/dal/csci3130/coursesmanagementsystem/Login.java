package ca.dal.csci3130.coursesmanagementsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextemail;
    private EditText editTextPassowrd;
    private TextView textViewSign;
    private Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
     editTextemail= (EditText) findViewById(R.id.editTextEmail);
     editTextPassowrd= (EditText) findViewById(R.id.editTextPassword);
     textViewSign = (TextView) findViewById(R.id.textViewSignin);
     buttonLogin = (Button) findViewById(R.id.buttonRegister);

     buttonLogin.setOnClickListener(this);
     textViewSign.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    if(view == )
    }
}
