package com.gateszeng.sdhacks2016;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.firebase.client.Firebase;

public class StartActivity extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Firebase.setAndroidContext(this);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        Log.d("sharedPref", sharedPreferences.getString("name", "fail"));
        checkLogin();
    }

    private void checkLogin() {
        if (!sharedPreferences.getString("name", "fail").equals("fail")) {
            Log.d("successful sharedprefs", "gotoMain");
            startActivity(new Intent(this, MainActivity.class));
        }
        else {
            Log.d("failed sharedprefs", "gotoLogin");
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
