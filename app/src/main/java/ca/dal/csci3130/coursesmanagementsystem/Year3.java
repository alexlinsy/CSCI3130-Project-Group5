package ca.dal.csci3130.coursesmanagementsystem;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/**
 * Show the 3000+ classes for Computer Science, Science, Art, Commerce
 *
 */
public class Year3 extends level {
    /**
     *Create an new activity that shows the year3 recommandation course based on the specific major
     * @param savedInstanceState Define the input fields
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coursetemplate);

        //check faculty id, and show Year3's Computer Science courses in fall and winter term
        switch (courseRecommend.getId()) {
            case R.id.BComputerScience:
                String[] fallTerm = {"-CSCI 3101.03: Social, Ethical, and Professional Issues in Computer Year2", "-CSCI 3160.03: Designing User Interfaces", "-CSCI 3172.03: Web-Centric Computing", "-CSCI 3691.03: Intermediate Project", "-One 2000 Level Free Elective"};
                ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year3.this, android.R.layout.simple_list_item_1, fallTerm);
                ListView lv1 = (ListView) findViewById(R.id.lv1);
                lv1.setAdapter(arrayAdapter1);

                String[] winterTerm = {"-CSCI 3171.03: Network Computing", "-CSCI 3130.03: Introduction to Software Engineering", "-MGMT 3511.03: Management Information Systems", "-Two 2000 Level Free Electives"};
                ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year3.this, android.R.layout.simple_list_item_1, winterTerm);
                ListView lv2 = (ListView) findViewById(R.id.lv2);
                lv2.setAdapter(arrayAdapter2);
                break;
        }

        //check faculty id, and show Year3's Science courses in fall and winter term
        switch (courseRecommend.getId()) {
            case R.id.BScience:
                String[] fallTerm = {"-STAT 3340.03: Regression and Analysis of Variance", "-STAT 3360.03: Probability", "-STAT 3345.03: Environmental Risk Assessment", "-STAT 3380.03: Sample Survey Methods", "-STAT 3720.03: Life Contingencies I"};
                ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year3.this, android.R.layout.simple_list_item_1, fallTerm);
                ListView lv1 = (ListView) findViewById(R.id.lv1);
                lv1.setAdapter(arrayAdapter1);

                String[] winterTerm = {"-STAT 3460.03: Intermediate Statistical Theory", "-STAT 3350.03: Design of Experiments*", "-STAT 3703.03: Actuarial Models I", "-STAT 3750.03: Credibility Theory", "-One Humanity Elective"};
                ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year3.this, android.R.layout.simple_list_item_1, winterTerm);
                ListView lv2 = (ListView) findViewById(R.id.lv2);
                lv2.setAdapter(arrayAdapter2);
                break;
        }

        //check faculty id, and show Year3's Commerce courses in fall and winter term
        switch (courseRecommend.getId()) {
            case R.id.BCommerce:
                String[] fallTerm = {"-COMM 3111.03: Intermediate Financial Accounting II", "-COMM 3114.03: External Auditing", "-Two non-commerce electives"};
                ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year3.this, android.R.layout.simple_list_item_1, fallTerm);
                ListView lv1 = (ListView) findViewById(R.id.lv1);
                lv1.setAdapter(arrayAdapter1);

                String[] winterTerm = {"-COMM 3501.03: Operations Management", "-COMM 3511.03: Management Information Systems", "-COMM 3105.03: Intermediate Financial Accounting I", "-COMM 3116.03: Cost Management","-One Free Elective"};
                ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year3.this, android.R.layout.simple_list_item_1, winterTerm);
                ListView lv2 = (ListView) findViewById(R.id.lv2);
                lv2.setAdapter(arrayAdapter2);
                break;
        }

        //check faculty id, and show Year3's Art courses in fall and winter term
        switch (courseRecommend.getId()) {
            case R.id.BArts:
                String[] fallTerm = {"-GERM 3550: Germany and the Environment", "-HIST3045: The French Revolution"};
                ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year3.this, android.R.layout.simple_list_item_1, fallTerm);
                ListView lv1 = (ListView) findViewById(R.id.lv1);
                lv1.setAdapter(arrayAdapter1);

                String[] winterTerm = {"-THEA 3314: Shakespeare on Film"};
                ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year3.this, android.R.layout.simple_list_item_1, winterTerm);
                ListView lv2 = (ListView) findViewById(R.id.lv2);
                lv2.setAdapter(arrayAdapter2);
                break;
        }
    }
}



