package com.cpic.contacts.login;

import com.cpic.contacts.base.BasePresenter;
import com.cpic.contacts.base.BaseView;

/**
 * Created by Administrator on 2017/3/1.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        void login(String userName);
        void loginSuccess();
        void loginError(String massage);
    }
}
