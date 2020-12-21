package com.example.bigxun_day01.adapter.newgoods;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bigxun_day01.R;
import com.example.bigxun_day01.base.BaseAdapter;
import com.example.bigxun_day01.model.newgoods.NewGoodOlderBean;


import java.util.List;

public class NewGoodOlderAdapter extends BaseAdapter<NewGoodOlderBean.DataBeanX.GoodsListBean> {
    Context context;
    public NewGoodOlderAdapter(Context context, List<NewGoodOlderBean.DataBeanX.GoodsListBean> data) {
        super(context, data);
        this.context = context;
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.layout_newgoodolder;
    }

    @Override
    protected void bindData(NewGoodOlderBean.DataBeanX.GoodsListBean data, VH vh) {
        ImageView img = (ImageView) vh.getViewById(R.id.image_new_good_older);
        TextView name = (TextView) vh.getViewById(R.id.name_new_good_older);
        TextView price = (TextView) vh.getViewById(R.id.price_new_good_older);
        Glide.with(context).load(data.getList_pic_url()).into(img);
        name.setText(data.getName());
        price.setText(String.valueOf(data.getRetail_price()));
    }
}
