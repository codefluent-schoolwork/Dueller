package com.dueller.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;





public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickLogin(View view) {



        //log in info hardcoded in, delete these two lines and uncomment the others to allow
        //actual authentication
        String userInput = "flyershareofficial@gmail.com";
        String passwordInput = "apps4998";
        /*EditText txtDescription =
                (EditText) findViewById(R.id.usernameField);
        String userInput = txtDescription.getText().toString();
        txtDescription =
                (EditText) findViewById(R.id.passwordField);
        String passwordInput = txtDescription.getText().toString();*/
        ref.authWithPassword(userInput, passwordInput, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                Intent intent = new Intent(MainActivity.this, MainBoardActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                Toast.makeText(getApplicationContext(), "Error with user credentials.", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onClickSignUp(View view) {
        Intent intent = new Intent(MainActivity.this, signup.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


}
