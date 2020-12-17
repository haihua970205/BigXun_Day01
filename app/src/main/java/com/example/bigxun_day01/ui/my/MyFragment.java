package com.example.bigxun_day01.ui.my;


import com.example.bigxun_day01.R;
import com.example.bigxun_day01.base.BaseFragment;
import com.example.bigxun_day01.interfaces.home.IHome;
import com.example.bigxun_day01.model.home.bean.HomeBean;

public class MyFragment extends BaseFragment<IHome.Presenter> implements  IHome.View{
    @Override
    protected int getLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected IHome.Presenter createPrenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void getHomeReturn(HomeBean homeBean) {

    }
}
