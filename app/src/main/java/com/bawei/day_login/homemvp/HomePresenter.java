package com.bawei.day_login.homemvp;

import com.bawei.day_login.net.CallBackPost;

/*
 *@Auther:cln
 *@Date: 2019/5/17
 *@Description:功能
 * */
public class HomePresenter implements IHomeContract.IHomePresenter {

    private IHomeContract.IHomeView iHomeView;
    private IHomeContract.IHomeModel model;

    @Override
    public void attach(IHomeContract.IHomeView homeView) {
        iHomeView = homeView;
        model = new HomeModel();
    }

    @Override
    public void dattach() {
        if (iHomeView != null) {
            iHomeView = null;
        }
        if (model != null) {
            model = null;
        }
    }

    @Override
    public void ShowData(String surl) {
        model.getRequest(surl, new CallBackPost() {
            @Override
            public void onSuccess(String outcome) {
                iHomeView.getHomePreData(outcome);
            }

            @Override
            public void onFail(String mgs) {

            }
        });
    }
}
