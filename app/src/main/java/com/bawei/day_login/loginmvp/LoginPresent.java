package com.bawei.day_login.loginmvp;

import android.content.Context;

import com.bawei.day_login.net.CallBackPost;

/*
 *@Auther:cln
 *@Date: 2019/5/16
 *@Description:功能
 * */
public class LoginPresent implements ILoginContract.ILoginPresenter {

    private ILoginContract.ILoginView loginView;
    private ILoginContract.ILoginModel model;

    @Override
    public void attch(LoginActivity loginActivity) {
        loginView = (ILoginContract.ILoginView) loginActivity;
        model = new LoginModel();
    }

    @Override
    public void detch() {
        if (loginView != null) {
            loginView = null;
        }
        if (model != null) {
            model = null;
        }
    }

    @Override
    public void login(Context context, String url, String phone, String pwd) {
        model.login(context, url, phone, pwd, new CallBackPost() {
            @Override
            public void onSuccess(String outcome) {
                loginView.onLoginSuccess(outcome);
            }

            @Override
            public void onFail(String mgs) {

            }
        });
    }

    @Override
    public void reg(Context context, String url, String phone, String pwd) {
        model.regist(context, url, phone, pwd, new CallBackPost() {
            @Override
            public void onSuccess(String outcome) {
                loginView.onRegistSuccess(outcome);
            }

            @Override
            public void onFail(String mgs) {

            }
        });
    }
}
