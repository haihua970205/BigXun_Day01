package com.example.bigxun_day01.interfaces.newshopinfo;

import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.IBaseModel;
import com.example.bigxun_day01.interfaces.IBasePresenter;
import com.example.bigxun_day01.interfaces.IBaseView;
import com.example.bigxun_day01.interfaces.home.IHome;
import com.example.bigxun_day01.model.home.bean.HomeBean;
import com.example.bigxun_day01.model.newshopinfo.ShopInfoBean;
import com.example.bigxun_day01.model.newshopinfo.ShopLookAllBean;

public interface IShopInfo {
    interface View extends IBaseView {
        void getShopReturn(ShopInfoBean shopInfoBean);
        void getLookAllReturn(ShopLookAllBean shopLookAllBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void getShop(int id);
        void getLookAll(int id);
    }

    interface Model extends IBaseModel {
        void getShop(int id,Callback callback);
        void getLookAll(int id,Callback callback);
    }
}
