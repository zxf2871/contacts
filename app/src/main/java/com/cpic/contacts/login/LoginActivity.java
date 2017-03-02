package com.cpic.contacts.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cpic.contacts.ContactsApplication;
import com.cpic.contacts.MainActivity;
import com.cpic.contacts.R;
import com.cpic.contacts.utils.Injection;


/**
 * Created by Administrator on 2017/3/1.
 */

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private LoginContract.Presenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        LoginPresenter presenter = new LoginPresenter(this, Injection.provideTasksRepository(getApplicationContext()));
        this.setPresenter(presenter);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mLoginPresenter = presenter;
    }


    public void login(View view) {
        String userName = ((EditText) findViewById(R.id.et_username)).getText().toString();
        String password = ((EditText) findViewById(R.id.et_password)).getText().toString();
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(this, R.string.user_erorr, Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, R.string.password_erorr, Toast.LENGTH_SHORT).show();
            return;
        }

        mLoginPresenter.login(userName, password);
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }

    @Override
    public void loginError(final String message) {
        ContactsApplication.getInstance().getGlobalHandler().post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
