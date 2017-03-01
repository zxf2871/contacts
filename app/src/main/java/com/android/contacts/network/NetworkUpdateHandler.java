// Copyright (c) 2016 The HAWK Inc. All rights reserved.
// Author: kingsonfan@hawk.com.

package com.android.contacts.network;

import android.content.Context;
import android.text.TextUtils;

import com.android.contacts.thread.UpdateHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class NetworkUpdateHandler extends UpdateHandler {

    private List<NameValuePair> mParams = null;

    public NetworkUpdateHandler(Context context) {
        super(context);
    }

    @Override
    public void doUpdateBefore() {
        super.doUpdateBefore();
        setDefaultParams();
    }

    protected void setDefaultParams() {
        if (mParams == null) {
            mParams = new ArrayList<>();
        }

        mParams.add(new NameValuePair("dit", ""));
    }

    protected void setParams(String name, String value) {
        if (mParams == null) {
            mParams = new ArrayList<>();
        }
        if (TextUtils.isEmpty(name)) return;
        mParams.add(new NameValuePair(name, value));
    }

    protected void setParams(Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            setParams(entry.getKey(), entry.getValue());
        }
    }

    protected List<NameValuePair> getParams() {
        return mParams;
    }


}
