package com.example.bigxun_day01.presenter.lookactivitypresent;

import com.example.bigxun_day01.base.BasePresenter;
import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.lookactivityinterface.ILookFragment;
import com.example.bigxun_day01.model.lookactivitybean.LookFragmentModel;
import com.example.bigxun_day01.model.lookactivitybean.LookInfoFragmentBean;

public class LookFragmentPresent extends BasePresenter<ILookFragment.View> implements  ILookFragment.Presenter{
   private ILookFragment.View view;
    private ILookFragment.Model model;

    public LookFragmentPresent(ILookFragment.View view) {
        this.view = view;
        model = new LookFragmentModel();
    }

    @Override
    public void getFragList(int id) {
        model.getFragList(id, new Callback<LookInfoFragmentBean>() {
            @Override
            public void success(LookInfoFragmentBean data) {
                if (view != null){
                    view.getFragListReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
