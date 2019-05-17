package com.bawei.day_login.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bawei.day_login.Api;
import com.bawei.day_login.R;
import com.bawei.day_login.adapter.HomeAdapter;
import com.bawei.day_login.bean.ItemBean;
import com.bawei.day_login.homemvp.HomePresenter;
import com.bawei.day_login.homemvp.IHomeContract;
import com.google.gson.Gson;

import java.util.List;

/*
 *@Auther:cln
 *@Date: 2019/5/17
 *@Description:功能
 * */
public class HomeFragment extends Fragment implements IHomeContract.IHomeView {

    private RecyclerView recycle;
    private IHomeContract.IHomePresenter presenter;
    private LinearLayoutManager manager;
    private ItemBean item;
    private List<ItemBean.ResultBean.PzshBean.CommodityListBeanX> pzshlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_layout, container, false);
        recycle = view.findViewById(R.id.recycler);
        presenter = new HomePresenter();
        presenter.attach(this);
        presenter.ShowData(Api.ITEM);
        //初始化布局管理器
        manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        //添加布局管理器
        recycle.setLayoutManager(manager);
        return view;
    }

    @Override
    public void getHomePreData(String data) {
        //Toast.makeText(getContext(), ""+data, Toast.LENGTH_SHORT).show();
        //Gson解析
        Gson gson = new Gson();
        item = gson.fromJson(data, ItemBean.class);
        pzshlist = item.getResult().getPzsh().getCommodityList();
        if (pzshlist != null) {
            recycle.setAdapter(new HomeAdapter(getContext(), pzshlist));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dattach();
    }
}
