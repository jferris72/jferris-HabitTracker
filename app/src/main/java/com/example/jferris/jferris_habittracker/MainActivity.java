package com.example.jferris.jferris_habittracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dailyHabitsList = (ListView) findViewById(R.id.dailyHabits);

    }


    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        loadFromFile();
        habitAdapter = new ArrayAdapter<Habit>(this,
                R.layout.list_item, habitList);
        dailyHabitsList.setAdapter(habitAdapter);
    }

    @Override
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


}
