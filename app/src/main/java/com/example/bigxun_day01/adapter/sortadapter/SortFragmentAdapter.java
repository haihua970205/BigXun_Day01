package com.example.bigxun_day01.adapter.sortadapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bigxun_day01.R;
import com.example.bigxun_day01.base.BaseAdapter;
import com.example.bigxun_day01.model.sortmodel.InfoTabDataBean;
import com.example.bigxun_day01.utils.TxtUtils;

import java.util.List;

public class SortFragmentAdapter extends BaseAdapter {
    public SortFragmentAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.adapter_fragment_sort;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        InfoTabDataBean.DataBean.CurrentCategoryBean.SubCategoryListBean data1 = (InfoTabDataBean.DataBean.CurrentCategoryBean.SubCategoryListBean) data;
        ImageView img = (ImageView) vh.getViewById(R.id.img_sort);
        TextView txt = (TextView) vh.getViewById(R.id.txt_sort);
        Glide.with(img).load(data1.getWap_banner_url()).into(img);
        TxtUtils.setTextView(txt,data1.getName());
    }
}
