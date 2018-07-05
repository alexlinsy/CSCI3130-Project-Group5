package ca.dal.csci3130.coursesmanagementsystem;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TaInfo extends AppCompatActivity {
    protected TextView taInfo;
    protected static String info ;
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

    public void open(View view) {
        Intent browserIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://learning.cs.dal.ca"));
        startActivity(browserIntent);
    }
}

