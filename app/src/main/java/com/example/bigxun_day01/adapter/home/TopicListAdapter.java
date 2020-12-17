package com.example.bigxun_day01.adapter.home;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bigxun_day01.R;
import com.example.bigxun_day01.base.BaseAdapter;
import com.example.bigxun_day01.model.home.bean.HomeBean;


import java.util.List;

public class TopicListAdapter extends BaseAdapter {
    public TopicListAdapter(Context context, List<HomeBean.DataBean.TopicListBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.home_item_topic;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ImageView image = (ImageView) vh.getViewById(R.id.new_pic_url);
        TextView name = (TextView) vh.getViewById(R.id.name);
        TextView floor_price = (TextView) vh.getViewById(R.id.floor_price);
        TextView goods_brief = (TextView) vh.getViewById(R.id.goods_brief);

        HomeBean.DataBean.TopicListBean bean= (HomeBean.DataBean.TopicListBean) data;

        Glide.with(context).load(bean.getItem_pic_url()).into(image);
        name.setText(bean.getTitle());
        floor_price.setText("￥"+bean.getPrice_info());
        goods_brief.setText(bean.getSubtitle());
    }
}
