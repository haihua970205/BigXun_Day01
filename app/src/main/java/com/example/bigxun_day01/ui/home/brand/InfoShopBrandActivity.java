package com.example.bigxun_day01.ui.home.brand;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bigxun_day01.R;
import com.example.bigxun_day01.base.BaseActivity;
import com.example.bigxun_day01.interfaces.brandinfo.IBrand;
import com.example.bigxun_day01.model.brand.BrandListBean;
import com.example.bigxun_day01.model.brand.InfoBrandBean;
import com.example.bigxun_day01.presenter.brand.BrandPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoShopBrandActivity extends BaseActivity<IBrand.Presenter> implements IBrand.View {
    @BindView(R.id.image_info)
    ImageView imageInfo;
    @BindView(R.id.info_name)
    TextView infoName;
    @BindView(R.id.info_text)
    TextView infoText;
    @BindView(R.id.info_recycle)
    RecyclerView infoRecycle;

    @Override
    protected int getLayout() {
        return R.layout.activity_info_shop_brand;
    }

    @Override
    protected BrandPresenter createPrenter() {
        return new BrandPresenter(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
//        pos = intent.getIntExtra("pos", 0);
        int id = intent.getIntExtra("id", 0);
        presenter.getInfo(id);
    }

    @Override
    public void getBrandReturn(BrandListBean brandListBean) {
        List<BrandListBean.DataBeanX.DataBean> data = brandListBean.getData().getData();

    }

    @Override
    public void getInfoReturn(InfoBrandBean infoBrandBean) {
        InfoBrandBean.DataBean.BrandBean brand = infoBrandBean.getData().getBrand();
        Glide.with(this).load(brand.getApp_list_pic_url()).into(imageInfo);
        infoName.setText(brand.getName());
        infoText.setText(brand.getSimple_desc());
    }

}