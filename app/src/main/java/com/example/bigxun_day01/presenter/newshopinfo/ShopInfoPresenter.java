package com.example.bigxun_day01.presenter.newshopinfo;

import com.example.bigxun_day01.base.BasePresenter;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.newshopinfo.IShopInfo;
import com.example.bigxun_day01.model.newshopinfo.ShopInfoBean;
import com.example.bigxun_day01.model.newshopinfo.ShopInfoModel;
import com.example.bigxun_day01.model.newshopinfo.ShopLookAllBean;
import com.example.bigxun_day01.model.shop.AddCarBean;
import com.example.bigxun_day01.model.shop.ShopCarDataBean;

import java.util.Map;

public class ShopInfoPresenter extends BasePresenter<IShopInfo.View> implements IShopInfo.Presenter {

    private IShopInfo.Model model;

    public ShopInfoPresenter() {
        model = new ShopInfoModel();
    }

    @Override
    public void getShop(int id) {
        model.getShop(id, new Callback<ShopInfoBean>() {
            @Override
            public void success(ShopInfoBean data) {
                if (mView != null) {
                    mView.getShopReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void getLookAll(int id) {
        model.getLookAll(id, new Callback<ShopLookAllBean>() {
            @Override
            public void success(ShopLookAllBean data) {
                if (mView != null) {
                    mView.getLookAllReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    // 添加到购物车
    @Override
    public void addGoodCar(Map<String, String> map) {
        model.addGoodCar(map, new Callback<AddCarBean>() {
            @Override
            public void success(AddCarBean data) {
                if(mView != null){
                    mView.addGoodCarReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void getCarList() {
        model.getCarList(new Callback<ShopCarDataBean>() {
            @Override
            public void success(ShopCarDataBean data) {
                if (mView != null){
                    mView.getCarListReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

}
