package com.example.anagram;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;
import android.os.RemoteException;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.UiDevice;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.anagram", appContext.getPackageName());
    }

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testOrientation() throws RemoteException {
        UiDevice device = UiDevice.getInstance(androidx.test.platform.app.InstrumentationRegistry.getInstrumentation());

        onView(withId(R.id.enterTextForAnagram)).perform(typeText("Mykola Android Developer 17"));
        closeSoftKeyboard();

        onView(withId(R.id.enterSymbolsToIgnore)).perform(typeText(("ka")));
        closeSoftKeyboard();

        device.setOrientationLeft();

        onView(withId(R.id.convertButton)).perform(click());

        onView(withId(R.id.yourAnagram)).check(matches(withText("lokyMa diordnA repoleveD 71")));

        device.setOrientationNatural();
    }
}