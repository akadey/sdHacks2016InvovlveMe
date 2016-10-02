package com.gateszeng.sdhacks2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class CreatePetitionActivity extends AppCompatActivity {

    Firebase rootRef = new Firebase("https://sdhacks2016-11cfe.firebaseio.com/");
    EditText firstName, lastName;
    EditText homeAddress, emailAddress;
    EditText homePhone, cellPhone, workPhone;

    //creating profile for the first time
    /*user is required to input name*/

    //every other variable is optional to fill in by user
    //parse the information
    String personalEmail = "";

    //user inputs
    String firstN = "";
    String lastN = "";
    String homePn = "";
    String cellPn = "";
    String workPn = "";
    String houseAdd = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_input);
        getActionBar().setDisplayShowTitleEnabled(false);

        firstName = (EditText) findViewById(R.id.first_name);
        lastName = (EditText) findViewById(R.id.last_name);
        homeAddress = (EditText) findViewById(R.id.home_address);
        emailAddress = (EditText) findViewById(R.id.email_address);
        homePhone = (EditText) findViewById(R.id.home_phone);
        cellPhone = (EditText) findViewById(R.id.cell_phone);
        workPhone = (EditText) findViewById(R.id.work_phone);

        firstName.setText(firstN, TextView.BufferType.EDITABLE);
        lastName.setText(lastN, TextView.BufferType.EDITABLE);
        emailAddress.setText(personalEmail, TextView.BufferType.EDITABLE);
    }

    private void pushToFirebase() {
        Firebase usersRef = rootRef.child("users");
        //usersRef.child("email").setValue(personalEmail);

        //key
        Firebase currRef = usersRef.child(personalEmail);


        currRef.child("firstname").setValue(firstN);
        currRef.child("lastname").setValue(lastN);
        currRef.child("workNumber").setValue(workPn);
        currRef.child("cellNumber").setValue(cellPn);
        currRef.child("homeNumber").setValue(homePn);
        currRef.child("homeAddress").setValue(houseAdd);
    }





    //editing the profile

    /*based on name of the person

    String pName = name of Person

    Firebase personRef = rootRef.child(pName);

    call setter functions to set whatever
     */


    /*
    //parse user input and set variables to what user inputs

     */
    /*
    Person newNeighbor = new Person("firstLastN");
    rootRef.setValue(newNeighbor);
    */
}
