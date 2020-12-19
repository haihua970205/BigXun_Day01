package com.example.bigxun_day01.interfaces.newgoods;



import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.IBaseModel;
import com.example.bigxun_day01.interfaces.IBasePresenter;
import com.example.bigxun_day01.interfaces.IBaseView;
import com.example.bigxun_day01.model.newgoods.NewGoodAllBean;
import com.example.bigxun_day01.model.newgoods.NewGoodFristBean;
import com.example.bigxun_day01.model.newgoods.NewGoodOlderBean;

import java.util.Map;

/**
 * @Author: 王世凯
 * @Time: 2020/12/18 16:39
 * @Company：公司名称
 * @Description: 功能描述
 */
public interface NewGood {
    interface NewGoodView extends IBaseView {
        void getTopBackgroundReturn(NewGoodFristBean result);
        void getNewGoodOlderBeanReturn(NewGoodOlderBean result);
        void getNewGoodAllBeanReturn(NewGoodAllBean result);
    }
    interface NewGoodPresenter extends IBasePresenter<NewGoodView> {
        void resultTopBackground();
        void resultNewGoodOlderBean(Map<String, String> map);
        void resultNewGoodAllBean(Map<String, String> map);
    }
    interface NewGoodModel extends IBaseModel {
        void loadTopBackground(Callback callback);
        void loadNewGoodOlderBean(Map<String, String> map, Callback callback);
        void loadNewGoodAllBean(Map<String, String> map, Callback callback);
    }
}
