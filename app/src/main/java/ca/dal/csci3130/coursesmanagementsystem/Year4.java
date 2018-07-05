package ca.dal.csci3130.coursesmanagementsystem;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/**
 * This is the activity of Faculty part
 * including the courses of year4 in each faculty
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

        /**
         * @param catch id in courseRecommend.class
         * to show all the optional selections for Computer Science year4's fall-term courses
         */
        if (courseRecommand.getId() == R.id.BComputerScience) {
            String[] fallTerm = {"-CSCI 4163.03: Human Computer Interaction", "-CSCI 4140.03: Advanced Database Systems", "-Three 2000 Level Free Electives"};
            ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year4.this, android.R.layout.simple_list_item_1, fallTerm);
            ListView lv1 = (ListView) findViewById(R.id.lv1);
            lv1.setAdapter(arrayAdapter1);
            /**
             * @param catch id in courseRecommend.class
             * to show all the optional selections for Computer Science year4's winter-term courses
             */
            String[] winterTerm = {"-CSCI 4691.03: Advanced Project", "-Two 2000 Level Free Electives", "-MGMT 3603.03: Beyond Google"};
            ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year4.this, android.R.layout.simple_list_item_1, winterTerm);
            ListView lv2 = (ListView) findViewById(R.id.lv2);
            lv2.setAdapter(arrayAdapter2);
        }
        /**
         * @param catch id in courseRecommend.class
         * to show all the optional selections for Science year4's fall-term courses
         */
        if (courseRecommand.getId() == R.id.BScience) {
            String[] fallTerm = {"-STAT 4066.03: Advanced Statistical Theory I", "-STAT 4100.03: Survival Analysis", "-STAT 4130.03: Bayesian Data Analysis", "-One Life OR Physical Year2 Elective", "-One Social Year2 Elective"};
            ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year4.this, android.R.layout.simple_list_item_1, fallTerm);
            ListView lv1 = (ListView) findViewById(R.id.lv1);
            lv1.setAdapter(arrayAdapter1);
            /**
             * @param catch id in courseRecommend.class
             * to show all the optional selections for Science year4's winter-term courses
             */
            String[] winterTerm = {"-STAT 4300.03: Topics in Statistics and Probability" , "-STAT 4350.03: Applied Multivariate Analysis", "-One Social Year2 Elective", "-One Life OR Physical Year2 Elective", "-One Free Elective "};
            ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year4.this, android.R.layout.simple_list_item_1, winterTerm);
            ListView lv2 = (ListView) findViewById(R.id.lv2);
            lv2.setAdapter(arrayAdapter2);
        }
        /**
         * @param catch id in courseRecommend.class
         * to show all the optional selections for Commerce year4's fall-term courses
         */
        if (courseRecommand.getId() == R.id.BCommerce) {
            String[] fallTerm = {"-COMM 4351.03: Competitive Strategy", "-COMM 4125.03: Taxation", "-One Non-Year3 Elective", "-One Free Elective"};
            ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year4.this, android.R.layout.simple_list_item_1, fallTerm);
            ListView lv1 = (ListView) findViewById(R.id.lv1);
            lv1.setAdapter(arrayAdapter1);
            /**
             * @param catch id in courseRecommend.class
             * to show all the optional selections for Commerce year4's winter-term courses
             */
            String[] winterTerm = {"-COMM 4352.03: Strategic Mangement" , "-COMM 4101.03: Advanced Accounting I", "-COMM 4102.03: Advanced Accounting II*", "-COMM 4126.03: Taxation II*", "-One Non-Year3 Elective", ""};
            ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year4.this, android.R.layout.simple_list_item_1, winterTerm);
            ListView lv2 = (ListView) findViewById(R.id.lv2);
            lv2.setAdapter(arrayAdapter2);
        }
        /**
         * @param catch id in courseRecommend.class
         * to show all the optional selections for Art year4's fall-term courses
         */
        if (courseRecommand.getId() == R.id.BArts) {
            String[] fallTerm = {"-GERM 4550: Special Topics Class I", "-HIST 4117: Winston Churchill", "-THEA 4060 Y: Technical Theatre 3"};
            ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(Year4.this, android.R.layout.simple_list_item_1, fallTerm);
            ListView lv1 = (ListView) findViewById(R.id.lv1);
            lv1.setAdapter(arrayAdapter1);
            /**
             * @param catch id in courseRecommend.class
             * to show all the optional selections for Art year4's winter-term courses
             */
            String[] winterTerm = {"-THEA 4060 Y: Technical Theatre 3"};
            ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(Year4.this, android.R.layout.simple_list_item_1, winterTerm);
            ListView lv2 = (ListView) findViewById(R.id.lv2);
            lv2.setAdapter(arrayAdapter2);
        }
    }
}
