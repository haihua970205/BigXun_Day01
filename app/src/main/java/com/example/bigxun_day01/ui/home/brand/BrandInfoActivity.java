package com.example.bigxun_day01.ui.home.brand;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bigxun_day01.R;
import com.example.bigxun_day01.adapter.brandinfo.BrandInfoAdapter;
import com.example.bigxun_day01.base.BaseActivity;
import com.example.bigxun_day01.base.BaseAdapter;
import com.example.bigxun_day01.interfaces.brandinfo.IBrand;
import com.example.bigxun_day01.model.brand.BrandListBean;
import com.example.bigxun_day01.model.brand.InfoBrandBean;
import com.example.bigxun_day01.presenter.brand.BrandPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrandInfoActivity extends BaseActivity<IBrand.Presenter> implements IBrand.View {
    @BindView(R.id.brand_recycle)
    RecyclerView brandRecycle;
    @BindView(R.id.brand_smart)
    SmartRefreshLayout brandSmart;
    private int page = 1;
    private List<BrandListBean.DataBeanX.DataBean> list;
    private BrandInfoAdapter brandInfoAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_brand_info;
    }

    @Override
    protected BrandPresenter createPrenter() {
        return new BrandPresenter(this);
    }

    @Override
    protected void initView() {
        brandRecycle.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        brandInfoAdapter = new BrandInfoAdapter(BrandInfoActivity.this, list);
        brandRecycle.setAdapter(brandInfoAdapter);

       brandInfoAdapter.addListClick(new BaseAdapter.IListClick() {
           @Override
           public void itemClick(int pos) {
               Intent intent = new Intent(BrandInfoActivity.this, InfoShopBrandActivity.class);
                intent.putExtra("id",list.get(pos).getId());
                startActivity(intent);

           }
       });
        brandSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                initData();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                list.clear();
                page = 1;
                initData();
            }
        });
    }

    @Override
    protected void initData() {
        presenter.getBrand(page);
//        presenter.getInfo();
    }

    @Override
    public void getBrandReturn(BrandListBean brandListBean) {
        List<BrandListBean.DataBeanX.DataBean> data = brandListBean.getData().getData();
        list.addAll(data);
        brandSmart.finishLoadMore();
        brandSmart.finishRefresh();
        brandInfoAdapter.notifyDataSetChanged();
    }

    @Override
    public void getInfoReturn(InfoBrandBean infoBrandBean) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
