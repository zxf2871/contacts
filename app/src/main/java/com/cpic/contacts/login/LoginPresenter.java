package com.cpic.contacts.login;

import android.support.annotation.NonNull;

import com.cpic.contacts.login.source.LoginDataSource;

/**
 * Created by Administrator on 2017/3/1.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginDataSource mRepository;
    private LoginContract.View mView;


    public LoginPresenter(@NonNull LoginContract.View view,@NonNull LoginDataSource repository){
        this.mRepository = repository;
        this.mView = view;
    }


    @Override
    public void start() {

    }

    @Override
    public void login(String userName, String password) {
        mRepository.login(userName, password, new LoginDataSource.LoginCallback() {
            @Override
            public void onLoginSuccess(String token) {
                mView.loginSuccess();
            }

            @Override
            public void onLoginError(String massage) {
                mView.loginError(massage);
            }
        });
    }
}
