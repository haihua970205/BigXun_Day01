package com.example.bigxun_day01.interfaces;

import com.example.bigxun_day01.interfaces.home.IHome;
import com.example.bigxun_day01.model.home.bean.HomeBean;
import com.example.bigxun_day01.ui.sort.InfoTabDataBean;
import com.example.bigxun_day01.ui.sort.VerTabBean;

public interface ISort {
    interface View extends IBaseView {
        void getTabReturn(VerTabBean verTabBean);
        void getInfoTabReturn(InfoTabDataBean infoTabDataBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void getTab();
        void getInfoTab(int id);
    }

    interface Model extends IBaseModel {
        void getTab(Callback callback);
        void getInfoTab(int id,Callback callback);
    }
}
