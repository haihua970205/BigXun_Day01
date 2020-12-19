package com.example.bigxun_day01.adapter.lookinfo;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bigxun_day01.R;
import com.example.bigxun_day01.base.BaseAdapter;
import com.example.bigxun_day01.model.lookactivitybean.LookInfoFragmentBean;

import java.util.List;

public class LookFragmentAdapter extends BaseAdapter {

    public LookFragmentAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.adapter_look_fragment;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        LookInfoFragmentBean.DataBeanX.DataBean bean = (LookInfoFragmentBean.DataBeanX.DataBean) data;
        ImageView image = (ImageView) vh.getViewById(R.id.image);
        TextView txt_title = (TextView) vh.getViewById(R.id.txt_title);
        TextView txt_price = (TextView) vh.getViewById(R.id.txt_price);
        Glide.with(context).load(bean.getList_pic_url()).into(image);
        txt_title.setText(bean.getName());
        txt_price.setText(bean.getRetail_price());
    }
}
