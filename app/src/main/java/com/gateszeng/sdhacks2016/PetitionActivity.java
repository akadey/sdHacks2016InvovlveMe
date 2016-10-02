package com.gateszeng.sdhacks2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.Firebase;

public class PetitionActivity extends AppCompatActivity {
    //change
    Firebase rootRef = new Firebase("https://sdhacks2016-11cfe.firebaseio.com/");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_input);


        String emergencyPost = "";
        String authorPost = "";


        Firebase postsRef = rootRef.child("posts");
        Firebase currAuthor = postsRef.child(authorPost);



        currAuthor.child("post").setValue(emergencyPost);
    }
}
