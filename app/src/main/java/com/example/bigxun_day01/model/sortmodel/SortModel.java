package com.example.bigxun_day01.model.sortmodel;

import com.example.bigxun_day01.base.BaseModel;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.ISort;
import com.example.bigxun_day01.net.CommonSubscriber;
import com.example.bigxun_day01.net.HttpManager;
import com.example.bigxun_day01.ui.sort.InfoTabDataBean;
import com.example.bigxun_day01.ui.sort.VerTabBean;
import com.example.bigxun_day01.utils.RxUtils;

public class SortModel extends BaseModel implements ISort.Model {
    @Override
    public void getTab(Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().getTab().
                compose(RxUtils.rxScheduler()).
                subscribeWith(new CommonSubscriber<VerTabBean>(callback) {
                    @Override
                    public void onNext(VerTabBean verTabBean) {
                        callback.success(verTabBean);
                    }
                }));
    }

    @Override
    public void getInfoTab(int id, Callback callback) {
       addDisposible(HttpManager.getInstance().getShopApi()
       .getTabInfo(id).compose(RxUtils.rxScheduler())
               .subscribeWith(new CommonSubscriber<InfoTabDataBean>(callback) {
                   @Override
                   public void onNext(InfoTabDataBean infoTabDataBean) {
                       callback.success(infoTabDataBean);
                   }
               }));
    }
}
