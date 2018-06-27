package ca.dal.csci3130.coursesmanagementsystem;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class science extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cs);
    }

    public void onButtonClick(View v){
        if(v.getId() == R.id.B1000){
            Intent i = new Intent(science.this, S1000.class);
            startActivity(i);
        }
        if(v.getId() == R.id.B2000){
            Intent j = new Intent(science.this, S2000.class);
            startActivity(j);
        }
        if(v.getId() == R.id.B3000){
            Intent k = new Intent(science.this, S3000.class);
            startActivity(k);
        }
        if(v.getId() == R.id.B4000){
            Intent l = new Intent(science.this, S4000.class);
            startActivity(l);
        }

    }
}
