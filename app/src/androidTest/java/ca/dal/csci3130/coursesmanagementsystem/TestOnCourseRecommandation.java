package ca.dal.csci3130.coursesmanagementsystem;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import ca.dal.csci3130.coursesmanagementsystem.Login.IntermediaryActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class TestOnCourseRecommandation {
    @Rule
    public ActivityTestRule<IntermediaryActivity> mActivityRule = new ActivityTestRule<>(IntermediaryActivity.class);

    @Test
    public void computerScienceButton()throws Exception {
        Thread.sleep(1000);
        onView(withId(R.id.recommandationButton)).perform(click());
        Thread.sleep(1000);
        onView(withId(R.id.BComputerScience)).perform(click());
        onView(withId(R.id.B1000)).perform(click());
    }
    @Test
    public void commerceButton()throws Exception {
        Thread.sleep(1000);
        onView(withId(R.id.recommandationButton)).perform(click());
        Thread.sleep(1000);
        onView(withId(R.id.BCommerce)).perform(click());
        onView(withId(R.id.B2000)).perform(click());
    }
}
