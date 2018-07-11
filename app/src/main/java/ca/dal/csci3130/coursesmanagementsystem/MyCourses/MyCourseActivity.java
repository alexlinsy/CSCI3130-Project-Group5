package ca.dal.csci3130.coursesmanagementsystem.MyCourses;

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

import ca.dal.csci3130.coursesmanagementsystem.MainActivity;
import ca.dal.csci3130.coursesmanagementsystem.R;

/**
 * This class is defined by showing a navigation view, and it including some functions
 * In iteration 2, we just focus on building the logout function
 */
public class MyCourseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawLayout;
    private ActionBarDrawerToggle mToggle;
    private TextView myInfo;
    private static String email="";

    /**
     * The new activity will show a navigation view which has some buttons
     * @param savedInstanceState Create a new activity
     */
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

    /**
     * Check whether user clicked one of button in navigation view
     * @param item Item that user clicked
     * @return Return the true and false
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * If user clicked the button callled logout, and then it will return it to login activity
     * We also have some other functions and we would like to complete them in Iteration 3
     * @param item The item that user clicked
     * @return return false if nothing selected
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_account) {
            Toast.makeText(this, "This is my setting", Toast.LENGTH_SHORT).show();
            String []info = email.split("@");
            myInfo.setText("Name : "+info[0]+"\n"+"Email : "+email);
            mDrawLayout.closeDrawers();


        }
        if(id == R.id.nav_settings) {
            Toast.makeText(this, "This is my setthing", Toast.LENGTH_SHORT).show();
            mDrawLayout.closeDrawers();


        }
        if (id == R.id.nav_logout) {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

        if (id == R.id.my_grade) {
            Toast.makeText(this, "This is my grade", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


}
