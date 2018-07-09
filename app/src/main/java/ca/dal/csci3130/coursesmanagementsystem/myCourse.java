package ca.dal.csci3130.coursesmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class myCourse extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawLayout;
    private ActionBarDrawerToggle mToggle;
    private TextView myInfo;
    private static String email="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_course);
        myInfo = (TextView)findViewById(R.id.textView);
        mDrawLayout = (DrawerLayout)findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawLayout,R.string.open,R.string.close);
        mDrawLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_account) {
            Toast.makeText(this, "This is my setthing", Toast.LENGTH_SHORT).show();
            String []info = email.split("@");
            myInfo.setText("Name : "+info[0]+"\n"+"Email : "+email);
            mDrawLayout.closeDrawers();


        }
        if(id == R.id.nav_settings) {
            Toast.makeText(this, "This is my setthing", Toast.LENGTH_SHORT).show();
            //setContentView(R.layout.setting);
            mDrawLayout.closeDrawers();


        }
        if (id == R.id.nav_logout) {
            //Toast.makeText(this, "This is logout", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

        if (id == R.id.my_grade) {
            //Toast.makeText(this, "This is logout", Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(this,MainActivity.class);
            // startActivity(intent);
            Toast.makeText(this, "This is my grade", Toast.LENGTH_SHORT).show();
        }

       /* if(id == R.id.add_drop){
            Intent  intent = new Intent(this,add_drop_course.class);
            startActivity(intent);
        }*/
        return false;
    }


}
