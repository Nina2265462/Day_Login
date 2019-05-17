package com.bawei.day_login.loginmvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.day_login.Api;
import com.bawei.day_login.FirstActivity;
import com.bawei.day_login.R;
import com.bawei.day_login.net.HTTPUntil;

public class LoginActivity extends AppCompatActivity implements ILoginContract.ILoginView {

    private EditText pwd;
    private EditText phone;
    private Button reg;
    private Button log;
    private ILoginContract.ILoginPresenter presenter;
   // private String str = "http://172.17.8.100/small/user/v1/login";
   // private String registUrl = "http://172.17.8.100/small/user/v1/register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //判断是否有网络
        if (HTTPUntil.getInstance().isNetWork(LoginActivity.this)) {
            Toast.makeText(LoginActivity.this, "有网络哦", Toast.LENGTH_SHORT).show();
        }
        //找控件
        phone = findViewById(R.id.phone);
        pwd = findViewById(R.id.pwd);
        reg = findViewById(R.id.reg);
        log = findViewById(R.id.log);
        presenter = new LoginPresent();
        presenter.attch(this);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.reg(LoginActivity.this, Api.REGURL, phone.getText().toString(), pwd.getText().toString());
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(LoginActivity.this,Api.LOGURL, phone.getText().toString(), pwd.getText().toString());
            }
        });
    }


    @Override
    public void onRegistSuccess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, FirstActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detch();
    }

}
