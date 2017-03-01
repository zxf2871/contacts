package com.cpic.contacts;

import android.app.Application;

import com.cpic.contacts.utils.GlobalHandler;

public class ContactsApplication extends Application {
    private static ContactsApplication mInstance;
    private GlobalHandler mGlobalHandler;
    public static ContactsApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mGlobalHandler = new GlobalHandler();
    }
    public GlobalHandler getGlobalHandler() {
        return mGlobalHandler;
    }

}
