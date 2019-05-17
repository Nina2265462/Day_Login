package com.bawei.day_login.homemvp;

import com.bawei.day_login.net.CallBackPost;

/*
 *@Auther:cln
 *@Date: 2019/5/17
 *@Description:功能
 * */
public interface IHomeContract {
    public interface IHomeView {
        //获取presenter数据
        void getHomePreData(String data);
    }

    public interface IHomeModel {
        //请求网络数据
        void getRequest(String surl, CallBackPost post);
    }

    public interface IHomePresenter {
        void attach(IHomeView homeView);

        void dattach();

        //获取主页数据
        void ShowData(String surl);
    }
}
