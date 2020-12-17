package com.example.bigxun_day01.adapter.home;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bigxun_day01.R;
import com.example.bigxun_day01.base.BaseAdapter;
import com.example.bigxun_day01.model.home.bean.HomeBean;


import java.util.List;

public class HotGoodsAdapter extends BaseAdapter {

    private final Context context;

    public HotGoodsAdapter(Context context, List<HomeBean.DataBean.HotGoodsListBean> data) {
        super(context, data);
        this.context = context;
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.home_item_hotgoods;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ImageView image = (ImageView) vh.getViewById(R.id.new_pic_url);
        TextView name = (TextView) vh.getViewById(R.id.name);
        TextView floor_price = (TextView) vh.getViewById(R.id.floor_price);
        TextView goods_brief = (TextView) vh.getViewById(R.id.goods_brief);

        HomeBean.DataBean.HotGoodsListBean bean= (HomeBean.DataBean.HotGoodsListBean) data;

        Glide.with(context).load(bean.getList_pic_url()).into(image);
        name.setText(bean.getName());
        floor_price.setText("￥"+bean.getRetail_price());
        goods_brief.setText(bean.getGoods_brief());
    }
}
