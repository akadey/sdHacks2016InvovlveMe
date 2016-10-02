package com.gateszeng.sdhacks2016;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class CreatePetitionActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    Firebase rootRef = new Firebase("https://sdhacks2016-11cfe.firebaseio.com/");
    EditText petitionName, petitionDescription;
    Button submitButton;
    String name, email, college;
    long time;

    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_petition);
        //getActionBar().setDisplayShowTitleEnabled(false);

        petitionName = (EditText) findViewById(R.id.petition_name);
        petitionDescription = (EditText) findViewById(R.id.petition_description);
        submitButton = (Button) findViewById(R.id.submit_btn);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        name = sharedPreferences.getString("name", "");
        email = sharedPreferences.getString("email", "");
        college = sharedPreferences.getString("college", "");


        submitButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                time = System.currentTimeMillis();
                Petition p = new Petition(petitionName.getText().toString(),
                        petitionDescription.getText().toString(), name, 0,
                        time);
                pushToFirebase(p);
                backToMainAct();
            }

        });
    }

    private void pushToFirebase(Petition p) {
        Firebase collegeRef = rootRef.child(college);
        collegeRef.child(time+"").setValue(p);
    }

    private void backToMainAct() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
