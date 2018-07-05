package ca.dal.csci3130.coursesmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class moreInfo extends AppCompatActivity implements View.OnClickListener{
    private static String courseInfo;
    private Button taInfo;
    private TextView detailInfo;
    private  static String infomation;
    private static TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        detailInfo = (TextView)findViewById(R.id.courseIntro);
        taInfo =(Button)findViewById(R.id.TaInfo);
        //text = (TextView)findViewById(R.id.TaInfo)
        //course.setCourseIntro(c);
        detailInfo.setText(courseInfo);

    }


    public static void setCourseInfo(String cInfo){
        courseInfo = cInfo;
    }


    public static void setTainfo(String tainfo){
        infomation = tainfo;
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, TaInfo.class);
        startActivity(intent);
    }
    }

