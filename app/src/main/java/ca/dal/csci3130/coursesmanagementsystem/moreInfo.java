package ca.dal.csci3130.coursesmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * This class is defined by showing more information about the class after clicking the course
 * It will include course introduction and ta's name and email
 */

public class moreInfo extends AppCompatActivity implements View.OnClickListener{
    private static String courseInfo;
    private Button taInfo;
    private TextView detailInfo;
    private  static String infomation;
    private static TextView text;

    /**
     * The new activity will show the course introduction and a button that can show the ta information if user click
     * @param savedInstanceState create an new activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        detailInfo = (TextView)findViewById(R.id.courseIntro);
        taInfo =(Button)findViewById(R.id.TaInfo);
        detailInfo.setText(courseInfo);

    }


    public static void setCourseInfo(String cInfo){
        courseInfo = cInfo;
    }


    public static void setTainfo(String tainfo){
        infomation = tainfo;
    }

    /**
     * If user click the button to search the course ta, then it will turn to the next page
     * @param v
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, TaInfo.class);
        startActivity(intent);
    }
    }

