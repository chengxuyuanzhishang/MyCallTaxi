package com.zyw.driver.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zyw.driver.R;
import com.zyw.driver.utils.ToastUtils;

/**
 * Created by zyw on 2015/11/8.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String SP_USER_NAME = "sp_name";

    public static final String SP_PHONE_NUMBER = "sp_phone_number";

    public static final String EXTRA_NAME = "extra_name";

    public static final String EXTRA_PHONE_NUMBER = "extra_phone_number";

    public static final String EXTRA_ADRESS = "extra_adress";
    public static final String EXTRA_DISTANCE = "extra_distance";
    public static final String EXTRA_DEST_DISTANCE = "extra_dest_distance";

    private EditText mEtName;

    private EditText mEtPhoneNumber;

    private Button mBtnLogin;

    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mSharedPreferences = getSharedPreferences("CallTaxi", Context.MODE_PRIVATE);
        initViews();
    }

    private void initViews() {
        mEtName = (EditText) findViewById(R.id.et_user_name);
        mEtPhoneNumber = (EditText) findViewById(R.id.et_phone_number);

        String userName = mSharedPreferences.getString(SP_USER_NAME, "");
        String phoneNumber = mSharedPreferences.getString(SP_PHONE_NUMBER, "");
        if (!TextUtils.isEmpty(userName)) {
            mEtName.setText(userName);
        }
        if (!TextUtils.isEmpty(phoneNumber)) {
            mEtPhoneNumber.setText(phoneNumber);
        }
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        saveUserInfo();
        login();
        finish();
    }

    /**
     * 保存用户的信息到SharedPreferences
     */
    private void saveUserInfo() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(SP_USER_NAME, mEtName.getText().toString());
        editor.putString(SP_PHONE_NUMBER, mEtPhoneNumber.getText().toString());
        editor.commit();
    }

    private void login() {
        String name = mEtName.getText().toString();
        String phoneNumber = mEtPhoneNumber.getText().toString();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phoneNumber)) {
            ToastUtils.showToast(this, "请输入用户名和手机号！");
            return;
        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_PHONE_NUMBER, phoneNumber);
        startActivity(intent);
    }
}
