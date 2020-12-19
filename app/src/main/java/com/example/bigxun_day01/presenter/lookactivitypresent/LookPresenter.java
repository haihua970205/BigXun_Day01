package com.example.bigxun_day01.presenter.lookactivitypresent;

import com.example.bigxun_day01.base.BasePresenter;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.lookactivityinterface.ILookAct;
import com.example.bigxun_day01.model.lookactivitybean.LookActivityModel;
import com.example.bigxun_day01.model.lookactivitybean.LookTabBean;

public class LookPresenter extends BasePresenter<ILookAct.View> implements ILookAct.Presenter {
    private ILookAct.View view;
    private ILookAct.Model model;

    public LookPresenter(ILookAct.View view) {
        this.view = view;
        model = new LookActivityModel();
    }

    @Override
    public void getTab(int id) {
        model.getTab(id, new Callback<LookTabBean>() {
            @Override
            public void success(LookTabBean data) {
                if (view!=null){
                    view.getTab(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
