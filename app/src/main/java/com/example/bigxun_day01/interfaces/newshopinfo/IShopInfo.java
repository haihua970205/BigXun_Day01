package com.example.bigxun_day01.interfaces.newshopinfo;

import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.IBaseModel;
import com.example.bigxun_day01.interfaces.IBasePresenter;
import com.example.bigxun_day01.interfaces.IBaseView;
import com.example.bigxun_day01.interfaces.home.IHome;
import com.example.bigxun_day01.model.home.bean.HomeBean;
import com.example.bigxun_day01.model.newshopinfo.ShopInfoBean;
import com.example.bigxun_day01.model.newshopinfo.ShopLookAllBean;
import com.example.bigxun_day01.model.shop.AddCarBean;
import com.example.bigxun_day01.model.shop.ShopCarDataBean;

import java.util.Map;

public interface IShopInfo {
    interface View extends IBaseView {
        void getShopReturn(ShopInfoBean shopInfoBean);
        void getLookAllReturn(ShopLookAllBean shopLookAllBean);
        void addGoodCarReturn(AddCarBean addCarBean);
        void getCarListReturn(ShopCarDataBean carBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void getShop(int id);
        void getLookAll(int id);
        //添加进购物车
        void addGoodCar(Map<String,String> map);
        void getCarList();
    }

    interface Model extends IBaseModel {
        void getShop(int id,Callback callback);
        void getLookAll(int id,Callback callback);
        //添加进购物车
        void addGoodCar(Map<String,String> map,Callback callback);
        void getCarList(Callback callback);
    }
}
