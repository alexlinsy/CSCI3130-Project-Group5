package ca.dal.csci3130.coursesmanagementsystem.CourseRecommandation;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ca.dal.csci3130.coursesmanagementsystem.R;

/**
 * Show the 2000+ classes for Computer Science, Science, Art, Commerce
 *
 */
public class Year2Activity extends LevelActivity {
    /**
     *Create an new activity that shows the year2 recommandation course based on the specific major
     * @param savedInstanceState Define the input fields
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coursetemplate);

        //check faculty id, and show Year2Activity's Computer Science courses in fall and winter term
        switch (CourseRecommendActivity.getId()) {
            case R.id.BComputerScience:
                String[] fallTerm = {"-CSCI 2100.03: Communication Skills: Written and Oral", "-CSCI 2110.03: Computer Year2Activity III", "-CSCI 2132.03: Software Development", "-CSCI 2141.03: Introduction to Database Systems", "-MGMT 2303.03: People, Work, and Organizations: Micro Organizational Behaviour"};
                ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year2Activity.this, android.R.layout.simple_list_item_1, fallTerm);
                ListView lv1 = (ListView) findViewById(R.id.lv1);
                lv1.setAdapter(arrayAdapter1);

                String[] winterTerm = {"-CSCI 2201.03: Introduction to Information Security", "-CSCI 2170.03: Introduction to Server Side Scripting", "-CSCI 2690.03: Introduction to Software Projects", "-CSCI 2691.03: Introductory Project","-One 1000 Level Free Electives"};
                ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year2Activity.this, android.R.layout.simple_list_item_1, winterTerm);
                ListView lv2 = (ListView) findViewById(R.id.lv2);
                lv2.setAdapter(arrayAdapter2);
                break;
        }

        //check faculty id, and show Year2Activity's Science courses in fall and winter term
        switch (CourseRecommendActivity.getId()) {
            case R.id.BScience:
                String[] fallTerm = {"-MATH 2001.03: Intermediate Calculus I", "-STAT 2060.03: Introduction to Probability and Statistics", "-MATH 2030.03: Matrix Theory and Linear Algebra", "-One Free Elective", "-One Language Elective"};
                ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year2Activity.this, android.R.layout.simple_list_item_1, fallTerm);
                ListView lv1 = (ListView) findViewById(R.id.lv1);
                lv1.setAdapter(arrayAdapter1);

                String[] winterTerm = {"-MATH 2002.03: Intermediate Calculus II", "-STAT 2080.03: Statistical Methods for Data Analysis and Inference", "-MATH 2040.03: Matrix Theory and Linear Algebra II", "-One Free Elective ","-One Language Elective "};
                ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year2Activity.this, android.R.layout.simple_list_item_1, winterTerm);
                ListView lv2 = (ListView) findViewById(R.id.lv2);
                lv2.setAdapter(arrayAdapter2);
                break;
        }

        //check faculty id, and show Year2Activity's Commerce courses in fall and winter term
        switch (CourseRecommendActivity.getId()) {
            case R.id.BCommerce:
                String[] fallTerm = {"-COMM 1720.03: Business Communications II", "-COMM 2202.03: Finance I", "-COMM 2401.03: Intro to Marketing", "-COMM 2501.03: Statistics", "-One Non-Year3Activity Elective"};
                ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year2Activity.this, android.R.layout.simple_list_item_1, fallTerm);
                ListView lv1 = (ListView) findViewById(R.id.lv1);
                lv1.setAdapter(arrayAdapter1);

                String[] winterTerm = {"-COMM 2203.03: Finance 2", "-COMM 2303.03: Organizational Behaviour", "-COMM 2310.03: Business Ethics and Corporate Social Responsibility (CSR)", "-COMM 2502.03: Predictive Analytics", "-COMM 2603.03: Legal Aspects of Business"};
                ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year2Activity.this, android.R.layout.simple_list_item_1, winterTerm);
                ListView lv2 = (ListView) findViewById(R.id.lv2);
                lv2.setAdapter(arrayAdapter2);
                break;
        }

        //check faculty id, and show Year2Activity's Art courses in fall and winter term
        switch (CourseRecommendActivity.getId()) {
            case R.id.BArts:
                String[] fallTerm = {"-GERM 2001: Intermediate German I", "-HIST 2021: Soviet Russia"};
                ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year2Activity.this, android.R.layout.simple_list_item_1, fallTerm);
                ListView lv1 = (ListView) findViewById(R.id.lv1);
                lv1.setAdapter(arrayAdapter1);

                String[] winterTerm = {"-THEA 2011: Ancient and Medieval Theatre"};
                ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year2Activity.this, android.R.layout.simple_list_item_1, winterTerm);
                ListView lv2 = (ListView) findViewById(R.id.lv2);
                lv2.setAdapter(arrayAdapter2);
                break;
        }
    }
}




