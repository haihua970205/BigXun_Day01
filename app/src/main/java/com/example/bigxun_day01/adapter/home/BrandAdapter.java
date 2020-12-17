package com.example.bigxun_day01.adapter.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.bigxun_day01.R;
import com.example.bigxun_day01.base.BaseAdapter;
import com.example.bigxun_day01.model.home.bean.HomeBean;

import java.util.List;

public class BrandAdapter extends BaseAdapter {

    public BrandAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.adapter_brand;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        ImageView image = (ImageView) vh.getViewById(R.id.image);
        HomeBean.DataBean.BrandListBean data1 = (HomeBean.DataBean.BrandListBean) data;
        Glide.with(context).load(data1.getApp_list_pic_url()).into(image);

    }
}
