package com.example.autouzupelnianie;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String[] wojewodztwa = {
            "dolnośląskie",
            "wielkopolskie",
            "opolskie",
            "lubelskie",
            "lubuskie",
            "łódzkie"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, wojewodztwa);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoComplete);
        autoCompleteTextView.setAdapter(adapter);

        MultiAutoCompleteTextView multiAutoCompleteTextView = findViewById(R.id.MultiAutoComplete);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        ListView listView = findViewById(R.id.listView);
        TextView header = new TextView(this);
        header.setText("Województwa");
        header.setTextSize(25);
        header.setTextColor(Color.parseColor("#975A5A"));
        listView.addHeaderView(header);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // pobranie elementu;
                String element = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getBaseContext(), l+1+"."+element, Toast.LENGTH_SHORT).show();
            }
        });

    }
}