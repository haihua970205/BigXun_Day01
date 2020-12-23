package com.example.bigxun_day01.ui.loginactivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bigxun_day01.R;
import com.example.bigxun_day01.base.BaseActivity;
import com.example.bigxun_day01.interfaces.logicactivity.ILogin;
import com.example.bigxun_day01.model.logicactivity.LoginDataBean;
import com.example.bigxun_day01.presenter.logic.LogicPresenter;
import com.example.bigxun_day01.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<ILogin.Presenter> implements ILogin.View {
    @BindView(R.id.shop_username)
    EditText shopUsername;
    @BindView(R.id.pwd_imgnoer)
    ImageView pwdImgnoer;
    @BindView(R.id.shop_pwd)
    EditText shopPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.layout_pw)
    FrameLayout layoutPw;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected ILogin.Presenter createPrenter() {
        return new LogicPresenter();
    }

    @Override
    protected void initView() {
        pwdImgnoer.setTag(1);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void getShopCarReturn(LoginDataBean loginDataBean) {
        if (!TextUtils.isEmpty(loginDataBean.getData().getToken())) {
            String token = loginDataBean.getData().getToken();
            SpUtils.getInstance().setValue("token", token);
            SpUtils.getInstance().setValue("uid", loginDataBean.getData().getUserInfo().getUid());
            finish();
        }
    }

    @OnClick({R.id.pwd_imgnoer, R.id.btn_login, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pwd_imgnoer:
//                et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance()); //密码可见
//                et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());//密码不可见
                int tag = (int) pwdImgnoer.getTag();
                if (tag == 1) {
                    pwdImgnoer.setImageResource(R.mipmap.pwd_look);
                    pwdImgnoer.setTag(2);
                    //密码可见
                    shopPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    pwdImgnoer.setImageResource(R.mipmap.pwd_nore);
                    pwdImgnoer.setTag(1);
                    //密码不可见
                    shopPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

                break;
            case R.id.btn_login:
                String username = shopUsername.getText().toString();
                String pwd = shopPwd.getText().toString();
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(pwd)) {
                    presenter.getShopCar(username, pwd);
                } else {
                    Toast.makeText(this, "请输入真确的用户名与密码", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btn_register:

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}