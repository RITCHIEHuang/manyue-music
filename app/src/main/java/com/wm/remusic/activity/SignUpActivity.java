package com.wm.remusic.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import org.w3c.dom.Text;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SignUpActivity";
    private ImageView mImageView;

    private EditText mEdtUsername;
    private EditText mEdtPassword;
    private Button mBtnSignup;
    private TextView mTextLogin;
    private ImageButton mPasswordSwitcher;

    private String username;
    private String password;


    private UserPreferencesUtil mUserPreferencesUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        mUserPreferencesUtil = UserPreferencesUtil.getInstance(this);

        initViews();
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
        mBtnSignup = (Button) findViewById(R.id.btn_signup);
        mTextLogin = (TextView) findViewById(R.id.login);

        mBtnSignup.setOnClickListener(this);
        mTextLogin.setOnClickListener(this);
        mPasswordSwitcher = (ImageButton) findViewById(R.id.pwd_switcher);


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
            case R.id.btn_signup:

                signUp();
                break;
            case R.id.login:
                gotoLogin(null);
                break;

            default:
                break;


        }
    }

    private void gotoLogin(Bundle bundle) {
        Intent intent = new Intent(this, LoginActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    private void signUp() {
        username = mEdtUsername.getText().toString().trim();
        password = mEdtPassword.getText().toString().trim();


        if (username != null && username.length() > 0 && password != null && password.length() > 0) {

            mUserPreferencesUtil.setUserName(username);
            mUserPreferencesUtil.setPassword(password);

            Toast.makeText(this, "注册成功 :)", Toast.LENGTH_SHORT).show();

            Bundle bundle = new Bundle();
            bundle.putString(UserPreferencesUtil.USER_NAME, username);
            bundle.putString(UserPreferencesUtil.PASSWORD, password);

            gotoLogin(bundle);
        } else {

            Toast.makeText(this, "请填写用户信息!!!", Toast.LENGTH_SHORT).show();
        }

    }
}
