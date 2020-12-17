package com.example.bigxun_day01.model.home;

import com.example.bigxun_day01.base.BaseModel;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.home.IHome;
import com.example.bigxun_day01.model.home.bean.HomeBean;
import com.example.bigxun_day01.net.CommonSubscriber;
import com.example.bigxun_day01.net.HttpManager;
import com.example.bigxun_day01.utils.RxUtils;

public class HomeModel extends BaseModel implements IHome.Model {

    @Override
    public void getHome(Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().getHome().
                compose(RxUtils.rxScheduler()).subscribeWith(new CommonSubscriber<HomeBean>(callback) {
            @Override
            public void onNext(HomeBean homeBean) {
                callback.success(homeBean);
            }
        }));
    }
}
