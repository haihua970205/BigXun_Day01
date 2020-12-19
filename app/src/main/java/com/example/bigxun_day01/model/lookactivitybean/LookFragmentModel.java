package com.example.bigxun_day01.model.lookactivitybean;

import com.example.bigxun_day01.base.BaseModel;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.lookactivityinterface.ILookFragment;
import com.example.bigxun_day01.net.CommonSubscriber;
import com.example.bigxun_day01.net.HttpManager;
import com.example.bigxun_day01.utils.RxUtils;

public class LookFragmentModel extends BaseModel implements ILookFragment.Model {
    @Override
    public void getFragList(int id, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().getListData(id)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<LookInfoFragmentBean>(callback) {
                    @Override
                    public void onNext(LookInfoFragmentBean lookInfoFragmentBean) {
                        callback.success(lookInfoFragmentBean);
                    }
                })
        );
    }
}
