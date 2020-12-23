package com.example.bigxun_day01.interfaces.logicactivity;

import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.IBaseModel;
import com.example.bigxun_day01.interfaces.IBasePresenter;
import com.example.bigxun_day01.interfaces.IBaseView;
import com.example.bigxun_day01.model.logicactivity.LoginDataBean;

public interface ILogin {
    interface View extends IBaseView {
        void getShopCarReturn(LoginDataBean loginDataBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void getShopCar(String username,String pwd);
    }

    interface Model extends IBaseModel {
        void getShopCar(String username, String pwd, Callback callback);
    }
}
