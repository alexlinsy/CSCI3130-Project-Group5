package ca.dal.csci3130.coursesmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class level extends courseRecommand {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level);
    }

    public void onButtonClick(View v) {

        if (v.getId() == R.id.B1000) {
            Intent i = new Intent(level.this, Year1.class);
            startActivity(i);
        }
        if (v.getId() == R.id.B2000) {
            Intent i = new Intent(level.this, Year2.class);
            startActivity(i);
        }
        if (v.getId() == R.id.B3000) {
            Intent i = new Intent(level.this, Year3.class);
            startActivity(i);
        }
        if (v.getId() == R.id.B4000) {
           Intent i = new Intent(level.this, Year4.class);
           startActivity(i);
        }

    }

}
