package com.example.bigxun_day01.interfaces.home;

import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.IBaseModel;
import com.example.bigxun_day01.interfaces.IBasePresenter;
import com.example.bigxun_day01.interfaces.IBaseView;
import com.example.bigxun_day01.model.home.bean.HomeBean;

public interface IHome {
    interface View extends IBaseView {
        void getHomeReturn(HomeBean homeBean);
    }

    interface Presenter extends IBasePresenter<IHome.View> {
        void getHome();
    }

    interface Model extends IBaseModel {
        void getHome(Callback callback);
    }
}
