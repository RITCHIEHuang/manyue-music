package com.wm.remusic.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.wm.remusic.R;
import com.wm.remusic.uitl.PermissionHelper;
import com.wm.remusic.uitl.UserPreferencesUtil;

/**
 * <p>开屏窗口</p>
 * Edited by Alian Lee on 2016-11-25.
 */
public class SplashActivity extends Activity {
    private Context mContext;
    private PermissionHelper mPermissionHelper;
    private static String TAG = "SplashActivity";
    private UserPreferencesUtil mUserPreferencesUtil;
    private Button mBtnLogin;
    private Button mBtnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mContext = this;

        mUserPreferencesUtil = UserPreferencesUtil.getInstance(this);
        // 设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 移除标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        // 当系统为6.0以上时，需要申请权限
        mPermissionHelper = new PermissionHelper(this);
        mPermissionHelper.setOnApplyPermissionListener(new PermissionHelper.OnApplyPermissionListener() {
            @Override
            public void onAfterApplyAllPermission() {
                Log.i(TAG, "All of requested permissions has been granted, so run app logic.");
            }
        });
        if (Build.VERSION.SDK_INT < 23) {
            // 如果系统版本低于23，直接跑应用的逻辑
            Log.d(TAG, "The api level of system is lower than 23, so run app logic directly.");
        } else {
            // 如果权限全部申请了，那就直接跑应用逻辑
            if (mPermissionHelper.isAllRequestedPermissionGranted()) {
                Log.d(TAG, "All of requested permissions has been granted, so run app logic directly.");
            } else {
                // 如果还有权限为申请，而且系统版本大于23，执行申请权限逻辑
                Log.i(TAG, "Some of requested permissions hasn't been granted, so apply permissions first.");
                mPermissionHelper.applyPermissions();
            }
        }


        initViews();
    }

    private void initViews() {
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnSignup = (Button) findViewById(R.id.btn_signup);


        if (mUserPreferencesUtil.getUsername().length() > 0 && mUserPreferencesUtil.getPassword().length() > 0) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }


    public void signup(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }


    public void login(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mPermissionHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPermissionHelper.onActivityResult(requestCode, resultCode, data);
    }

}
