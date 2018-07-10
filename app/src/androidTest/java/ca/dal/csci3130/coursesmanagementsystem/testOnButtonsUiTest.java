package ca.dal.csci3130.coursesmanagementsystem;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
@RunWith(AndroidJUnit4.class)
public class testOnButtonsUiTest {

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("ca.dal.csci3130.coursesmanagementsystem", appContext.getPackageName());
    }


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    /**
     * This method will perform sign in.
     */
    @Test
    public void signIn()throws Exception{
        Thread.sleep(1000);
        onView(withId(R.id.textViewSignin)).perform(click());
        onView(withId(R.id.editTextEmail)).perform(typeText("123456@dal.ca"));
        onView(withId(R.id.editTextPassword)).perform(typeText("Cyf.19970726"));
        onView(withId(R.id.buttonLogin)).perform(closeSoftKeyboard());
        onView(withId(R.id.buttonLogin)).perform(click());
    }

    /**
     * This method will perform sign in and click the courses button.
     */
    @Test
    public void signInAndCoursesButton()throws Exception{
        Thread.sleep(1000);
        onView(withId(R.id.textViewSignin)).perform(click());
        onView(withId(R.id.editTextEmail)).perform(typeText("123456@dal.ca"));
        onView(withId(R.id.editTextPassword)).perform(typeText("Cyf.19970726"));
        onView(withId(R.id.buttonLogin)).perform(closeSoftKeyboard());
        onView(withId(R.id.buttonLogin)).perform(click());
        Thread.sleep(5000);
        onView(withId(R.id.coursesButton)).perform(click());
        Thread.sleep(2000);
        onData(org.hamcrest.Matchers.anything()).inAdapterView(withId(R.id.listView))
                .atPosition(0).perform(click());
    }

    /**
     * This method will perform sign in and click the course recommendation button.
     */
    @Test
    public void signInAndRecommandationButton()throws Exception{
        Thread.sleep(1000);
        onView(withId(R.id.textViewSignin)).perform(click());
        onView(withId(R.id.editTextEmail)).perform(typeText("123456@dal.ca"));
        onView(withId(R.id.editTextPassword)).perform(typeText("Cyf.19970726"));
        onView(withId(R.id.buttonLogin)).perform(closeSoftKeyboard());
        onView(withId(R.id.buttonLogin)).perform(click());
        Thread.sleep(5000);
        onView(withId(R.id.recommandationButton)).perform(click());
        Thread.sleep(2000);
        onView(withId(R.id.BComputerScience)).perform(click());
        Thread.sleep(2000);
        onView(withId(R.id.B1000)).perform(click());
    }

    /**
     * This method will perform sign in and click my course button.
     */
    @Test
    public void signInAndmyCourse()throws Exception{
        Thread.sleep(1000);
        onView(withId(R.id.textViewSignin)).perform(click());
        onView(withId(R.id.editTextEmail)).perform(typeText("123456@dal.ca"));
        onView(withId(R.id.editTextPassword)).perform(typeText("Cyf.19970726"));
        onView(withId(R.id.buttonLogin)).perform(closeSoftKeyboard());
        onView(withId(R.id.buttonLogin)).perform(click());
        Thread.sleep(5000);
        onView(withId(R.id.myCoursesButton)).perform(click());
    }
}
