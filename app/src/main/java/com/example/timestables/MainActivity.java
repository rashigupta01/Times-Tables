package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myTable;

    public void generateTables (int tableNumber) {
        ArrayList<String> tableUpto10 = new ArrayList<String>();
        for (int i = 1; i<=100; i++)
            tableUpto10.add( Integer.toString(tableNumber) + " X " + Integer.toString(i) + " = " + Integer.toString(tableNumber*i));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tableUpto10);
        myTable.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTable = findViewById(R.id.tableUpto10);

        SeekBar seekBar = findViewById(R.id.tableNo);
        int max = 20, min = 1, startingTable = 10;
        seekBar.setMax(max);
        seekBar.setProgress(startingTable);
        generateTables(startingTable);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress<min) {
                    progress = min;
                    seekBar.setProgress(min);
                }
                generateTables(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}