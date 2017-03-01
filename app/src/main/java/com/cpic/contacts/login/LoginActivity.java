package com.cpic.contacts.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
        mLoginPresenter.login();
    }
}
