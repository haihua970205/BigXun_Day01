package com.example.bigxun_day01.presenter.newgoods;

import com.example.bigxun_day01.base.BasePresenter;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.newgoods.NewGood;
import com.example.bigxun_day01.model.newgoods.NewGoodAllBean;
import com.example.bigxun_day01.model.newgoods.NewGoodFristBean;
import com.example.bigxun_day01.model.newgoods.NewGoodModel;
import com.example.bigxun_day01.model.newgoods.NewGoodOlderBean;

import java.util.Map;

/**
 * @Author: 王世凯
 * @Time: 2020/12/18 16:44
 * @Company：公司名称
 * @Description: 功能描述
 */

public class NewGoodPresenter extends BasePresenter<NewGood.NewGoodView> implements NewGood.NewGoodPresenter {
    NewGood.NewGoodView view;
    NewGood.NewGoodModel model;

    public NewGoodPresenter(NewGood.NewGoodView view) {
        this.view = view;
        this.model = new NewGoodModel();
    }

    @Override
    public void resultTopBackground() {
        model.loadTopBackground(new Callback() {
            @Override
            public void fail(String msg) {

            }

            @Override
            public void success(Object o) {
                view.getTopBackgroundReturn((NewGoodFristBean) o);
            }
        });
    }

    @Override
    public void resultNewGoodOlderBean(Map<String, String> map) {
        model.loadNewGoodOlderBean(map, new Callback() {
            @Override
            public void fail(String msg) {
            }

            @Override
            public void success(Object o) {
                if (view!=null){
                    view.getNewGoodOlderBeanReturn((NewGoodOlderBean) o);
                }
            }
        });
    }

    @Override
    public void resultNewGoodAllBean(Map<String, String> map) {
        model.loadNewGoodAllBean(map, new Callback() {
            @Override
            public void fail(String msg) {
            }

            @Override
            public void success(Object o) {
                if (view!=null){
                    view.getNewGoodAllBeanReturn((NewGoodAllBean) o);
                }
            }
        });
    }
}
