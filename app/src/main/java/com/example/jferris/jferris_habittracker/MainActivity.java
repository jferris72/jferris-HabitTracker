package com.example.jferris.jferris_habittracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
<<<<<<< HEAD
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * This is the Main Activity for the app
 * This activity lists the habits that are to be completed for the day
 * The user may complete or delete habits shown on the list
 * There is a drop down menu that allows the user to navigate to the create habit activity or showallhabits activity
 */

public class MainActivity extends Activity {
    private ArrayList<Habit> habitList = new ArrayList<Habit>();
    private ArrayList<Habit> todayHabitList;
    private ListOfHabits habitAdapter;
    private ListView dailyHabitsList;
    private LoadSaveHabits loadSave;
=======
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends Activity {
    private static final String FILENAME = "habitFile.sav";
    private EditText habitName;
    private ArrayList<Habit> habitList = new ArrayList<Habit>();
    private ArrayAdapter<Habit> habitAdapter;
    private ListView dailyHabitsList;
>>>>>>> 1245456e94ea629c91afb68cf61d286d6d8204f8


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dailyHabitsList = (ListView) findViewById(R.id.dailyHabits);
<<<<<<< HEAD
=======

>>>>>>> 1245456e94ea629c91afb68cf61d286d6d8204f8
    }


    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
<<<<<<< HEAD
        loadSave = new LoadSaveHabits(this, todayHabitList);
        habitList = loadSave.loadFromFile();
        todayHabitList = new ArrayList<Habit>();
        int i;
        for(i = 0; i<habitList.size(); i++) {
            if(habitList.get(i).isToday() == true) {
                todayHabitList.add(habitList.get(i));
            }
        }
        //loadFromFile();
        habitAdapter = new ListOfHabits(this, todayHabitList);
=======
        loadFromFile();
        habitAdapter = new ArrayAdapter<Habit>(this,
                R.layout.list_item, habitList);
>>>>>>> 1245456e94ea629c91afb68cf61d286d6d8204f8
        dailyHabitsList.setAdapter(habitAdapter);
    }

    @Override
<<<<<<< HEAD
    protected void onPause() {
        super.onPause();
        loadSave = new LoadSaveHabits(this, todayHabitList);
        int i;
        for(i = 0; i<habitList.size(); i++) {
            if(habitList.get(i).isToday() == false) {
                todayHabitList.add(habitList.get(i));
            }
        }
        loadSave.saveInFile();
    }


    @Override
=======
>>>>>>> 1245456e94ea629c91afb68cf61d286d6d8204f8
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, menu);
        return true;
    }

    public void createHabitIntent(MenuItem menu) {
        Toast.makeText(this, "Habit Create", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, CreateHabitActivity.class);
        startActivity(intent);
    }

<<<<<<< HEAD
    public void allHabitIntent(MenuItem menu) {
        Toast.makeText(this, "Show All Habits", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, ShowAllHabits.class);
        startActivity(intent);
    }

=======
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            Type listType = new TypeToken<ArrayList<Habit>>(){}.getType();

            habitList = gson.fromJson(in,listType);

            fis.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            habitList = new ArrayList<Habit>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(habitList, out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

   /* public void onCheckboxClicked(View view, Habit habit) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.mondayCheckBox:
                if (checked) {
                    habit.setDaysOfWeek(0, true);
                }
                else {
                    habit.setDaysOfWeek(0, false);
                }

                break;
            case R.id.tuesdayCheckBox:
                if (checked) {
                    habit.setDaysOfWeek(1, true);
                }
                else {
                    habit.setDaysOfWeek(1, false);
                }
                break;
            case R.id.wednesdayCheckBox:
                if (checked) {
                    habit.setDaysOfWeek(2, true);
                }
                else {
                    habit.setDaysOfWeek(2, false);
                }
                break;
            case R.id.thursdayCheckBox:
                if (checked) {
                    habit.setDaysOfWeek(3, true);
                }
                else {
                    habit.setDaysOfWeek(3, false);
                }
                break;
            case R.id.fridayCheckBox:
                if (checked) {
                    habit.setDaysOfWeek(4, true);
                }
                else {
                    habit.setDaysOfWeek(4, false);
                }
                break;
            case R.id.saturdayCheckBox:
                if (checked) {
                    habit.setDaysOfWeek(5, true);
                }
                else {
                    habit.setDaysOfWeek(5, false);
                }
                break;
            case R.id.sundayCheckBox:
                if (checked) {
                    habit.setDaysOfWeek(6, true);
                }
                else {
                    habit.setDaysOfWeek(6, false);
                }
                break;
        }
    } */

>>>>>>> 1245456e94ea629c91afb68cf61d286d6d8204f8

}
