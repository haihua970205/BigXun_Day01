package com.example.bigxun_day01.presenter.shop;

import android.util.Log;

import com.example.bigxun_day01.base.BasePresenter;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.shopcar.ICar;
import com.example.bigxun_day01.model.shop.CarModel;
import com.example.bigxun_day01.model.shop.DeleteCarBean;
import com.example.bigxun_day01.model.shop.ShopCarDataBean;
import com.example.bigxun_day01.model.shop.UpdateCarBean;

import java.util.Map;

public class CarPresenter extends BasePresenter<ICar.View> implements ICar.Presenter {

    ICar.Model model;

    public CarPresenter() {
        model = new CarModel();
    }

    @Override
    public void getCarList() {
        model.getCarList(new Callback<ShopCarDataBean>() {
            @Override
            public void success(ShopCarDataBean data) {
                if (mView != null) {
                    mView.getCarListReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    //更新购物车
    @Override
    public void updateCar(Map<String, String> map) {
        model.updateCar(map, new Callback<UpdateCarBean>() {
            @Override
            public void success(UpdateCarBean data) {
                if (mView != null) {
                    mView.updateCarReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    // 删除购物车列表
    @Override
    public void deleteCar(String pIds) {
        model.deleteCar(pIds, new Callback<DeleteCarBean>() {
            @Override
            public void success(DeleteCarBean data) {
                if (mView != null) {
                    Log.i("TAG", "CarPresenter delete return:");
                    mView.deleteCarReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}