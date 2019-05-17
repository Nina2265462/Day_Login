package com.bawei.day_login;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.day_login.fragment.HomeFragment;
import com.bawei.day_login.fragment.MyFragment;
import com.bawei.day_login.fragment.NewsFragment;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        pager = findViewById(R.id.pager);
        tab = findViewById(R.id.tab);
        final ArrayList<String> tlist = new ArrayList<>();
        tlist.add("首页");
        tlist.add("资讯");
        tlist.add("我的");
        tab.addTab(tab.newTab().setText(tlist.get(0)));
        tab.addTab(tab.newTab().setText(tlist.get(1)));
        tab.addTab(tab.newTab().setText(tlist.get(2)));
        final ArrayList<Fragment> flist = new ArrayList<>();
        flist.add(new HomeFragment());
        flist.add(new NewsFragment());
        flist.add(new MyFragment());
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return flist.get(i);
            }

            @Override
            public int getCount() {
                return flist.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tlist.get(position);
            }
        });
        tab.setupWithViewPager(pager);
    }
}
