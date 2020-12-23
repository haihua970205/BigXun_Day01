package com.example.bigxun_day01.adapter.sortadapter;

import android.content.Context;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.example.bigxun_day01.R;
import com.example.bigxun_day01.base.BaseAdapter;
import com.example.bigxun_day01.utils.ImageLoader;

import java.util.List;

public class CategoryBigImageAdapter extends BaseAdapter {

    public CategoryBigImageAdapter(Context context, List Data) {
        super(context, Data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.layout_category_bigimage_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        String bean = (String) data;
        ImageView img= (ImageView) vh.getViewById(R.id.iv_bigimage_img);
        Glide.with(img).load(bean).into(img);

    }
}
