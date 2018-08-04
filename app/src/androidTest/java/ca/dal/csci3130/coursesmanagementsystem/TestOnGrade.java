package ca.dal.csci3130.coursesmanagementsystem;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.dal.csci3130.coursesmanagementsystem.Login.IntermediaryActivity;
import ca.dal.csci3130.coursesmanagementsystem.MyCourses.GradesActivity;
import ca.dal.csci3130.coursesmanagementsystem.MyCourses.MyCourseActivity_1;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
    public class TestOnGrade {
    @Rule
    public ActivityTestRule<IntermediaryActivity> mActivityRule = new ActivityTestRule<>(IntermediaryActivity.class);

    @Test
    public void GradeButton()throws Exception {
        Thread.sleep(1000);
        onView(withId(R.id.myCourse1)).perform(click());
        Thread.sleep(2000);
        onData(org.hamcrest.Matchers.anything()).inAdapterView(withId(R.id.lvMain)).atPosition(1).perform(click());

    }
}
