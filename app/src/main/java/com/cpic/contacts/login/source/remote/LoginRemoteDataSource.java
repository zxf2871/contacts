package com.cpic.contacts.login.source.remote;

import android.support.annotation.NonNull;

import com.cpic.contacts.Constants;
import com.cpic.contacts.ContactsApplication;
import com.cpic.contacts.login.User;
import com.cpic.contacts.login.source.LoginDataSource;
import com.cpic.contacts.network.NetworkUpdateHandler;
import com.cpic.contacts.thread.ThreadServices;
import com.cpic.contacts.utils.SharedPreferencesUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/1.
 */

public class LoginRemoteDataSource implements LoginDataSource {
    private static LoginRemoteDataSource INSTANCE;

    public static LoginRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LoginRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void login(@NonNull String userName, @NonNull String password, LoginCallback callback) {
        Map<String,String> params = new HashMap<>();
        params.put("username",userName);
        params.put("password",password);
        ThreadServices.getInstance().updateServices(new NetworkUpdateHandler(ContactsApplication.getInstance(), Constants.LOGIN_URL, params) {

            @Override
            protected boolean analyseResponse(String response) {
                return false;
            }

            @Override
            protected boolean success(String response) {
                return false;
            }

            @Override
            protected boolean fail(int code) {
                return false;
            }
        });
    }

    @Override
    public void saveLogin(@NonNull String token) {
        SharedPreferencesUtils.put(Constants.LOGIN_USER, token);
    }
}
