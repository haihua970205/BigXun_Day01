package com.example.bigxun_day01.interfaces.lookactivityinterface;

import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.IBaseModel;
import com.example.bigxun_day01.interfaces.IBasePresenter;
import com.example.bigxun_day01.interfaces.IBaseView;
import com.example.bigxun_day01.interfaces.home.IHome;
import com.example.bigxun_day01.model.lookactivitybean.LookTabBean;

public interface ILookAct {
    interface View extends IBaseView {
        void getTab(LookTabBean lookTabBean);

    }
    interface Presenter extends IBasePresenter<ILookAct.View> {
        void getTab(int id);
    }

    interface Model extends IBaseModel {
        void getTab(int id,Callback callback);
    }
}
