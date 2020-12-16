package com.example.bigxun_day01.interfaces.test;


import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.IBaseModel;
import com.example.bigxun_day01.interfaces.IBasePresenter;
import com.example.bigxun_day01.interfaces.IBaseView;
import com.example.bigxun_day01.model.test.TestBean;

public interface ITest {

    interface View extends IBaseView {
        void getListReturn(TestBean testBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void getList();
    }


    interface Model extends IBaseModel {
        void getList(Callback callback);
    }

}
