package com.example.bigxun_day01.model.brand;

import com.example.bigxun_day01.base.BaseModel;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.brandinfo.IBrand;
import com.example.bigxun_day01.net.CommonSubscriber;
import com.example.bigxun_day01.net.HttpManager;
import com.example.bigxun_day01.utils.RxUtils;

public class InfoBrandModel extends BaseModel implements IBrand.Model {
    @Override
    public void getBrand(int page, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().getBrand(page).
                compose(RxUtils.rxScheduler()).subscribeWith(new CommonSubscriber<BrandListBean>(callback) {
            @Override
            public void onNext(BrandListBean brandListBean) {
                callback.success(brandListBean);
            }
        }));
    }

    @Override
    public void getInfo(int id, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().getInfoBrand(id).
                compose(RxUtils.rxScheduler()).subscribeWith(new CommonSubscriber<InfoBrandBean>(callback) {
            @Override
            public void onNext(InfoBrandBean infoBrandBean) {
                callback.success(infoBrandBean);
            }
        }));
    }
}
