package com.example.bigxun_day01.model.logicactivity;

import com.example.bigxun_day01.base.BaseModel;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.logicactivity.ILogin;
import com.example.bigxun_day01.net.CommonSubscriber;
import com.example.bigxun_day01.net.HttpManager;
import com.example.bigxun_day01.utils.RxUtils;

public class LoginCarModel extends BaseModel implements ILogin.Model {
    @Override
    public void getShopCar(String username, String pwd, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().login(username, pwd)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<LoginDataBean>(callback) {
                    @Override
                    public void onNext(LoginDataBean loginDataBean) {
                        callback.success(loginDataBean);
                    }
                })
        );
    }
}
