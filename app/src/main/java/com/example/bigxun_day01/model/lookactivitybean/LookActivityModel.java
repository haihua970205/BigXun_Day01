package com.example.bigxun_day01.model.lookactivitybean;

import com.example.bigxun_day01.base.BaseModel;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.lookactivityinterface.ILookAct;
import com.example.bigxun_day01.net.CommonSubscriber;
import com.example.bigxun_day01.net.HttpManager;
import com.example.bigxun_day01.utils.RxUtils;

public class LookActivityModel extends BaseModel implements ILookAct.Model {

    @Override
    public void getTab(int id, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().getTabData(id).compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<LookTabBean>(callback) {
            @Override
            public void onNext(LookTabBean lookTabBean) {
                callback.success(lookTabBean);
            }
        })
        );
    }
}
