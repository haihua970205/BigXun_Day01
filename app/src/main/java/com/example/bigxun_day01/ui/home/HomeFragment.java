package com.example.bigxun_day01.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.bigxun_day01.R;
import com.example.bigxun_day01.adapter.home.BrandAdapter;
import com.example.bigxun_day01.adapter.home.CategoryListAdapter;
import com.example.bigxun_day01.adapter.home.HotGoodsAdapter;
import com.example.bigxun_day01.adapter.home.NewGoodsListAdapter;
import com.example.bigxun_day01.adapter.home.TopicListAdapter;
import com.example.bigxun_day01.base.BaseAdapter;
import com.example.bigxun_day01.base.BaseFragment;
import com.example.bigxun_day01.interfaces.home.IHome;
import com.example.bigxun_day01.model.home.bean.HomeBean;
import com.example.bigxun_day01.presenter.home.HomePresenter;
import com.example.bigxun_day01.ui.home.brand.BrandInfoActivity;
import com.example.bigxun_day01.ui.home.lookvideo.LookInfoActivity;
import com.example.bigxun_day01.ui.home.newgoods.NewGoodListActivity;
//import com.example.bigxun_day01.ui.newshopinfo.NewShopInfoActivity;
import com.example.bigxun_day01.ui.newshopinfo.NewShopInfoActivity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<IHome.Presenter> implements IHome.View {
    private SearchView mSearch;
    private Banner mBanner;
    private LinearLayout mTab;
    private TextView mTxtBrandTitle;
    private RecyclerView mRecyBrand;
    private TextView mTxtNewgoodTitle;
    private RecyclerView mRecyNewgood;
    private List<HomeBean.DataBean.BrandListBean> listBrand;
    private List<HomeBean.DataBean.NewGoodsListBean> newGoodList;
    private BrandAdapter brandAdapter;
    private TextView mTxtPopTitle;
    private RecyclerView mRecyPop;
    private TextView mTxtTitTitle;
    private RecyclerView mRecyTit;
    private LinearLayout mLinesr;
    private NewGoodsListAdapter newGoodsListAdapter;


    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomePresenter createPrenter() {
        return new HomePresenter(this);
    }

    @Override
    protected void initView() {
        mSearch = (SearchView) getActivity().findViewById(R.id.search);
        mBanner = (Banner) getActivity().findViewById(R.id.banner);
        mTab = (LinearLayout) getActivity().findViewById(R.id.tab);
        mTxtBrandTitle = (TextView) getActivity().findViewById(R.id.txt_brand_title);
        mTxtPopTitle = (TextView) getActivity().findViewById(R.id.txt_pop_title);
        mRecyPop = (RecyclerView) getActivity().findViewById(R.id.recy_pop);
        mTxtTitTitle = (TextView) getActivity().findViewById(R.id.txt_tit_title);
        mRecyTit = (RecyclerView) getActivity().findViewById(R.id.recy_tit);
        mLinesr = (LinearLayout) getActivity().findViewById(R.id.linesr);
        mRecyBrand = (RecyclerView) getActivity().findViewById(R.id.recy_brand);
        mTxtNewgoodTitle = (TextView) getActivity().findViewById(R.id.txt_newgood_title);
        mRecyNewgood = (RecyclerView) getActivity().findViewById(R.id.recy_newgood);

// 新品    品牌制造商
        mRecyBrand.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyNewgood.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        listBrand = new ArrayList<>();
        newGoodList = new ArrayList<>();
        brandAdapter = new BrandAdapter(getActivity(), listBrand);
        newGoodsListAdapter = new NewGoodsListAdapter(getActivity(), newGoodList);
        mRecyBrand.setAdapter(brandAdapter);
        mRecyNewgood.setAdapter(newGoodsListAdapter);
        newGoodsListAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                int id = newGoodList.get(pos).getId();
                Intent intent = new Intent(getActivity(), NewShopInfoActivity.class);
                intent.putExtra("infoId", id);
                startActivity(intent);
            }
        });

        mTxtNewgoodTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NewGoodListActivity.class));
            }
        });
        mTxtBrandTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BrandInfoActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void initData() {
        presenter.getHome();
    }


    @Override
    public void getHomeReturn(HomeBean homeBean) {
        if (homeBean != null) {
            initTab(homeBean.getData().getChannel());
            initBanner(homeBean.getData().getBanner());
            initBrand(homeBean.getData().getBrandList());
            initGood(homeBean.getData().getNewGoodsList());
            initHotGoodsList(homeBean.getData().getHotGoodsList());
            initTopicList(homeBean.getData().getTopicList());
            initCategoryList(homeBean.getData().getCategoryList());
        }
    }

    private void initCategoryList(List<HomeBean.DataBean.CategoryListBean> categoryList) {
        for (int i = 0; i < categoryList.size(); i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_item_sss, null);
            TextView text = view.findViewById(R.id.txt_home_title);
            text.setText(categoryList.get(i).getName());
            RecyclerView recy_home = view.findViewById(R.id.recy_home);
            List<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsList1 = categoryList.get(i).getGoodsList();
            recy_home.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

            CategoryListAdapter categoryListAdapter = new CategoryListAdapter(getActivity(), goodsList1);
            recy_home.setAdapter(categoryListAdapter);
            mLinesr.addView(view);
         //专题精选------居家
            categoryListAdapter.addListClick(new BaseAdapter.IListClick() {
                @Override
                public void itemClick(int pos) {
                    int id = goodsList1.get(pos).getId();
                    Intent intent = new Intent(getActivity(), NewShopInfoActivity.class);
                    intent.putExtra("infoId", id);
                    startActivity(intent);
                }
            });

        }
    }

    private void initTopicList(List<HomeBean.DataBean.TopicListBean> topicList) {
        mRecyTit.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));

        TopicListAdapter topicListAdapter = new TopicListAdapter(getActivity(), topicList);

        mRecyTit.setAdapter(topicListAdapter);
    }

    // 人气推荐
    private void initHotGoodsList(List<HomeBean.DataBean.HotGoodsListBean> hotGoodsList) {
        mRecyPop.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRecyPop.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        HotGoodsAdapter hotGoodsAdapter = new HotGoodsAdapter(getActivity(), hotGoodsList);

        mRecyPop.setAdapter(hotGoodsAdapter);
        hotGoodsAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                int id = hotGoodsList.get(pos).getId();
                Intent intent = new Intent(getActivity(), NewShopInfoActivity.class);
                intent.putExtra("infoId", id);
                startActivity(intent);
            }
        });

    }

    private void initGood(List<HomeBean.DataBean.NewGoodsListBean> newGoodsList) {
        newGoodList.addAll(newGoodsList);
        newGoodsListAdapter.notifyDataSetChanged();
    }

    private void initBrand(List<HomeBean.DataBean.BrandListBean> brandList) {
        listBrand.addAll(brandList);
        brandAdapter.notifyDataSetChanged();
    }

    private void initTab(List<HomeBean.DataBean.ChannelBean> list) {
        mTab.removeAllViews();
        for (HomeBean.DataBean.ChannelBean item : list) {
            View channel = LayoutInflater.from(getContext()).inflate(R.layout.layout_channel_item, null);
            ImageView img = channel.findViewById(R.id.img_channel);
            TextView txt = channel.findViewById(R.id.txt_channel);
            Glide.with(getActivity()).load(item.getIcon_url()).into(img);
            txt.setText(item.getName());
            channel.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
            mTab.addView(channel);
            mTab.setTag(item);
//          Log.e("TAG", "initTab: "+item.getName()+item.getId());
            mTab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), LookInfoActivity.class);
                    intent.putExtra("cid", item.getId());
                    startActivity(intent);
                }
            });
        }

    }

    private void initBanner(List<HomeBean.DataBean.BannerBean> banner) {
        mBanner.setImages(banner).
                setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        HomeBean.DataBean.BannerBean p = (HomeBean.DataBean.BannerBean) path;
                        Glide.with(getActivity()).load(p.getImage_url()).into(imageView);
                    }
                }).start();
    }

}
