package com.example.bigxun_day01.ui.home.lookvideo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.bigxun_day01.R;
import com.example.bigxun_day01.base.BaseActivity;
import com.example.bigxun_day01.interfaces.lookactivityinterface.ILookAct;
import com.example.bigxun_day01.model.lookactivitybean.LookTabBean;
import com.example.bigxun_day01.presenter.lookactivitypresent.LookPresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LookInfoActivity extends BaseActivity<ILookAct.Presenter> implements ILookAct.View {

    @BindView(R.id.look_tab)
    TabLayout lookTab;
    @BindView(R.id.look_vp)
    ViewPager lookVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_info);
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_look_info;
    }

    @Override
    protected LookPresenter createPrenter() {
        return new LookPresenter(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("cid", 0);
        presenter.getTab(id);
    }

    @Override
    public void getTab(LookTabBean lookTabBean) {
        List<LookTabBean.DataBean.CategoryListBean> tabList = lookTabBean.getData().getCategoryList();
        List<Fragment> list = new ArrayList<>();
        for (int i = 0; i < tabList.size(); i++) {
            InfoListFragment listFragment = new InfoListFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id",tabList.get(i).getId());
            bundle.putString("name",tabList.get(i).getName());
            bundle.putString("infoname",tabList.get(i).getFront_desc());
            bundle.putInt("id",tabList.get(i).getId());
            listFragment.setArguments(bundle);
            list.add(listFragment);
        }
        lookVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tabList.get(position).getName();
            }
        });
        lookTab.setupWithViewPager(lookVp);
    }
}