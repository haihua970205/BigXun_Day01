package com.example.bigxun_day01.model.newshopinfo;

import com.example.bigxun_day01.base.BaseModel;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.newshopinfo.IShopInfo;
import com.example.bigxun_day01.net.CommonSubscriber;
import com.example.bigxun_day01.net.HttpManager;
import com.example.bigxun_day01.utils.RxUtils;

public class ShopInfoModel extends BaseModel implements IShopInfo.Model {
    @Override
    public void getShop(int id, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().getShopInfo(id).compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<ShopInfoBean>(callback) {
                    @Override
                    public void onNext(ShopInfoBean shopInfoBean) {
                        callback.success(shopInfoBean);
                    }
                })
        );
    }


    @Override
    public void getLookAll(int id, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().getLookAll(id).compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<ShopLookAllBean>(callback) {
                    @Override
                    public void onNext(ShopLookAllBean shopLookAllBean) {
                        callback.success(shopLookAllBean);
                    }
                })
        );
    }
}
