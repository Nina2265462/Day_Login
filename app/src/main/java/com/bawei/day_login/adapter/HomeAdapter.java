package com.bawei.day_login.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.day_login.R;
import com.bawei.day_login.bean.ItemBean;
import com.bawei.day_login.holder.HomeHolder;
import com.bumptech.glide.Glide;

import java.util.List;

/*
 *@Auther:cln
 *@Date: 2019/5/17
 *@Description:功能
 * */
public class HomeAdapter extends RecyclerView.Adapter<HomeHolder> {
    private Context context;
    private List<ItemBean.ResultBean.PzshBean.CommodityListBeanX> pzshlist;
    private View inflate;

    //构造器
    public HomeAdapter(Context context, List<ItemBean.ResultBean.PzshBean.CommodityListBeanX> pzshlist) {
        this.context = context;
        this.pzshlist = pzshlist;
    }

    //初始化视图
    @Override
    public HomeHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        inflate = LayoutInflater.from(context).inflate(R.layout.horitem_layout, viewGroup, false);
        return new HomeHolder(inflate);
    }

    //绑定视图
    @Override
    public void onBindViewHolder(HomeHolder homeHolder, int i) {
        homeHolder.tv.setText(pzshlist.get(i).getCommodityName());
        Glide.with(context).load(pzshlist.get(i).getMasterPic()).into(homeHolder.img);
    }

    //获取总数据
    @Override
    public int getItemCount() {
        return pzshlist.size();
    }
}
