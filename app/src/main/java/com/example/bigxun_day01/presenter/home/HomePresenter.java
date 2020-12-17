package com.example.bigxun_day01.presenter.home;

import com.example.bigxun_day01.base.BasePresenter;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.home.IHome;
import com.example.bigxun_day01.model.home.HomeModel;
import com.example.bigxun_day01.model.home.bean.HomeBean;

public class HomePresenter extends BasePresenter<IHome.View> implements IHome.Presenter {

    IHome.Model model;
    private IHome.View view;

    public HomePresenter(IHome.View view) {
        this.view = view;
        model = new HomeModel();
    }


    @Override
    public void getHome() {
        model.getHome(new Callback<HomeBean>() {
            @Override
            public void success(HomeBean data) {
                if (view != null){
                    view.getHomeReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
