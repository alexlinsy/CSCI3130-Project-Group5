package ca.dal.csci3130.coursesmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is created to show the timetable of the courseList
 * It has two spinner to choose both major and year
 * It can show the course name, the number of course seat, course time and professor
 */
public class academicTimeTable extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ListView list;//items displayed for based on the current spinner value.
    String Ta="";

    ArrayList<TA> tas = new ArrayList<>();
    Spinner dropdown_year;
    Spinner dropdown_major;
    //by default, the current table will display Year
    String year = "Year 1";

    //by default, the current table will display arts
    String major = "arts";

    //database reference current sets to faculty.
    DatabaseReference faculty = FirebaseDatabase.getInstance().getReference("faculty");

    //will create a list of course based on your faculty and year
    List<course> courseList;

    /**
     * Add two spinner to get the specific year and majot
     * get the specific course information from database
     * @param savedInstanceState create a timetable UI
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_time_table);


        //"Year" values in the dropdown button.
        dropdown_year =(Spinner) findViewById(R.id.spinner1);

        //the following methods will set adapters and activate dropdown event selector listener.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(academicTimeTable.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.spinner1));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        dropdown_year.setAdapter(adapter);
        dropdown_year.setOnItemSelectedListener(this);

        //same as above.
        dropdown_major = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(academicTimeTable.this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.spinner2));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        dropdown_major.setAdapter(adapter2);
        dropdown_major.setOnItemSelectedListener(this);

        //listView will be used to print course information for each course retrieved.
        list = (ListView)findViewById(R.id.listView);

        //default database reference sets to faculty/arts/year1
        faculty = FirebaseDatabase.getInstance().getReference("faculty").child("arts").child("year1");
        courseList = new ArrayList<course>();
    }

    /**
     * This method is used to get the ta information, when you click the button to check the ta information
     * It will get the ta information from the database
     */
    @Override
    public void onStart() {
        super.onStart();
        faculty.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                courseList.clear();
                for(final DataSnapshot courseSnapshot :dataSnapshot.getChildren()){
                    ca.dal.csci3130.coursesmanagementsystem.course fac = courseSnapshot.getValue(ca.dal.csci3130.coursesmanagementsystem.course.class);
                    //each course is a key.
                    fac.setUid(dataSnapshot.getKey());

                    //ta was set to an object in database，and uses the Iterable to get the ta information
                    Iterable<DataSnapshot> id = courseSnapshot.child("ta").getChildren();

                    // create Ta object key: name of the Ta ;value:Ta emails
                    while(id.iterator().hasNext()) {
                        DataSnapshot str = id.iterator().next();
                        String s = str.getKey();
                        String email = str.getValue().toString();
                        TA ta = new TA(s, email);
                        tas.add(ta);
                    }

                    //set Ta as a string to pass into course object.
                    for(int i = 0; i< tas.size();i++){
                        Ta +=tas.get(i).getName()+ " : "+tas.get(i).getEmail()+"\n";
                    }
                    fac.setTaInfo(Ta);

                    //clear the String and clear the TAs arrayList.
                    Ta ="";
                    tas.clear();

                    //add to courseList.
                    courseList.add(fac);
                }
                courseList adapter = new courseList(academicTimeTable.this,courseList);
                list.setAdapter(adapter);
                //click on one entries from the listView, jump to course Intro.
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //set the corresponding taInfo and course Intro based on the position of the course object.
                        course cour = courseList.get(position);
                        showDetailView(cour);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    /**
     * This method is used to get the specific course information that you clicked
     * @param parent get the last acticity
     * @param view  get the button information
     * @param position get the position you selected
     * @param id get the id you selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //spinner: corresponds to what year you are.
        if(parent.getItemAtPosition(position).toString().equals("Year 1"))
            year = "year1";
        else if(parent.getItemAtPosition(position).toString().equals("Year 2"))
            year = "year2";
        else if(parent.getItemAtPosition(position).toString().equals("Year 3"))
            year = "year3";
        else if(parent.getItemAtPosition(position).toString().equals("Year 4"))
            year = "year4";
        else;//do nothing.

        //spinner2: majors.
        if (parent.getItemAtPosition(position).toString().equals("arts"))
            major = "arts";
        else if(parent.getItemAtPosition(position).toString().equals("commerce"))
            major ="commerce";
        else if (parent.getItemAtPosition(position).toString().equals("computer Science"))
            major ="computerScience";
        else if(parent.getItemAtPosition(position).toString().equals("Science"))
            major = "science";
        else;
        //based on the desired information , redirect  the Firebase link.
        faculty = FirebaseDatabase.getInstance().getReference("faculty").child(major).child(year);
        faculty.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                courseList.clear();

                for(DataSnapshot courseSnapshot :dataSnapshot.getChildren()){
                    ca.dal.csci3130.coursesmanagementsystem.course fac = courseSnapshot.getValue(ca.dal.csci3130.coursesmanagementsystem.course.class);

                    //same code as the one in onStart.
                    fac.setUid(courseSnapshot.getKey());
                    Iterable<DataSnapshot> id = courseSnapshot.child("ta").getChildren();

                    while(id.iterator().hasNext()) {
                        DataSnapshot str = id.iterator().next();
                        String s = str.getKey();
                        String email = str.getValue().toString();
                        TA ta = new TA(s, email);
                        tas.add(ta);
                    }

                    for(int i = 0; i< tas.size();i++){
                        Ta +=tas.get(i).getName()+ " : "+tas.get(i).getEmail()+"\n";
                    }

                    fac.setTaInfo(Ta);
                    Ta ="";
                    tas.clear();
                    courseList.add(fac);
                }

                courseList adapter = new courseList(academicTimeTable.this,courseList);

                list.setAdapter(adapter);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        course cour = courseList.get(position);
                        showDetailView(cour);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    /**
     * This method is used to get the course introduction when you click the specific course
     * @param course Use the course object which store the course information
     */
    public void showDetailView(course course){

        /*this method will set the VALUES for course IntroUI and Ta email UI.
        TaInfo.setInfo(course.getTaInfo());
        moreInfo.setCourseInfo(course.getCourseIntro());
        Intent intent = new Intent(this,moreInfo.class);

        //JUMP to next UI.
        startActivity(intent); */
        Intent intent = new Intent(academicTimeTable.this, CourseRegisterActivity.class);
        String courseId = course.getUid();

        Bundle extras = new Bundle();
        extras.putString("EXTRA_COURSEID", courseId);
        extras.putString("EXTRA_YEAR", spinner1_default);
        extras.putString("EXTRA_MAJOR", spinner2_default);
        intent.putExtras(extras);

        startActivity(intent);

    }
}
