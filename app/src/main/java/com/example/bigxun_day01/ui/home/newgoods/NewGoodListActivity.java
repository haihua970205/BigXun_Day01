package com.example.bigxun_day01.ui.home.newgoods;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bigxun_day01.R;
import com.example.bigxun_day01.adapter.newgoods.NewGoodAllAdapter;
import com.example.bigxun_day01.adapter.newgoods.NewGoodOlderAdapter;
import com.example.bigxun_day01.adapter.newgoods.PopAdapter;
import com.example.bigxun_day01.base.BaseActivity;
import com.example.bigxun_day01.interfaces.newgoods.NewGood;
import com.example.bigxun_day01.model.newgoods.NewGoodAllBean;
import com.example.bigxun_day01.model.newgoods.NewGoodFristBean;
import com.example.bigxun_day01.model.newgoods.NewGoodOlderBean;
import com.example.bigxun_day01.presenter.newgoods.NewGoodPresenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class NewGoodListActivity extends BaseActivity<NewGoodPresenter> implements NewGood.NewGoodView {
    private static final String ASC = "asc";
    private static final String DESC = "desc";
    private static final String DEFAULT = "default";
    private static final String PRICE = "price";
    private static final String CATEGORY = "category";
    private static final String TAG = "NewGoodListActivity";
    //    isNew=1&page=1&size =1000&order=asc&sort=default&categoryId=0
    private int isNew = 1;
    private int page = 1;
    private int size = 1000;
    private String order;
    private String sort;
    private int categoryId = 0;


    @BindView(R.id.img_new_good_list)
    ImageView imgNewGoodList;
    @BindView(R.id.new_good_list_name)
    TextView newGoodListName;
    @BindView(R.id.new_good_list_background)
    RelativeLayout newGoodListBackground;
    @BindView(R.id.new_good_list_all)
    TextView newGoodListAll;
    @BindView(R.id.new_good_list_price)
    TextView newGoodListPrice;
    @BindView(R.id.new_good_list_sort)
    TextView newGoodListSort;
    @BindView(R.id.new_good_list_tab_select)
    LinearLayout newGoodListTabSelect;
    @BindView(R.id.new_good_list_line)
    View newGoodListLine;
    @BindView(R.id.new_good_list_rcy)
    RecyclerView newGoodListRcy;
    @BindView(R.id.new_good_list_up_down_selected)
    ImageView newGoodSelected;
    @BindView(R.id.rl)
    RelativeLayout rl;
    private PopAdapter popAdapter;
    private List<NewGoodAllBean.DataBeanX.FilterCategoryBean> popList1;

    @Override
    protected int getLayout() {
        return R.layout.activity_new_good_list;
    }

    @Override
    protected NewGoodPresenter createPrenter() {
        return new NewGoodPresenter(this);
    }

    @Override
    protected void initView() {
        newGoodListPrice.setTag(0);
    }

    //    https://cdplay.cn/api/goods/list?isNew=1&page=1&size =1000&order=asc&sort=default&categoryId=0
    private Map<String,String> getParameter(String older,String sort){
        Map<String,String> map = new HashMap<>();
        map.put("isNew",String.valueOf(isNew));
        map.put("page",String.valueOf(page));
        map.put("size",String.valueOf(size));
        map.put("order",older);
        map.put("sort",sort);
        map.put("categoryId",String.valueOf(categoryId));
        return map;
    }
    private Map<String,String> getParameters(){
        Map<String,String> map = new HashMap<>();
        map.put("isNew",String.valueOf(isNew));
        map.put("page",String.valueOf(page));
        map.put("size",String.valueOf(size));
        return map;
    }
    @SuppressLint("ResourceType")
    @OnClick({R.id.new_good_list_all,R.id.new_good_list_price,R.id.new_good_list_sort})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.new_good_list_price:
                int tag = (int) newGoodListPrice.getTag();
                switch (tag){
                    case 0:
                        initSelectUpAndDown();
                        selectUp();
                        newGoodListPrice.setTag(1);
                        order = ASC;
                        break;
                    case 1:
                        initSelectUpAndDown();
                        selectDown();
                        newGoodListPrice.setTag(0);
                        order = DESC;
                        break;
                }
                sort = PRICE;
                Map<String, String> map = getParameter(order,sort);
                presenter.resultNewGoodOlderBean(map);
                break;
            case R.id.new_good_list_all:
                initSelectUpAndDown();
                newGoodListAll.setTextColor(Color.parseColor(getString(R.color.red)));
                Map<String, String> parameters = getParameters();
                presenter.resultNewGoodAllBean(parameters);
                break;
            case R.id.new_good_list_sort:
                initSelectUpAndDown();
                newGoodListSort.setTextColor(Color.parseColor(getString(R.color.red)));
                Map<String, String> sortMap = getParameters();
                presenter.resultNewGoodAllBean(sortMap);

                View popup = LayoutInflater.from(this).inflate(R.layout.layout_newgood_popup, null);
                PopupWindow popupWindow = new PopupWindow(popup, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setBackgroundDrawable(new ColorDrawable());
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAsDropDown(newGoodListTabSelect, Gravity.CENTER_HORIZONTAL,0,0);
                RecyclerView sort = popup.findViewById(R.id.pop_recycle_sort);
                sort.setLayoutManager(new GridLayoutManager(this,5));
                if (popList1.size()>0){
                    popAdapter = new PopAdapter(this, popList1);
                    sort.setAdapter(popAdapter);

                   /* popAdapter.addListClick(new BaseAdapter.IListClick() {
                        @Override
                        public void itemClick(int pos) {
                            boolean checked = popList1.get(pos).isChecked();

                        }
                    });*/
                }
                break;
        }
    }


    @SuppressLint("ResourceType")
    private void selectDown() {
        newGoodListPrice.setTextColor(Color.parseColor(getString(R.color.red)));
        newGoodSelected.setImageResource(R.mipmap.newgood_down);
    }

    @SuppressLint("ResourceType")
    private void selectUp() {
        newGoodListPrice.setTextColor(Color.parseColor(getString(R.color.red)));
        newGoodSelected.setImageResource(R.mipmap.newgood_up);

    }

    @SuppressLint("ResourceType")
    private void initSelectUpAndDown(){
        newGoodListPrice.setTag(0);
        newGoodSelected.setImageResource(R.mipmap.newgood_upanddown);
        newGoodListPrice.setTextColor(Color.parseColor(getString(R.color.black)));
        newGoodListSort.setTextColor(Color.parseColor(getString(R.color.black)));
        newGoodListAll.setTextColor(Color.parseColor(getString(R.color.black)));
    }


    @Override
    protected void initData() {
        presenter.resultTopBackground();
        Map<String, String> parameters = getParameters();
        presenter.resultNewGoodAllBean(parameters);
    }

    @Override
    public void getTopBackgroundReturn(NewGoodFristBean result) {
        if (result!=null){
            NewGoodFristBean.DataBean.BannerInfoBean bannerInfo = result.getData().getBannerInfo();
            String name = bannerInfo.getName();
            String img_url = bannerInfo.getImg_url();

            imgNewGoodList.post(new Runnable() {
                @Override
                public void run() {
                    Glide.with(NewGoodListActivity.this).load(img_url).into(imgNewGoodList);
                    newGoodListName.setText(name);
                }
            });
        }
    }

    @Override
    public void getNewGoodOlderBeanReturn(NewGoodOlderBean result) {
        Log.d(TAG, "getNewGoodOlderBeanReturn: "+result.getData().toString());
        if (result!=null){
            List<NewGoodOlderBean.DataBeanX.GoodsListBean> goodsList = result.getData().getGoodsList();
            initBindData(goodsList);
        }
    }

    @Override
    public void getNewGoodAllBeanReturn(NewGoodAllBean result) {
        if (result!=null){
            List<NewGoodAllBean.DataBeanX.GoodsListBean> data = result.getData().getGoodsList();
            initAllData(data);
            popList1 = result.getData().getFilterCategory();

        }
    }

    private void initAllData(List<NewGoodAllBean.DataBeanX.GoodsListBean> data) {
        newGoodListRcy.setLayoutManager(new GridLayoutManager(this,2));
        NewGoodAllAdapter newGoodAllAdapter = new NewGoodAllAdapter(this, data);
        newGoodListRcy.setAdapter(newGoodAllAdapter);
        newGoodAllAdapter.notifyDataSetChanged();

    }

    private void initBindData(List<NewGoodOlderBean.DataBeanX.GoodsListBean> goodsList) {
        newGoodListRcy.setLayoutManager(new GridLayoutManager(this,2));
        NewGoodOlderAdapter newGoodOlderAdapter = new NewGoodOlderAdapter(this, goodsList);
        newGoodListRcy.setAdapter(newGoodOlderAdapter);
        newGoodOlderAdapter.notifyDataSetChanged();
    }

}