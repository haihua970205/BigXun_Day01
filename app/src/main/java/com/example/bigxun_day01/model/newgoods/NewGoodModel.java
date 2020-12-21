package com.example.bigxun_day01.model.newgoods;

import com.example.bigxun_day01.base.BaseModel;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.newgoods.NewGood;
import com.example.bigxun_day01.net.CommonSubscriber;
import com.example.bigxun_day01.net.HttpManager;
import com.example.bigxun_day01.utils.RxUtils;

import java.util.Map;

import io.reactivex.disposables.Disposable;

public class NewGoodModel extends BaseModel implements NewGood.NewGoodModel {
    @Override
    public void loadTopBackground(Callback callback) {
        Disposable disposable = HttpManager.getInstance().getShopApi().getNewGoodFirstBean()
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<NewGoodFristBean>(callback) {
                            @Override
                            public void onNext(NewGoodFristBean result) {
                                callback.success(result);
                            }
                        });
               addDisposible(disposable);
    }

    @Override
    public void loadNewGoodOlderBean(Map<String,String> map,Callback callback) {
        Disposable disposable = HttpManager.getInstance().getShopApi().getNewGoodOlderBean(map)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<NewGoodOlderBean>(callback) {
                    @Override
                    public void onNext(NewGoodOlderBean result) {
                        callback.success(result);
                    }
                });
        addDisposible(disposable);
    }

    @Override
    public void loadNewGoodAllBean(Map<String, String> map, Callback callback) {
        Disposable disposable = HttpManager.getInstance().getShopApi().getNewGoodAllBean(map)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<NewGoodAllBean>(callback) {
                    @Override
                    public void onNext(NewGoodAllBean result) {
                        callback.success(result);
                    }
                });
        addDisposible(disposable);
    }
}
