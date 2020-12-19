package com.example.bigxun_day01.interfaces.brandinfo;

import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.IBaseModel;
import com.example.bigxun_day01.interfaces.IBasePresenter;
import com.example.bigxun_day01.interfaces.IBaseView;
import com.example.bigxun_day01.model.brand.BrandListBean;
import com.example.bigxun_day01.model.brand.InfoBrandBean;

public interface IBrand {
    interface View extends IBaseView {
        void getBrandReturn(BrandListBean brandListBean);
        void getInfoReturn(InfoBrandBean infoBrandBean);

    }

    interface Presenter extends IBasePresenter<View> {
        void getBrand(int page);
        void getInfo(int id);
    }

    interface Model extends IBaseModel {
        void getBrand(int page, Callback callback);
        void getInfo(int id,Callback callback);
    }
}
