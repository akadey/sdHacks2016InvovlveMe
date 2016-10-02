package com.gateszeng.sdhacks2016;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class InfoPetitionActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    Firebase rootRef = new Firebase("https://sdhacks2016-11cfe.firebaseio.com/");


    String key;
    String title, description;

    TextView petitionName, petitionDescription, author, votes;
    Button voteButton;
    String name, email, college;
    int voteNum = 0;

    SharedPreferences sharedPreferences;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_petition);
        getActionBar().setDisplayShowTitleEnabled(false);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            key = extras.getString("key");
        }

        petitionName = (TextView) findViewById(R.id.petition_name);
        petitionDescription = (TextView) findViewById(R.id.petition_description);
        author = (TextView) findViewById(R.id.author);
        votes = (TextView) findViewById(R.id.votes);

        voteButton = (Button) findViewById(R.id.submit_btn);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        name = sharedPreferences.getString("name", "");
        email = sharedPreferences.getString("email", "");
        college = sharedPreferences.getString("college", "");

        Firebase voteValueRef = rootRef.child(college).child(key);

        voteValueRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Petition p = snapshot.getValue(Petition.class);
                title = p.getTitle();
                description = p.getDescription();
                voteNum = p.getVotes();

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

        voteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Firebase voteValueRef = rootRef.child(college).child(key).child("votes");

                voteNum += 1;

                voteValueRef.setValue(voteNum);
            }

        });

        updateViews();
    }

    private void updateViews() {
        petitionName.setText(title);
        petitionDescription.setText(description);
        votes.setText(voteNum);
        author.setText(name);
    }


}





