package com.cpic.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.cpic.contacts.login.LoginActivity;
import com.cpic.contacts.utils.SharedPreferencesUtils;


public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Intent intent;
        if (TextUtils.isEmpty((String) SharedPreferencesUtils.get(Constants.TOKEN, ""))) {
            intent = new Intent(this, LoginActivity.class);
        } else {
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
        finish();

    }


}
