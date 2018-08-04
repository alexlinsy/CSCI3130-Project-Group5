package ca.dal.csci3130.coursesmanagementsystem;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.dal.csci3130.coursesmanagementsystem.DisplayCourses.AcademicTimeTableActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.is;
@RunWith(AndroidJUnit4.class)
public class TestCourseListActivity {
    @Rule
    public ActivityTestRule<AcademicTimeTableActivity> mActivityRule = new ActivityTestRule<>(AcademicTimeTableActivity.class);

    @Test
    public void onSpinnerSelector()throws InterruptedException{
        String spinnerItemText = "computer Science";
        onView(withId(R.id.spinner2)).perform(click());
        onData(allOf(is(instanceOf(String.class)),is(spinnerItemText))).perform(click());
        Thread.sleep(1000);
    }

}