package com.cpic.contacts.login;

import android.support.annotation.NonNull;

import com.cpic.contacts.login.source.UserDataSource;

/**
 * Created by Administrator on 2017/3/1.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private UserDataSource mRepository;
    private LoginContract.View mView;


    public LoginPresenter(@NonNull LoginContract.View view,@NonNull UserDataSource repository){
        this.mRepository = repository;
        this.mView = view;
    }


    @Override
    public void start() {

    }

    @Override
    public void login(String userName) {
        User user = mRepository.getUser(userName);
    }
}
