package com.bawei.day_login.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bawei.day_login.MyApp;

import java.util.Map;

/*
 *@Auther:cln
 *@Date: 2019/5/16
 *@Description:功能
 * */
public class HTTPUntil {
    private static final HTTPUntil ourInstance = new HTTPUntil();
    private StringRequest request;
    private ConnectivityManager manager;

    public static HTTPUntil getInstance() {
        return ourInstance;
    }

    private HTTPUntil() {
    }

    public boolean isNetWork(Context context) {
        manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info == null) {
            info.isAvailable();
        }
        return false;
    }

    //get请求
    public void doHttpGet(String surl, final CallBackPost post) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, surl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                post.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                post.onFail(error.getMessage());
            }
        });
        MyApp.getQueue().add(stringRequest);
    }

    //post请求
    public void doHttpPost(String surl, final CallBackPost post, final Map<String, String> map) {
        request = new StringRequest(Request.Method.POST, surl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                post.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        MyApp.getQueue().add(request);
    }
}
