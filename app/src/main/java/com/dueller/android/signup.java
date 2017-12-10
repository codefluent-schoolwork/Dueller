package com.dueller.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }


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
//                Toast.makeText(signup.this, "Uploading . . .", Toast.LENGTH_SHORT).show();
//            }else{
//                Toast.makeText(signup.this, "Make sure all fields are completed!", Toast.LENGTH_SHORT).show();
//            }
//        }catch(Exception e){
//            Toast.makeText(signup.this, "Make sure image is selected!", Toast.LENGTH_SHORT).show();
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
    public void onClickConfirm(View view) {
        Intent intent = new Intent(signup.this, MainBoardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}

