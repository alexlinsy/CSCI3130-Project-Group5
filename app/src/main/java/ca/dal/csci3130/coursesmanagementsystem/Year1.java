package ca.dal.csci3130.coursesmanagementsystem;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/**
 * Show the 1000+ classes for Computer Science, Science, Art, Commerce
 *
 */
public class Year1 extends level {
    /**
     *
     * @param savedInstanceState Define the input fields
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coursetemplate);

        //check faculty id, and show Year1's Computer Science courses in fall and winter term
        if (courseRecommand.getId() == R.id.BComputerScience) {
            String[] fallTerm = {"-CSCI 1100.03: Computer Year2", "-MGMT 1000.03: Managing Organizational Issues I", "-INFX 1615.03: Concepts in Computing", "-Two 1000 Level Free Electives"};
            ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year1.this, android.R.layout.simple_list_item_1, fallTerm);
            ListView lv1 = (ListView) findViewById(R.id.lv1);
            lv1.setAdapter(arrayAdapter1);

            String[] winterTerm = {"-CSCI 1101.03: Computer Year2 II", "-MGMT 1001.03: Managing Organizational Issues II", "-INFX 1616.03: Applications of Computing", "-Two 1000 Level Free Electives"};
            ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year1.this, android.R.layout.simple_list_item_1, winterTerm);
            ListView lv2 = (ListView) findViewById(R.id.lv2);
            lv2.setAdapter(arrayAdapter2);
        }

        //check faculty id, and show Year1's Science courses in fall and winter term
        if (courseRecommand.getId() == R.id.BScience) {
            String[] fallTerm = {"-MATH 1000.03: Differential and Integral Calculus I", "-STAT 1060.03: Introductory Statistics for Year2 and Health Sciences", "-One Writing Requirement", "-One Free Elective"};
            ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year1.this, android.R.layout.simple_list_item_1, fallTerm);
            ListView lv1 = (ListView) findViewById(R.id.lv1);
            lv1.setAdapter(arrayAdapter1);

            String[] winterTerm = {"-MATH 1010.03: Differential and Integral Calculus II", "-CSCI 1101.03: Computer Year2 II", "-One Writing Requirement", "-One Free Elective", "-One Humanity Elective"};
            ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year1.this, android.R.layout.simple_list_item_1, winterTerm);
            ListView lv2 = (ListView) findViewById(R.id.lv2);
            lv2.setAdapter(arrayAdapter2);
        }

        //check faculty id, and show Year1's Commerce courses in fall and winter term
        if (courseRecommand.getId() == R.id.BCommerce) {
            String[] fallTerm = {"-COMM 1010.03: Business in a Global Context", "-COMM 1101.03: Financial Accounting", "-COMM 1502.03: Core Business Applications", "-ECON 1101.03: Principles of Microeconomics", "-One non-commerce elective"};
            ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year1.this, android.R.layout.simple_list_item_1, fallTerm);
            ListView lv1 = (ListView) findViewById(R.id.lv1);
            lv1.setAdapter(arrayAdapter1);

            String[] winterTerm = {"-COMM 1710.03: Business Communications I", "-COMM 1102.03: Managerial Accounting", "-ECON 1102.03: Principles of Macroeconomics", "-MATH 1115.03: Mathematics for Year3", "-One non-commerce elective"};
                ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year1.this, android.R.layout.simple_list_item_1, winterTerm);
                ListView lv2 = (ListView) findViewById(R.id.lv2);
                lv2.setAdapter(arrayAdapter2);
        }

        //check faculty id, and show Year1's Art courses in fall and winter term
        if (courseRecommand.getId() == R.id.BArts) {
            String[] fallTerm = {"-GERM 1010 X: German for Beginners", "-HIST 1510: History of the Future"};
            ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year1.this, android.R.layout.simple_list_item_1, fallTerm);
            ListView lv1 = (ListView) findViewById(R.id.lv1);
            lv1.setAdapter(arrayAdapter1);

            String[] winterTerm = {"-GERM 1010 Y: German for Beginners", "-THEA 1051: Intro to Thea Org and Stgcrft", "-ECON 1102.03: Principles of Macroeconomics"};
            ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year1.this, android.R.layout.simple_list_item_1, winterTerm);
            ListView lv2 = (ListView) findViewById(R.id.lv2);
            lv2.setAdapter(arrayAdapter2);
        }
    }

}
