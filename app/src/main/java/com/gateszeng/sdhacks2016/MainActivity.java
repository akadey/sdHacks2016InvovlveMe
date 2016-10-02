package com.gateszeng.sdhacks2016;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.database.FirebaseListAdapter;

import java.util.ArrayList;

import static java.sql.Types.NULL;


public class MainActivity extends AppCompatActivity {
    Firebase rootRef = new Firebase("https://sdhacks2016-11cfe.firebaseio.com/");
    Firebase currRef;
    ListView list;
    ArrayList<Petition> petitionArrayList;
    public static final String MyPREFERENCES = "MyPrefs";
    String college;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        college = sharedPreferences.getString("college", "");
        // Getting this from the data sent by loginactivity
        college = getIntent().getStringExtra("schoolname");
        currRef = rootRef.child(college);


        currRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                petitionArrayList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    petitionArrayList.add(postSnapshot.getValue(Petition.class));
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.d("Error", "Load failed");
            }
        });
        if (!petitionArrayList.isEmpty()) {
            ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_listview, petitionArrayList);

            ListView listView = (ListView) findViewById(R.id.petition_list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Petition item = (Petition) parent.getItemAtPosition(position);

                    Intent intent = new Intent(getApplicationContext(), InfoPetitionActivity.class);
                    intent.putExtra("key", item.getTime());
                    startActivity(intent);
                }
            });
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoNewPetition();
            }
        });
    }

    private void gotoNewPetition() {
        Intent i = new Intent(this, CreatePetitionActivity.class);
        startActivity(i);
    }
}

/*
        Class cl = Petition.class;

        ListAdapter adapter = new FirebaseListAdapter<Petition>(this, Petition.class, android.R.layout.two_line_list_item, rootRef) {
            @Override
            protected void populateView(View view, Petition petition, int position) {
                ((TextView)view.findViewById(R.id.line_a)).setText(petition.getTitle());
                ((TextView)view.findViewById(R.id.line_b)).setText(petition.getDescription());
            }
        };
*/



