package com.example.bigxun_day01.presenter.brand;

import com.example.bigxun_day01.base.BasePresenter;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.brandinfo.IBrand;
import com.example.bigxun_day01.model.brand.InfoBrandBean;
import com.example.bigxun_day01.model.brand.InfoBrandModel;
import com.example.bigxun_day01.model.brand.BrandListBean;

public class BrandPresenter extends BasePresenter<IBrand.View> implements IBrand.Presenter {
    private IBrand.View view;
    private IBrand.Model model;

    public BrandPresenter(IBrand.View view) {
        this.view = view;
        model = new InfoBrandModel();
    }

    @Override
    public void getBrand(int page) {
        model.getBrand(page, new Callback<BrandListBean>() {
            @Override
            public void success(BrandListBean data) {
                if (view != null) {
                    view.getBrandReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void getInfo(int id) {
        model.getInfo(id, new Callback<InfoBrandBean>() {
            @Override
            public void success(InfoBrandBean data) {
                view.getInfoReturn(data);
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
