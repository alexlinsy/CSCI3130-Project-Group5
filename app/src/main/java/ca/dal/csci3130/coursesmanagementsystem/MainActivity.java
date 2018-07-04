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

//This will function as a timetable to display course info based on year and your major
//Note: major is stored as "faculty" table in firebase database.
public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
    ListView list;//not sure what this will be used for, need refactoring later on.
    //private FirebaseListAdapter<available_seats> firebaseAdapter;
    //Spinner spinner;
    TextView textView;
    String Ta="";
    //TextView taInfo;
    ArrayList<Ta> tas = new ArrayList<Ta>();
    Spinner dropdown ;//will refactor later
    Spinner dropdown2 ;//will refactor later :using more meaningful variable name
    String spinner1_default = "Year 1";//by default, the current table will display Year
    String spinner2_default = "arts";//and art.
    //database reference current sets to faculty.
    DatabaseReference faculty = FirebaseDatabase.getInstance().getReference("faculty");

    //will create a list of course based on your faculty and year
    List<faculty> facultyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //taInfo = (TextView)findViewById(R.id.TaInfo);
        //textView = (TextView)findViewById(R.id.courseIntro) ;
        //FacultyData facultyData  = (FacultyData)getApplication();
        FirebaseDatabase fac = FirebaseDatabase.getInstance();
        //firebase.getReference().
        //list.setAdapter(firebaseAdapter);


        textView = (TextView)findViewById(R.id.detailTa);
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
                for(final DataSnapshot courseSnapshot :dataSnapshot.getChildren()){
                    ca.dal.csci3130.coursesmanagementsystem.faculty fac = courseSnapshot.getValue(ca.dal.csci3130.coursesmanagementsystem.faculty.class);
                    //faculty course = new faculty();
                    //course.setCourseName(fac.);
                    fac.setUid(dataSnapshot.getKey());
                    DatabaseReference data = faculty.child("ta");
                    Iterable<DataSnapshot> id = courseSnapshot.child("ta").getChildren();
                    while(id.iterator().hasNext()) {
                        DataSnapshot str = id.iterator().next();
                        String s = str.getKey();
                        String email = str.getValue().toString();
                        Ta ta = new Ta(s, email);
                        tas.add(ta);
                    }
                        for(int i = 0; i< tas.size();i++){
                            Ta +=tas.get(i).getName()+ " : "+tas.get(i).getEmail()+"\n";
                        }

                    fac.setTaInfo(Ta);
                    Ta ="";
                    tas.clear();

                    //Ta = nw

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
                    //course.setCourseName(fac.);d
                    Iterable<DataSnapshot> id = courseSnapshot.child("ta").getChildren();
                    //id.iterator();
                    //id.iterator();
                    while(id.iterator().hasNext()) {
                        DataSnapshot str = id.iterator().next();
                        String s = str.getKey();
                        String email = str.getValue().toString();
                        Ta ta = new Ta(s, email);
                        tas.add(ta);
                    }
                        for(int i = 0; i< tas.size();i++){
                            Ta +=tas.get(i).getName()+ " : "+tas.get(i).getEmail()+"\n";
                        
                    }
                    fac.setTaInfo(Ta);
                    Ta ="";
                    tas.clear();

                    //String str = id.toString();
                    facultyList.add(fac);
                    //DatabaseReference taLink = faculty.child("ta");


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
        TaInfo.setInfo(course.getTaInfo());
        moreInfo.setCourseInfo(course.getCourseIntro());
        Intent intent = new Intent(this,moreInfo.class);
        //intent.putExtra("course", course);
        startActivity(intent);
    }
}
