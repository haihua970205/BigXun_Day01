package com.example.bigxun_day01.adapter.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bigxun_day01.R;
import com.example.bigxun_day01.base.BaseAdapter;
import com.example.bigxun_day01.model.home.bean.HomeBean;


import java.util.List;

public class NewGoodsListAdapter extends BaseAdapter {

    private final Context context;

    public NewGoodsListAdapter(Context context, List<HomeBean.DataBean.NewGoodsListBean> data) {
        super(context, data);
        this.context = context;
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.home_item_newgoods;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ImageView image = (ImageView) vh.getViewById(R.id.new_pic_url);
        TextView name = (TextView) vh.getViewById(R.id.name);
        TextView floor_price = (TextView) vh.getViewById(R.id.floor_price);

        HomeBean.DataBean.NewGoodsListBean bean= (HomeBean.DataBean.NewGoodsListBean) data;

        Glide.with(context).load(bean.getList_pic_url()).into(image);
        name.setText(bean.getName());
        floor_price.setText("￥"+bean.getRetail_price());

    }
}
