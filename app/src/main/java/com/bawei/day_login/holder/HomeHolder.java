package com.bawei.day_login.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.day_login.R;

/*
 *@Auther:cln
 *@Date: 2019/5/17
 *@Description:功能
 * */
public class HomeHolder extends RecyclerView.ViewHolder {

    public ImageView img;
    public TextView tv;

    public HomeHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img);
        tv = itemView.findViewById(R.id.tv);
    }
}
