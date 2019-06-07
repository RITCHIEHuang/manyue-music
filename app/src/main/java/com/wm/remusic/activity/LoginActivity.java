package com.wm.remusic.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wm.remusic.R;
import com.wm.remusic.uitl.UserPreferencesUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";
    private ImageView mImageView;
    private EditText mEdtUsername;
    private EditText mEdtPassword;
    private ImageButton mPasswordSwitcher;
    private Button mBtnLogin;
    private TextView mTextSignup;

    private String username;
    private String password;

    private UserPreferencesUtil mUserPreferencesUtil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUserPreferencesUtil = UserPreferencesUtil.getInstance(this);

        initViews();
        initDatas();

    }

    private void initDatas() {
        Bundle bundle;
        bundle = getIntent().getExtras();
        if (bundle != null) {
            username = bundle.getString(UserPreferencesUtil.USER_NAME, "");
            password = bundle.getString(UserPreferencesUtil.PASSWORD, "");

            mEdtUsername.setText(username);
            mEdtPassword.setText(password);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initViews() {
        mImageView = (ImageView) findViewById(R.id.image_navigation);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mEdtUsername = (EditText) findViewById(R.id.et_username);
        mEdtPassword = (EditText) findViewById(R.id.et_password);
        mPasswordSwitcher = (ImageButton) findViewById(R.id.pwd_switcher);

        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mTextSignup = (TextView) findViewById(R.id.sign_up);

        mBtnLogin.setOnClickListener(this);
        mTextSignup.setOnClickListener(this);


        mPasswordSwitcher.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                password = mEdtPassword.getText().toString().trim();
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        mEdtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//密码显示
                        mEdtPassword.setSelection(password.length());//但是密码显示后，文本光标会跑到开头去，重新在文本末获取一下光标
                        break;
                    case MotionEvent.ACTION_UP:
                        mEdtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());//密码隐藏
                        mEdtPassword.setSelection(password.length());
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:

                login();

                break;
            case R.id.sign_up:

                gotoSignup();

                break;


            default:
                break;
        }
    }


    private void gotoSignup() {
        startActivity(new Intent(this, SignUpActivity.class));
    }

    private void login() {
        username = mEdtUsername.getText().toString().trim();
        password = mEdtPassword.getText().toString().trim();

        Log.d(TAG, "login: " + username + " , " + password);

        if (username.equals(mUserPreferencesUtil.getUsername())
                && password.equals(mUserPreferencesUtil.getPassword())) {
            startActivity(new Intent(this, MainActivity.class));
        } else {
            Toast.makeText(this, "用户名或密码有错 :(", Toast.LENGTH_SHORT).show();
        }

    }
}
