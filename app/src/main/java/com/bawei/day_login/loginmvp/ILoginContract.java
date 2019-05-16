package com.bawei.day_login.loginmvp;

import android.content.Context;

import com.bawei.day_login.LoginActivity;
import com.bawei.day_login.net.CallBackPost;

/*
 *@Auther:cln
 *@Date: 2019/5/16
 *@Description:功能
 * */
public interface ILoginContract {
    public interface ILoginView{
        void onRegistSuccess(String result);
        void onLoginSuccess(String result);
    }
    public interface ILoginModel{
        void regist(Context context, String url, String username, String pswd, CallBackPost post);
        void login(Context context, String url, String username, String pswd, CallBackPost post);
    }
    public interface ILoginPresenter{
        void  attch(LoginActivity loginActivity);
        void  detch();
        void  login(Context context, String url, String phone, String pwd);
        void  reg(Context context, String url, String phone, String pwd);

    }
}
