package com.dueller.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
/*
    TODO:
        - Add user to database
        - Add name to user in database
        - Add picture to Firestore and add field
*/

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;

    protected EditText nameEditText;
    protected EditText emailEditText;
    protected EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_signup);
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mFirebaseAuth.getCurrentUser();
//        updateUI(currentUser, null);
//    }


    //    public void onClickbuttonCamera(View view) {
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(intent, REQUEST_CAMERA);
//    }
//
//
//    public void onClickbuttonPhotoLibrary(View view) {
//        Intent intent = new Intent(
//                Intent.ACTION_PICK,
//                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        intent.setType("image/*");
//
//        startActivityForResult(
//                Intent.createChooser(intent, "Choose File"),
//                SELECT_FILE);
//    }
//
//
//    public void onClickbuttonUpload(View view) {
//
//
//        try{
//
//            String editTitle = title.getText().toString();
//            String editDate = date.getText().toString();
//            String editSchool = school.getText().toString();
//            if(editTitle.trim().length() > 0 && editDate.trim().length() > 0 && editSchool.trim().length() > 0) {
//                Bitmap bmp = ((BitmapDrawable) image.getDrawable()).getBitmap();
//                ByteArrayOutputStream bYtE = new ByteArrayOutputStream();
//                bmp.compress(Bitmap.CompressFormat.JPEG, 100, bYtE);
//                bmp.recycle();
//                byte[] byteArray = bYtE.toByteArray();
//                String imageFile = Base64.encodeToString(byteArray, Base64.DEFAULT);
//
//                Firebase ref = new Firebase("https://flyershare.firebaseio.com");
//                Firebase postRef = ref.child("posts");
//                Map<String, String> flyer = new HashMap<String, String>();
//                flyer.put("image", imageFile);
//                flyer.put("date", editDate);
//                flyer.put("title", editTitle);
//                flyer.put("school", editSchool);
//                postRef.push().setValue(flyer);
//
//                Toast.makeText(SignupActivity.this, "Uploading . . .", Toast.LENGTH_SHORT).show();
//            }else{
//                Toast.makeText(SignupActivity.this, "Make sure all fields are completed!", Toast.LENGTH_SHORT).show();
//            }
//        }catch(Exception e){
//            Toast.makeText(SignupActivity.this, "Make sure image is selected!", Toast.LENGTH_SHORT).show();
//
//        }
//
//
//    }
//
//    //this method will handle image chosen from gallery or taken with camera
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == SELECT_FILE && resultCode == RESULT_OK) {
//
//            selectedImage = data.getData();
//            image.setImageURI(selectedImage);
//
//        } else if(requestCode == REQUEST_CAMERA && resultCode == RESULT_OK){
//            //camera crashes after picture is taken!!
//            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
//            image.setImageBitmap(thumbnail);
//        }
//    }
//
    public void onClickSignup(View view) {

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty() || name.isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
            builder.setMessage("Please fill in all of the fields.")
                    .setTitle("Sign up failed" )
                    .setPositiveButton(android.R.string.ok, null);

            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            mFirebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mFirebaseAuth.getCurrentUser();
                                updateUI(user, task);
                                Toast.makeText(SignupActivity.this, "Signup succeeded.",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                updateUI(null, task);
                            }
                        }
                    });
        }

    }

    private void updateUI(FirebaseUser user, Task<AuthResult> task) {
        if (user != null) {
            Intent intent = new Intent(SignupActivity.this, SignupConfirmActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
            builder.setMessage(task.getException().getMessage())
                    .setTitle("Authentication failed.")
                    .setPositiveButton(android.R.string.ok, null);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}

