package com.cpic.contacts.login.source.remote;

import android.support.annotation.NonNull;

import com.cpic.contacts.Constants;
import com.cpic.contacts.login.User;
import com.cpic.contacts.login.source.UserDataSource;
import com.cpic.contacts.utils.SharedPreferencesUtils;

/**
 * Created by Administrator on 2017/3/1.
 */

public class UserRemoteDataSource implements UserDataSource {
    private static UserRemoteDataSource INSTANCE;

    public static UserRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getUser(@NonNull String userName, GetUserCallback callback) {

    }

    @Override
    public void saveUser(@NonNull User user) {
        SharedPreferencesUtils.put(Constants.LOGIN_USER, user.toString());
    }
}
