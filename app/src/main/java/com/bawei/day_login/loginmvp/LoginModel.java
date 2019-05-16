package com.bawei.day_login.loginmvp;

import android.content.Context;
import android.util.Log;

import com.bawei.day_login.net.CallBackPost;
import com.bawei.day_login.net.HTTPUntil;

import java.util.HashMap;
import java.util.Map;

/*
 *@Auther:cln
 *@Date: 2019/5/16
 *@Description:功能
 * */
public class LoginModel implements ILoginContract.ILoginModel {

    private final HTTPUntil until;
    private Map<String, String> map;

    public LoginModel() {
        until = HTTPUntil.getInstance();
    }

    @Override
    public void regist(Context context, String url, final String phone, String pwd, final CallBackPost post) {
        map = new HashMap<>();
        map.put("phone", phone);
        map.put("pwd", pwd);
        until.doHttpPost(url, new CallBackPost() {

            @Override
            public void onSuccess(String outcome) {
                Log.d("LoginModel", "onSuccess: " + outcome);
                post.onSuccess(outcome);
            }

            @Override
            public void onFail(String mgs) {

            }
        }, map);
    }

    @Override
    public void login(Context context, String url, final String phone, String pwd, final CallBackPost post) {
        map = new HashMap<>();
        map.put("phone", phone);
        map.put("pwd", pwd);
        until.doHttpPost(url, new CallBackPost() {

            @Override
            public void onSuccess(String outcome) {
                Log.d("LoginModel", "onSuccess: " + outcome);
                post.onSuccess(outcome);
            }

            @Override
            public void onFail(String mgs) {

            }
        }, map);
    }
}
