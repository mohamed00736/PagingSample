package hacine.mohamed.pagingsample;


import android.app.Activity;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class RecyclerViewTest {



    @Rule
    public  ActivityTestRule<MainActivity>  activityTestRule =new ActivityTestRule<>(MainActivity.class);






    @Test
    public  void recyclerTestclick(){


     Espresso.onView(withId(R.id.recyclerview)).perform(RecyclerViewActions.actionOnItemAtPosition(6,click()));

//        String itemval = "boy";
//
//        Espresso.onView(withText(itemval)).check(matches(isDisplayed()));




    }



    @Test
    public  void swipdown(){


        //Espresso.onView(withId(R.id.recyclerview)).perform(ViewActions.swipeDown());

        RecyclerView recyclerView = activityTestRule.getActivity().findViewById(R.id.recyclerview);

        int itemcount = recyclerView.getAdapter().getItemCount();

        Espresso.onView(withId(R.id.recyclerview)).perform(RecyclerViewActions.scrollToPosition(itemcount-1));
  Espresso.onView(withId(R.id.recyclerview)).perform(RecyclerViewActions.actionOnItemAtPosition(itemcount-1,click()));


        //Espresso.onView(withId(R.id.recyclerview)).perform(ViewActions.swipeUp());

        //Espresso.onView(withId(R.id.recyclerview)).perform(RecyclerViewActions.scrollToPosition());



    }
}
