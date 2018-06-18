package ca.dal.csci3130.coursesmanagementsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class  MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(View v) {
        if (v.getId() == R.id.BComputerScience) {
            Intent i = new Intent(MainActivity.this, ComputerScience.class);
            startActivity(i);
        }
        if (v.getId() == R.id.BArts) {
            Intent i = new Intent(MainActivity.this, Art.class);
            startActivity(i);
        }
        if (v.getId() == R.id.BCommerce) {
            Intent i = new Intent(MainActivity.this, commerce.class);
            startActivity(i);

        }
        if (v.getId() == R.id.BScience) {
            Intent i = new Intent(MainActivity.this, science.class);
            startActivity(i);
        }
    }
}
