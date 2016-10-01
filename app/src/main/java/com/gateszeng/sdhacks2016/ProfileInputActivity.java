package com.gateszeng.sdhacks2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.Firebase;

public class ProfileInputActivity extends AppCompatActivity {

    Firebase rootRef = new Firebase("https://sdhacks2016-11cfe.firebaseio.com/");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_input);


        //creating profile for the first time
    /*user is required to input name*/

        //every other variable is optional to fill in by user
        //parse the information
        String personalEmail = "";

        //user inputs
        String firstLastN = "";
        String homePn = "";
        String cellPn = "";
        String workPn = "";
        String houseAdd = "";


        Firebase usersRef = rootRef.child("users");
        //usersRef.child("email").setValue(personalEmail);

        //key
        Firebase currRef = usersRef.child(personalEmail);


        currRef.child("name").setValue(firstLastN);
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
