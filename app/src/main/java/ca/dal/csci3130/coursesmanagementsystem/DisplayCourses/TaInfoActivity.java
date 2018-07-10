package ca.dal.csci3130.coursesmanagementsystem.DisplayCourses;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ca.dal.csci3130.coursesmanagementsystem.R;

/**
 * This class is defined by showing the ta information and get the data from database
 */

public class TaInfoActivity extends AppCompatActivity {
    protected TextView taInfo;
    protected static String info ;

    /**
     * Showing the ta name and email
     * @param savedInstanceState Create the new activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ta_info);
        taInfo = (TextView)findViewById(R.id.detailTa);
        taInfo.setText(info);
    }
    public static void setInfo(String infomation){
        info = infomation;
    }

    /**
     * Here we have a method to open the link to learning.cs.dal.ca, only if user click the button
     * @param view
     */
    public void open(View view) {
        Intent browserIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://learning.cs.dal.ca"));
        startActivity(browserIntent);
    }
}

