package com.example.bigxun_day01.interfaces.lookactivityinterface;

import com.example.bigxun_day01.interfaces.Callback;
import com.example.bigxun_day01.interfaces.IBaseModel;
import com.example.bigxun_day01.interfaces.IBasePresenter;
import com.example.bigxun_day01.interfaces.IBaseView;
import com.example.bigxun_day01.model.lookactivitybean.LookInfoFragmentBean;

public interface ILookFragment {
    interface View extends IBaseView {
        void getFragListReturn (LookInfoFragmentBean lookInfoFragmentBean);

    }
    interface Presenter extends IBasePresenter<ILookFragment.View> {
        void getFragList(int id);
    }

    interface Model extends IBaseModel {
        void getFragList(int id, Callback callback);
    }
}
