package com.example.bigxun_day01.presenter.logic;

import com.example.bigxun_day01.base.BasePresenter;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.logicactivity.ILogin;
import com.example.bigxun_day01.model.logicactivity.LoginCarModel;
import com.example.bigxun_day01.model.logicactivity.LoginDataBean;

public class LogicPresenter extends BasePresenter<ILogin.View> implements ILogin.Presenter {
    private ILogin.Model model;

    public LogicPresenter() {
        model = new LoginCarModel();
    }

    @Override
    public void getShopCar(String username, String pwd) {
        model.getShopCar(username, pwd, new Callback<LoginDataBean>() {
            @Override
            public void success(LoginDataBean data) {
                if (mView != null) {
                    mView.getShopCarReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
