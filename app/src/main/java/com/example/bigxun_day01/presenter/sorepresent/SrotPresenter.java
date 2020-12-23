package com.example.bigxun_day01.presenter.sorepresent;

import com.example.bigxun_day01.base.BasePresenter;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.ISort;
import com.example.bigxun_day01.model.sortmodel.InfoTabDataBean;
import com.example.bigxun_day01.model.sortmodel.SortModel;
import com.example.bigxun_day01.model.sortmodel.VerTabBean;


public class SrotPresenter extends BasePresenter<ISort.View> implements ISort.Presenter {
    private ISort.Model model;

    public SrotPresenter() {
        model = new SortModel();
    }

    @Override
    public void getTab() {
        model.getTab(new Callback<VerTabBean>() {
            @Override
            public void success(VerTabBean data) {
                if (mView != null) {
                    mView.getTabReturn(data);
                }

            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void getInfoTab(int id) {
        model.getInfoTab(id, new Callback<InfoTabDataBean>() {
            @Override
            public void success(InfoTabDataBean data) {
                if (mView != null) {
                    mView.getInfoTabReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
