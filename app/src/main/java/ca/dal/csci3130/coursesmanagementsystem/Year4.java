package ca.dal.csci3130.coursesmanagementsystem;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/**
 * Show the 4000+ classes for Computer Science, Science, Art, Commerce
 *
 */
public class Year4 extends level {
    /**
     *
     * @param savedInstanceState Define the input fields
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coursetemplate);

        //check faculty id, and show Year4's Computer Science courses in fall and winter term
        if (courseRecommand.getId() == R.id.BComputerScience) {
            String[] fallTerm = {"-CSCI 4163.03: Human Computer Interaction", "-CSCI 4140.03: Advanced Database Systems", "-Three 2000 Level Free Electives"};
            ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year4.this, android.R.layout.simple_list_item_1, fallTerm);
            ListView lv1 = (ListView) findViewById(R.id.lv1);
            lv1.setAdapter(arrayAdapter1);

            String[] winterTerm = {"-CSCI 4691.03: Advanced Project", "-Two 2000 Level Free Electives", "-MGMT 3603.03: Beyond Google"};
            ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year4.this, android.R.layout.simple_list_item_1, winterTerm);
            ListView lv2 = (ListView) findViewById(R.id.lv2);
            lv2.setAdapter(arrayAdapter2);
        }

        //check faculty id, and show Year4's Science courses in fall and winter term
        if (courseRecommand.getId() == R.id.BScience) {
            String[] fallTerm = {"-STAT 4066.03: Advanced Statistical Theory I", "-STAT 4100.03: Survival Analysis", "-STAT 4130.03: Bayesian Data Analysis", "-One Life OR Physical Year2 Elective", "-One Social Year2 Elective"};
            ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year4.this, android.R.layout.simple_list_item_1, fallTerm);
            ListView lv1 = (ListView) findViewById(R.id.lv1);
            lv1.setAdapter(arrayAdapter1);

            String[] winterTerm = {"-STAT 4300.03: Topics in Statistics and Probability" , "-STAT 4350.03: Applied Multivariate Analysis", "-One Social Year2 Elective", "-One Life OR Physical Year2 Elective", "-One Free Elective "};
            ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year4.this, android.R.layout.simple_list_item_1, winterTerm);
            ListView lv2 = (ListView) findViewById(R.id.lv2);
            lv2.setAdapter(arrayAdapter2);
        }

        //check faculty id, and show Year4's Commerce courses in fall and winter term
        if (courseRecommand.getId() == R.id.BCommerce) {
            String[] fallTerm = {"-COMM 4351.03: Competitive Strategy", "-COMM 4125.03: Taxation", "-One Non-Year3 Elective", "-One Free Elective"};
            ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year4.this, android.R.layout.simple_list_item_1, fallTerm);
            ListView lv1 = (ListView) findViewById(R.id.lv1);
            lv1.setAdapter(arrayAdapter1);

            String[] winterTerm = {"-COMM 4352.03: Strategic Mangement" , "-COMM 4101.03: Advanced Accounting I", "-COMM 4102.03: Advanced Accounting II*", "-COMM 4126.03: Taxation II*", "-One Non-Year3 Elective", ""};
            ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year4.this, android.R.layout.simple_list_item_1, winterTerm);
            ListView lv2 = (ListView) findViewById(R.id.lv2);
            lv2.setAdapter(arrayAdapter2);
        }

        //check faculty id, and show Year4's Art courses in fall and winter term
        if (courseRecommand.getId() == R.id.BArts) {
            String[] fallTerm = {"-GERM 4550: Special Topics Class I", "-HIST 4117: Winston Churchill", "-THEA 4060 Y: Technical Theatre 3"};
            ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year4.this, android.R.layout.simple_list_item_1, fallTerm);
            ListView lv1 = (ListView) findViewById(R.id.lv1);
            lv1.setAdapter(arrayAdapter1);

            String[] winterTerm = {"-THEA 4060 Y: Technical Theatre 3"};
            ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year4.this, android.R.layout.simple_list_item_1, winterTerm);
            ListView lv2 = (ListView) findViewById(R.id.lv2);
            lv2.setAdapter(arrayAdapter2);
        }
    }
}
