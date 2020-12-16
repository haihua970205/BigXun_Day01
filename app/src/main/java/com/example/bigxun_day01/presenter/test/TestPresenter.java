package com.example.bigxun_day01.presenter.test;


import com.example.bigxun_day01.base.BasePresenter;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.test.ITest;
import com.example.bigxun_day01.model.test.TestBean;
import com.example.bigxun_day01.model.test.TestModel;

public class TestPresenter extends BasePresenter<ITest.View> implements ITest.Presenter {

    ITest.Model model;

    public TestPresenter(){
        model = new TestModel();
    }

    @Override
    public void getList() {
        if(mView != null){
            model.getList(new Callback<TestBean>() {
                @Override
                public void success(TestBean data) {
                    mView.getListReturn(data);
                }

                @Override
                public void fail(String err) {
                    mView.showToast(err);
                }
            });
        }
    }
}
