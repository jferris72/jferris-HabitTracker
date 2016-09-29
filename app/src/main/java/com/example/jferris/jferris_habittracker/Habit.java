package com.example.jferris.jferris_habittracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jferris on 22/09/16.
 */
public class Habit {
    private String name;
    private Calendar date;
    private Boolean[] daysOfWeek;

    public Habit(String name) {
        this.name = name;
        this.date = Calendar.getInstance();
        this.daysOfWeek = new Boolean[7];
        this.daysOfWeek[0] = false;
        this.daysOfWeek[1] = false;
        this.daysOfWeek[2] = false;
        this.daysOfWeek[3] = false;
        this.daysOfWeek[4] = false;
        this.daysOfWeek[5] = false;
        this.daysOfWeek[6] = false;
    }
    //sunday=0 monday=1...saturday=6
    public void setDaysOfWeek(int index, Boolean value) {
        this.daysOfWeek[index] = value;
    }

    public String getName() {
        return this.name;
    }

    public Calendar getDate() {
        return this.date;
    }

    public void setDate(Calendar calendar) {
        this.date = calendar;
    }

    public Boolean[] getDays() {
        return this.daysOfWeek;
    }

    @Override
    public String toString() {
        SimpleDateFormat format1 = new SimpleDateFormat("MM-dd-yy");
        String formatted = format1.format(date.getTime());
        return formatted + " " + name;
    }

    public Boolean isToday() {
        Calendar todayCalendar = Calendar.getInstance();

        return daysOfWeek[todayCalendar.get(Calendar.DAY_OF_WEEK)-1];
    }
}
