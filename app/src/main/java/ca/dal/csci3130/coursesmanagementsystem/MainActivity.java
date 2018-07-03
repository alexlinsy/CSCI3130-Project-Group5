package ca.dal.csci3130.coursesmanagementsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
    ListView list;
    //private FirebaseListAdapter<available_seats> firebaseAdapter;
    //Spinner spinner;
    TextView textView;
    Spinner dropdown ;
    Spinner dropdown2 ;
    String spinner1_default = "Year 1";
    String spinner2_default = "arts";
    DatabaseReference faculty = FirebaseDatabase.getInstance().getReference("faculty");

    List<faculty> facultyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textView = (TextView)findViewById(R.id.courseIntro) ;
        //FacultyData facultyData  = (FacultyData)getApplication();
        FirebaseDatabase fac = FirebaseDatabase.getInstance();
        //firebase.getReference().
        //list.setAdapter(firebaseAdapter);


        textView = (TextView)findViewById(R.id.courseIntro);
        //get the spinner from the xml.
        dropdown =(Spinner) findViewById(R.id.spinner1);
        //create a list of items for the spinner.
        //String[] items = new String[]{"1", "2", "three"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.spinner1));
        //set the spinners adapter to the previously created one.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        dropdown.setAdapter(adapter);
        //dropdown.setOnItemSelectedListener();
        dropdown.setOnItemSelectedListener(this);




        dropdown2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.spinner2));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        dropdown2.setAdapter(adapter2);
        dropdown2.setOnItemSelectedListener(this);





        list = (ListView)findViewById(R.id.listView);
        faculty = FirebaseDatabase.getInstance().getReference("faculty").child("arts").child("year1");
        //spinner = (Spinner)findViewById(R.id.spinner1);
        facultyList = new ArrayList<faculty>();




    }


    @Override
    protected void onStart(){
        super.onStart();



        faculty.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                facultyList.clear();
                for(DataSnapshot courseSnapshot :dataSnapshot.getChildren()){
                    ca.dal.csci3130.coursesmanagementsystem.faculty fac = courseSnapshot.getValue(ca.dal.csci3130.coursesmanagementsystem.faculty.class);
                    //faculty course = new faculty();
                    //course.setCourseName(fac.);
                    fac.setUid(dataSnapshot.getKey());
                    facultyList.add(fac);
                }
                //ArrayAdapter adapter = new ArrayAdapter()
                facultyList adapter = new facultyList(MainActivity.this,facultyList);
                list.setAdapter(adapter);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       /// faculty course = facultyList.
                        faculty course = facultyList.get(position);
                        showDetailView(course);
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //list.setAdapter( facultyList);

    }

    public void onClick(){

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getItemAtPosition(position).toString().equals("Year 1"))
                 spinner1_default = "year1";
            else if(parent.getItemAtPosition(position).toString().equals("Year 2"))
                spinner1_default = "year2";
            else if(parent.getItemAtPosition(position).toString().equals("Year 3"))
                spinner1_default = "year3";
            else if(parent.getItemAtPosition(position).toString().equals("Year 4"))
                spinner1_default = "year4";
            else{

        }
            if (parent.getItemAtPosition(position).toString().equals("arts"))
                 spinner2_default = "arts";
            else if(parent.getItemAtPosition(position).toString().equals("commerce"))
                spinner2_default ="commerce";
            else if (parent.getItemAtPosition(position).toString().equals("computer Science"))
                spinner2_default ="computerScience";
            else if(parent.getItemAtPosition(position).toString().equals("Science"))
                spinner2_default = "science";
            else;

        faculty = FirebaseDatabase.getInstance().getReference("faculty").child(spinner2_default).child(spinner1_default);
            faculty.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                facultyList.clear();
                for(DataSnapshot courseSnapshot :dataSnapshot.getChildren()){
                    ca.dal.csci3130.coursesmanagementsystem.faculty fac = courseSnapshot.getValue(ca.dal.csci3130.coursesmanagementsystem.faculty.class);
                    //faculty course = new faculty();
                    fac.setUid(courseSnapshot.getKey());
                    ///fac.setCourseIntro();
                    //fac.setCourseIntro(courseSnapshot.);
                    //course.setCourseName(fac.);
                    facultyList.add(fac);
                }
                //ArrayAdapter adapter = new ArrayAdapter()
                facultyList adapter = new facultyList(MainActivity.this,facultyList);
                list.setAdapter(adapter);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        /// faculty course = facultyList.
                        faculty course = facultyList.get(position);
                        showDetailView(course);
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        //Toast.makeText(getApplicationContext(),parent.getItemAtPosition(position).toString()+"selected",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void showDetailView(faculty course){
        //textView = (TextView)findViewById(R.id.courseIntro);
        //textView.setText(course.getCourseName());
        moreInfo.setCourseInfo(course.getCourseIntro());
        Intent intent = new Intent(this,moreInfo.class);
        //intent.putExtra("course", course);
        startActivity(intent);
    }
}
