package com.example.bigxun_day01.adapter.brandinfo;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bigxun_day01.R;
import com.example.bigxun_day01.base.BaseAdapter;
import com.example.bigxun_day01.model.brand.BrandListBean;
import com.example.bigxun_day01.utils.TxtUtils;

import java.util.List;

public class BrandInfoAdapter extends BaseAdapter {

    public BrandInfoAdapter(Context context, List<BrandListBean.DataBeanX.DataBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.adapter_infobrand;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        BrandListBean.DataBeanX.DataBean list = (BrandListBean.DataBeanX.DataBean) data;
        ImageView image = (ImageView) vh.getViewById(R.id.image_brand);
        TextView bName = (TextView) vh.getViewById(R.id.tex_brandname);
        TextView bPrice = (TextView)vh.getViewById(R.id.tex_brandprice);
        Glide.with(context).load(list.getApp_list_pic_url()).into(image);
        TxtUtils.setTextView(bName,list.getName());
        TxtUtils.setTextView(bPrice, String.valueOf(list.getFloor_price()));
    }
}
