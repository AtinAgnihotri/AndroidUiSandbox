package com.atinagnihotri.uisandbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{

    private ListView citiesList;
    private Spinner studentSpinner;

    // Override this method to display menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    // How to do something when menu item is selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settingsMenu:
                Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.alarmMenu:
                Toast.makeText(this, "Alarm Selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        citiesList = findViewById(R.id.citiesList);
        studentSpinner = findViewById(R.id.studentSpinner);

        final ArrayList<String> cities = new ArrayList<>();
        cities.add("Zurich");
        cities.add("New York");
        cities.add("Berlin");
        cities.add("Moscow");
        cities.add("Madrid");

//        If array is static as it is here, can use string array from strings.xml
//        See how it is added to spinner in layout xml file
//        final ArrayList<String> students = new ArrayList<>();
//        students.add("John Shepard");
//        students.add("Elvi Onogonye");
//        students.add("Rohit Mehra");
//        students.add("Sikandar Kamal");
//        students.add("Tenzin Gyatso");

        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cities);
//        ArrayAdapter<String> studentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, students);

        citiesList.setAdapter(citiesAdapter);
//        studentSpinner.setAdapter(studentAdapter);

//        studentSpinner.setOnItemSelectedListener();
        studentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
//                        students.get(position) + " Selected",
                        studentSpinner.getSelectedItem().toString() + " Selected",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        citiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        cities.get(position) + " Selected",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

}