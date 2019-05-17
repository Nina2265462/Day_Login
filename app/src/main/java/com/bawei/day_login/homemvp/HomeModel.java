package com.bawei.day_login.homemvp;

import com.bawei.day_login.net.CallBackPost;
import com.bawei.day_login.net.HTTPUntil;

/*
 *@Auther:cln
 *@Date: 2019/5/17
 *@Description:功能
 * */
public class HomeModel implements IHomeContract.IHomeModel {

    private final HTTPUntil until;

    public HomeModel() {
        until = HTTPUntil.getInstance();
    }

    @Override
    public void getRequest(String surl, CallBackPost post) {
        until.doHttpGet(surl,post);
    }
}
