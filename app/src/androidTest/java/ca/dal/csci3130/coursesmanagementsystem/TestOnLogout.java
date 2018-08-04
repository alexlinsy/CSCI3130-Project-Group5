package ca.dal.csci3130.coursesmanagementsystem;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import ca.dal.csci3130.coursesmanagementsystem.Login.IntermediaryActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class TestOnLogout {
    @Rule
    public ActivityTestRule<IntermediaryActivity> mActivityRule = new ActivityTestRule<>(IntermediaryActivity.class);

    @Test
    public void LogoutButton()throws Exception {
        Thread.sleep(1000);
        onView(withId(R.id.myCourse1)).perform(click());
        Thread.sleep(2000);
        onData(org.hamcrest.Matchers.anything()).inAdapterView(withId(R.id.lvMain)).atPosition(2).perform(click());
    }
}
