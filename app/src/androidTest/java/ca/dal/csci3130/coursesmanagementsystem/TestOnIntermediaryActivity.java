package ca.dal.csci3130.coursesmanagementsystem;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.dal.csci3130.coursesmanagementsystem.Login.IntermediaryActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
@RunWith(AndroidJUnit4.class)
public class TestOnIntermediaryActivity {
    @Rule
    public ActivityTestRule<IntermediaryActivity> mActivityRule = new ActivityTestRule<>(IntermediaryActivity.class);


    @Test
    public void onCoursesButton() throws InterruptedException {
        onView(withId(R.id.coursesButton)).perform(click());
        Thread.sleep(2000);
    }
    @Test
    public void onRecommandedButton() throws InterruptedException{
        onView(withId(R.id.recommandationButton)).perform(click());
        Thread.sleep(2000);
    }
    @Test
    public void onMyCourseButton() throws InterruptedException{
        onView(withId(R.id.myCoursesButton)).perform(click());
        Thread.sleep(2000);
    }
    @Test
    public void onMyCourseButton1() throws InterruptedException{
        onView(withId(R.id.myCourse1)).perform(click());
        Thread.sleep(2000);
    }
}