package com.android.contacts.utils;


/**
 * Created by JAMES on 2016/8/1.
 */
public class GlobalHandler extends LeakGuardHandlerWrapper<Object> {

    public GlobalHandler() {
        super(new Object());
    }
}
