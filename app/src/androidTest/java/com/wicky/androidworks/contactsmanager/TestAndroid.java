package com.wicky.androidworks.contactsmanager;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;

import androidx.test.ext.junit.rules.ActivityScenarioRule;


import org.junit.Rule;
import org.junit.Test;


public class TestAndroid {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void testMainMenuDisplay() {
        // Launch the app by starting the MainActivity
        ActivityScenario<MainActivity> scenario = activityScenarioRule.getScenario();

        // Verify that the main menu options are displayed
        onView(withId(R.id.addContactButton)).check(matches(isDisplayed()));
        onView(withId(R.id.deleteContactButton)).check(matches(isDisplayed()));
        onView(withId(R.id.viewContactsButton)).check(matches(isDisplayed()));
    }

    @Test
    public void testEnterDetails() {
        // Launch the app by starting the MainActivity
        ActivityScenario<MainActivity> scenario = activityScenarioRule.getScenario();

        // Click on "Enter/Edit Job Details" from the main menu
        onView(withId(R.id.addContactButton)).perform(click());

        // Enter job details (Title, Company, etc.)
        onView(withId(R.id.nameInput)).perform(clearText(), typeText("Ayesh"));
        onView(withId(R.id.numberInput)).perform(clearText(), typeText("281232122"));
        // Continue entering other job details as needed...

        // Click on "Save" button
        onView(withId(R.id.saveButton)).perform(click());
        onView(withId(R.id.backButton)).perform(click());
        // Verify that the app returns to the main menu
        onView(withId(R.id.addContactButton)).check(matches(withText("Add Contact")));
    }


}
