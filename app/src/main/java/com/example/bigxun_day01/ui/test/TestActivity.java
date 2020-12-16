package com.example.bigxun_day01.ui.test;

import com.example.bigxun_day01.R;
import com.example.bigxun_day01.base.BaseActivity;
import com.example.bigxun_day01.interfaces.test.ITest;
import com.example.bigxun_day01.model.test.TestBean;
import com.example.bigxun_day01.presenter.test.TestPresenter;

public class TestActivity extends BaseActivity<ITest.Presenter> implements ITest.View {
    @Override
    protected int getLayout() {
        return R.layout.activity_test;
    }

    @Override
    protected TestPresenter createPrenter() {
        return new TestPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        presenter.getList();
    }

    @Override
    public void getListReturn(TestBean result) {

    }
}
