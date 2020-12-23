package com.example.bigxun_day01.ui.sort;

import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bigxun_day01.R;
import com.example.bigxun_day01.adapter.sortadapter.SortFragmentAdapter;
import com.example.bigxun_day01.base.BaseAdapter;
import com.example.bigxun_day01.base.BaseFragment;
import com.example.bigxun_day01.interfaces.ISort;
import com.example.bigxun_day01.model.sortmodel.InfoTabDataBean;
import com.example.bigxun_day01.model.sortmodel.VerTabBean;
import com.example.bigxun_day01.presenter.sorepresent.SrotPresenter;
import com.example.bigxun_day01.ui.home.lookvideo.LookInfoActivity;

import java.util.List;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class SortFragment extends BaseFragment<ISort.Presenter> implements ISort.View {

    @BindView(R.id.sort_search)
    SearchView sortSearch;
    @BindView(R.id.sort_image)
    ImageView sortImage;
    @BindView(R.id.sort_txt)
    TextView sortTxt;
    @BindView(R.id.sort_recycle)
    RecyclerView sortRecycle;
    @BindView(R.id.image_txt)
    TextView imageTxt;
    @BindView(R.id.sort_tab)
    VerticalTabLayout sortTab;


    @Override
    protected int getLayout() {
        return R.layout.fragment_sort;
    }

    @Override
    protected ISort.Presenter createPrenter() {
        return new SrotPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        presenter.getTab();
    }

    @Override
    public void getTabReturn(VerTabBean verTabBean) {
        List<VerTabBean.DataBean.CategoryListBean> categoryList = verTabBean.getData().getCategoryList();
        for (int i = 0; i < categoryList.size(); i++) {
            Log.e("TAG", "getTabReturn: " + i + categoryList.get(i).getName());
        }
        sortTab.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return categoryList.size();
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {
                return null;
            }


            @Override
            public QTabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public QTabView.TabTitle getTitle(int position) {
                QTabView.TabTitle title = new QTabView.TabTitle.Builder()
                        .setContent(categoryList.get(position).getName())//设置数据   也有设置字体颜色的方法
                        .build();
                return title;
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });
        sortTab.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                int id = categoryList.get(position).getId();
                if (id > 0) {
                    presenter.getInfoTab(id);
                }
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });

    }

    @Override
    public void getInfoTabReturn(InfoTabDataBean infoTabDataBean) {
//wap_banner_url
        imageTxt.setText(infoTabDataBean.getData().getCurrentCategory().getFront_name());
        sortTxt.setText(infoTabDataBean.getData().getCurrentCategory().getName() + "分类");
        Glide.with(sortImage).load(infoTabDataBean.getData().getCurrentCategory().getWap_banner_url()).into(sortImage);

        List<InfoTabDataBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = infoTabDataBean.getData().getCurrentCategory().getSubCategoryList();
        sortRecycle.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        SortFragmentAdapter sortFragmentAdapter = new SortFragmentAdapter(getActivity(), subCategoryList);
        sortRecycle.setAdapter(sortFragmentAdapter);
        sortFragmentAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent(getActivity(), LookInfoActivity.class);
                intent.putExtra("cid", subCategoryList.get(pos).getId());
                startActivity(intent);
            }
        });
    }
}