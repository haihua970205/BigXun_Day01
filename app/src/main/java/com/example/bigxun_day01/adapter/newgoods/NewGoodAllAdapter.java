package com.example.bigxun_day01.adapter.newgoods;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bigxun_day01.R;
import com.example.bigxun_day01.base.BaseAdapter;
import com.example.bigxun_day01.model.newgoods.NewGoodAllBean;

import java.util.List;

/**
 * @Author: 王世凯
 * @Time: 2020/12/18 18:32
 * @Company：公司名称
 * @Description: 功能描述
 */
public class NewGoodAllAdapter extends BaseAdapter<NewGoodAllBean.DataBeanX.GoodsListBean> {

    Context context;

    public NewGoodAllAdapter(Context context, List<NewGoodAllBean.DataBeanX.GoodsListBean> data) {
        super(context, data);
        this.context = context;
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.layout_newgoodolder;
    }

    @Override
    protected void bindData(NewGoodAllBean.DataBeanX.GoodsListBean data, VH vh) {
        ImageView img = (ImageView) vh.getViewById(R.id.image_new_good_older);
        TextView name = (TextView) vh.getViewById(R.id.name_new_good_older);
        TextView price = (TextView) vh.getViewById(R.id.price_new_good_older);
        Glide.with(context).load(data.getList_pic_url()).into(img);
        name.setText(data.getName());
        price.setText(String.valueOf(data.getRetail_price()));
    }
}
