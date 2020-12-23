package com.example.bigxun_day01.interfaces.shopcar;

import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.IBaseModel;
import com.example.bigxun_day01.interfaces.IBasePresenter;
import com.example.bigxun_day01.interfaces.IBaseView;
import com.example.bigxun_day01.model.shop.DeleteCarBean;
import com.example.bigxun_day01.model.shop.ShopCarDataBean;
import com.example.bigxun_day01.model.shop.UpdateCarBean;

import java.util.Map;

public interface ICar {
    interface View extends IBaseView {
        void getCarListReturn(ShopCarDataBean carBean);
        //更新 购物车
        void updateCarReturn(UpdateCarBean result);

        //删除购物车
        void deleteCarReturn(DeleteCarBean result);
    }

    interface Presenter extends IBasePresenter<View> {
        void getCarList();
        //更新购物车的数据
        void  updateCar(Map<String,String> map);

        //删除购物车列表
        void deleteCar(String pIds);
    }


    interface Model extends IBaseModel {
        void getCarList(Callback callback);

        void updateCar(Map<String,String> map,Callback callback);

        void deleteCar(String pIds,Callback callback);
    }
}
