package com.example.bigxun_day01.model.test;


import com.example.bigxun_day01.base.BaseModel;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.test.ITest;
import com.example.bigxun_day01.net.CommonSubscriber;
import com.example.bigxun_day01.net.HttpManager;
import com.example.bigxun_day01.utils.RxUtils;

public class TestModel extends BaseModel implements ITest.Model {

    @Override
    public void getList(Callback callback) {
        addDisposible(HttpManager.getInstance().getService().getList()
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<TestBean>(callback) {
            @Override
            public void onNext(TestBean testBean) {
                callback.success(testBean);
            }
        }));
    }
}
