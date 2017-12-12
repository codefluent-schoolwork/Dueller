package com.dueller.android;

import android.content.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class DuelDetailsActivity extends AppCompatActivity {

    public static final String KEY_DUEL_ID = "key_duel_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duel_details);

        /*
        Get data from database...
        - change images for both challengers (MAYBE)
        - setText the challenger1 & challenger2 names
        - setText the challenger1info & challenger2info with details about the challengers
        - setText the details about the duel locations
         */

        Button backBTN = (Button) findViewById(R.id.backButton);
        backBTN.setOnClickListener(
                event -> {
                    startActivity(new Intent(DuelDetailsActivity.this, BragFormActivity.class));
                }
        );

        EditText comments = (EditText) findViewById(R.id.commentsTextArea);


        Button submitCommentBTN = (Button) findViewById(R.id.submitButton);
        submitCommentBTN.setOnClickListener(
                event -> {
                    System.out.println(comments.getText());
                }
        );
    }
}
