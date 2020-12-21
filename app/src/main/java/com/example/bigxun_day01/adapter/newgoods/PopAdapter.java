package com.example.bigxun_day01.adapter.newgoods;

import android.content.Context;
import android.widget.Button;

import com.example.bigxun_day01.R;
import com.example.bigxun_day01.base.BaseAdapter;
import com.example.bigxun_day01.model.newgoods.NewGoodAllBean;

import java.util.List;

public class PopAdapter extends BaseAdapter {

    public PopAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.adapter_pop_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        NewGoodAllBean.DataBeanX.FilterCategoryBean data1 = (NewGoodAllBean.DataBeanX.FilterCategoryBean) data;
        Button btn_pop = (Button) vh.getViewById(R.id.btn_pop);
        btn_pop.setText(data1.getName());
    }
}
