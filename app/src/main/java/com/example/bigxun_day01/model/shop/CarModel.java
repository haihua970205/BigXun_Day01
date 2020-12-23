package com.example.bigxun_day01.model.shop;

import com.example.bigxun_day01.base.BaseModel;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.shopcar.ICar;
import com.example.bigxun_day01.net.CommonSubscriber;
import com.example.bigxun_day01.net.HttpManager;
import com.example.bigxun_day01.utils.RxUtils;

import java.util.Map;

public class CarModel extends BaseModel implements ICar.Model {
    @Override
    public void getCarList(Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().getCarList().
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<ShopCarDataBean>(callback) {
                    @Override
                    public void onNext(ShopCarDataBean carBean) {
                        callback.success(carBean);
                    }
                }));
    }
    /**
     * 更新购物车
     * @param map
     * @param callback
     */
    @Override
    public void updateCar(Map<String, String> map, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().updateCar(map).
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<UpdateCarBean>(callback) {
                    @Override
                    public void onNext(UpdateCarBean updateCarBean) {
                        callback.success(updateCarBean);
                    }
                }));
    }


    //删除购物车列表
    @Override
    public void deleteCar(String pIds, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().removeCar(pIds)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<DeleteCarBean>(callback) {
                    @Override
                    public void onNext(DeleteCarBean deleteCarBean) {
                        callback.success(deleteCarBean);
                    }
                }));
    }
}