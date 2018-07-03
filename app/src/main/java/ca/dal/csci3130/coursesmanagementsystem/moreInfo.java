package ca.dal.csci3130.coursesmanagementsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class moreInfo extends AppCompatActivity {
    private static String courseInfo;
    private TextView detailInfo;//= (TextView)findViewById(R.id.courseIntro);
    //private static faculty course= new faculty();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        detailInfo = (TextView)findViewById(R.id.courseIntro);
        //course.setCourseIntro(c);
        detailInfo.setText(courseInfo);
        
    }


    public static void setCourseInfo(String cInfo){
        courseInfo = cInfo;
    }
}
