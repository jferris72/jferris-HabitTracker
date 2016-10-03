package com.example.jferris.jferris_habittracker;

import org.junit.Test;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Calendar;
=======
>>>>>>> 1245456e94ea629c91afb68cf61d286d6d8204f8
import java.util.Date;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    Habit habit;
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void makeHabit() throws Exception {
        habit = new Habit("name");
        assertEquals(habit.getName(), "name");
    }

    @Test
    public void testDays() throws Exception {
        habit = new Habit("name");
        habit.setDaysOfWeek(0, Boolean.TRUE);
        habit.setDaysOfWeek(1, true);
        habit.setDaysOfWeek(2, true);
        habit.setDaysOfWeek(3, true);
        habit.setDaysOfWeek(4, true);
        habit.setDaysOfWeek(5, true);
        habit.setDaysOfWeek(6, true);
        Boolean[] newlist = {true,true,true,true,true,true,true};
        //assertEquals(false, habit.getDays()[0]);
        assertArrayEquals(newlist, habit.getDays());

    }

    @Test
    public void testIsToday() throws Exception {
        habit = new Habit("name");
        habit.setDaysOfWeek(0, true);
        habit.setDaysOfWeek(1, true);
        habit.setDaysOfWeek(2, true);
        habit.setDaysOfWeek(3, true);
        habit.setDaysOfWeek(4, true);
        habit.setDaysOfWeek(5, true);
        habit.setDaysOfWeek(6, true);
        assertEquals(true, habit.isToday());

    }
<<<<<<< HEAD

    @Test
    public void testCompletionList() throws Exception {
        habit = new Habit("name");
        Calendar calendar = Calendar.getInstance();
        habit.addCompletion(calendar);
        assertEquals(calendar, habit.getCompletionList().get(0));
        habit.addCompletion(calendar);
        assertEquals(2, habit.getCompletionList().size());
;    }
=======
>>>>>>> 1245456e94ea629c91afb68cf61d286d6d8204f8
}