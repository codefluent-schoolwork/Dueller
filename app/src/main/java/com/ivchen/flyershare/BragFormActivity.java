package com.ivchen.flyershare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class BragFormActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] skillsList = {"Everything", "Mario Kart", "Super Smash Bros.", "Thumb Wrestling", "Football", "Dancing", "Chess", "Yu-Gi-Oh", "League of Legends", "Call of Duty", "Running", "Arm Wrestling"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brag_form);

        // GET SPINNER & APPLY OnItemSelectedListener
        Spinner spinner = (Spinner) findViewById(R.id.skillField);
        spinner.setOnItemSelectedListener(this);

        // CREATE ARRAY
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, skillsList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), skillsList[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void onClickHome(View view) {
        Intent intent = new Intent(BragFormActivity.this, MainBoardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
