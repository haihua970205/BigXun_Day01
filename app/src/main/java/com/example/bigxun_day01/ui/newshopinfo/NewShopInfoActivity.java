package com.example.bigxun_day01.ui.newshopinfo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bigxun_day01.MainActivity;
import com.example.bigxun_day01.R;
import com.example.bigxun_day01.adapter.newgoods.Car_Product_Adapter;
import com.example.bigxun_day01.adapter.sortadapter.CategoryBigImageAdapter;
import com.example.bigxun_day01.base.BaseActivity;
import com.example.bigxun_day01.base.BaseAdapter;
import com.example.bigxun_day01.interfaces.newshopinfo.IShopInfo;
import com.example.bigxun_day01.model.newshopinfo.ShopInfoBean;
import com.example.bigxun_day01.model.newshopinfo.ShopLookAllBean;
import com.example.bigxun_day01.model.shop.AddCarBean;
import com.example.bigxun_day01.model.shop.ShopCarDataBean;
import com.example.bigxun_day01.presenter.newshopinfo.ShopInfoPresenter;
import com.example.bigxun_day01.ui.sort.BigImageActivity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;

public class NewShopInfoActivity extends BaseActivity<IShopInfo.Presenter> implements IShopInfo.View {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.car_name)
    TextView carName;
    @BindView(R.id.car_brief)
    TextView carBrief;
    @BindView(R.id.car_retail_price)
    TextView carRetailPrice;
    @BindView(R.id.txt_assess)
    TextView txtAssess;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.img_collect)
    ImageView imgCollect;
    @BindView(R.id.layout_collect)
    FrameLayout layoutCollect;
    @BindView(R.id.img_car)
    ImageView imgCar;
    @BindView(R.id.txt_number)
    TextView txtNumber;
    @BindView(R.id.layout_car)
    FrameLayout layoutCar;
    @BindView(R.id.txt_buy)
    TextView txtBuy;
    @BindView(R.id.txt_addCar)
    TextView txtAddCar;
    @BindView(R.id.layout_shop)
    ConstraintLayout layoutShop;
    @BindView(R.id.car_linee)
    LinearLayout carLinee;
    @BindView(R.id.ll_iss)
    LinearLayout llIss;
    @BindView(R.id.rlv_product)
    RecyclerView rlvProduct;
    @BindView(R.id.mRlv_category_bigimage)
    RecyclerView mRlvCategoryBigimage;
    //    @BindView(R.id.webView)
//    WebView webView;
    private int num;
    int buyNumber = 1; //购买的数量
    private Map<String, String> map;

    @Override
    protected int getLayout() {
        return R.layout.activity_new_shop_info;
    }

    private String h5 = "<html>\n" +
            "            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\"/>\n" +
            "            <head>\n" +
            "                <style>\n" +
            "                    p{\n" +
            "                        margin:0px;\n" +
            "                    }\n" +
            "                    img{\n" +
            "                        width:100%;\n" +
            "                        height:auto;\n" +
            "                    }\n" +
            "                </style>\n" +
            "            </head>\n" +
            "            <body>\n" +
            "                word\n" +
            "            </body>\n" +
            "        </html>";

    @Override
    protected IShopInfo.Presenter createPrenter() {
        return new ShopInfoPresenter();
    }

    @Override
    protected void initView() {
        txtAddCar.setTag(0);
        imgCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewShopInfoActivity.this, MainActivity.class);
                intent.putExtra("infoId", 3);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        presenter.getCarList();
        Intent intent = getIntent();
        if (intent.hasExtra("infoId")) {
            int id = intent.getIntExtra("infoId", 0);
            if (id > 0) {
                presenter.getShop(id);
            }
        }

    }

    @Override
    public void getShopReturn(ShopInfoBean carBean) {
        //banner图
        initBanner(carBean.getData().getGallery());

        // 商品信息
        initInfo(carBean.getData().getInfo());

//        //h5 商品详情
//        initGoodDetail(carBean.getData().getInfo().getGoods_desc());

        //商品参数
        initattribute(carBean.getData().getAttribute());

        //常见问题
        initIssue(carBean.getData().getIssue());
        //底部数据列表
        initProduct(carBean.getData().getProductList());
        //展示goods_desc
        showImage(carBean.getData().getInfo().getGoods_desc());
    }

    private void showImage(String goods_desc) {
        ArrayList<String> listUrl = new ArrayList<>();
        String img = "<img[\\s\\S]*?>";
        Pattern pattern = Pattern.compile(img);
        Matcher matcher = pattern.matcher(goods_desc);

        while (matcher.find()) {
            String word = matcher.group();
            int start = word.indexOf("\"") + 1;
            int end = word.indexOf(".jpg");
            if (end > 0) {//如果是jpg格式的就截取jpg
                String url = word.substring(start, end);
                if (url != null) {
                    url = url + ".jpg";
                    listUrl.add(url);
                } else {
                    return;
                }
            } else {
                int end1 = word.indexOf(".png");//如果是png格式的就截取png
                String url = word.substring(start, end1);
                if (url != null) {
                    url = url + ".png";
                    listUrl.add(url);
                } else {
                    return;
                }
            }
        }
        mRlvCategoryBigimage.setLayoutManager(new LinearLayoutManager(this));
        CategoryBigImageAdapter categoryBigImageAdapter = new CategoryBigImageAdapter(this, listUrl);
        mRlvCategoryBigimage.setAdapter(categoryBigImageAdapter);

        //点击条目跳转
        categoryBigImageAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent(NewShopInfoActivity.this, BigImageActivity.class);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("image", listUrl);
                intent.putExtra("bundle", bundle);
                intent.putExtra("postion", pos);
                startActivity(intent);
            }
        });

    }

    /* private void initGoodDetail(String webData) {
         getHtmlImgs(webData);
         String content = h5.replace("word", webData);
         Log.i("TAG", content);
         webView.loadDataWithBaseURL("about:blank", content, "text/html", "utf-8", null);
     }*/
    private void getHtmlImgs(String content) {
        String img = "<img[\\s\\S]*?>";
        Pattern pattern = Pattern.compile(img);
        Matcher matcher = pattern.matcher(content);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            String word = matcher.group();
            int start = word.indexOf("\"") + 1;
            int end = word.indexOf(".jpg");
            String url = word.substring(start, end);
            url = url + ".jpg";
            list.add(url);
        }
//        Log.e("TAG", "getHtmlImgs: "+list.size() );
    }

    private void initBanner(List<ShopInfoBean.DataBeanX.GalleryBean> gallery) {
        banner.setImages(gallery).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ShopInfoBean.DataBeanX.GalleryBean bean = (ShopInfoBean.DataBeanX.GalleryBean) path;
                String img_url = bean.getImg_url();
                Glide.with(context).load(img_url).into(imageView);
            }
        }).start();
    }

    private void initInfo(ShopInfoBean.DataBeanX.InfoBean info) {
        carName.setText(info.getName());
        carBrief.setText(info.getGoods_brief());
        carRetailPrice.setText("￥" + info.getRetail_price());
        String s = carRetailPrice.getText().toString();
        SpannableStringBuilder builder = new SpannableStringBuilder(s);
        builder.setSpan(new ForegroundColorSpan(Color.RED), 0, s.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        carRetailPrice.setText(builder);


        txtAddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = (int) txtAddCar.getTag();
                if (tag == 0) {
                    initPop(info);
                    tag = 1;
                }
                if (tag == 1) {
                    if (map != null) {
                        presenter.addGoodCar(map);
                        Log.e("TAG", "onClick: " + map.get("goodsId"));
                        tag = 0;
                    }
                }

            }
        });
    }


    private void initPop(ShopInfoBean.DataBeanX.InfoBean info) {
        View view = View.inflate(NewShopInfoActivity.this, R.layout.pop_addcar_item, null);
        PopupWindow pop = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, 300, true);
        pop.setBackgroundDrawable(null);
        pop.showAtLocation(view, Gravity.BOTTOM, 0, 70);
        ImageView close = view.findViewById(R.id.pop_close);
        ImageView shop_info = view.findViewById(R.id.pop_image);
        TextView shop_price = view.findViewById(R.id.pop_price);
        TextView shop_num = view.findViewById(R.id.pop_shop_num);
        TextView shop_numLose = view.findViewById(R.id.pop_numLose);
        TextView shop_numAdd = view.findViewById(R.id.pop_numAdd);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
        Glide.with(shop_info).load(info.getList_pic_url()).into(shop_info);
        shop_price.setText(info.getRetail_price() + "");
        num = 1;
        shop_numAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                shop_num.setText(num + "");
            }
        });
        shop_numLose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num--;
                if (num >= 0) {
                    shop_num.setText(num + "");
                }
            }
        });
    }


    private void initattribute(List<ShopInfoBean.DataBeanX.AttributeBean> attribute) {
        for (int i = 0; i < attribute.size(); i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.car_item, null);
            TextView text = view.findViewById(R.id.name_c);
            TextView text1 = view.findViewById(R.id.name_cv);
            text.setText(attribute.get(i).getName());
            text1.setText(attribute.get(i).getValue());
            carLinee.addView(view);
        }
    }

    private void initIssue(List<ShopInfoBean.DataBeanX.IssueBean> issue) {
        for (int i = 0; i < issue.size(); i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.car_item_issue, null);
            TextView text = view.findViewById(R.id.question);
            TextView text1 = view.findViewById(R.id.answer);
            text.setText(issue.get(i).getQuestion());
            text1.setText(issue.get(i).getAnswer());
            llIss.addView(view);
        }
    }

    private void initProduct(List<ShopInfoBean.DataBeanX.ProductListBean> productList) {
        //获取要传的id
        for (int i = 0; i < productList.size(); i++) {
            int id = productList.get(i).getGoods_id();
            presenter.getLookAll(id);
        }
    }

    //添加购物车返回
    @Override
    public void addGoodCarReturn(AddCarBean addCarBean) {
        //添加成功以后跟新数量显示
        int number = addCarBean.getData().getCartTotal().getGoodsCount();
        txtNumber.setText(String.valueOf(number));
        txtNumber.setVisibility(View.VISIBLE);
    }

    @Override
    public void getLookAllReturn(ShopLookAllBean relateBean) {
        List<ShopLookAllBean.DataBean.GoodsListBean> goodsList = relateBean.getData().getGoodsList();
        rlvProduct.setLayoutManager(new GridLayoutManager(this, 2));
        Car_Product_Adapter car_product_adapter = new Car_Product_Adapter(this, goodsList);
        rlvProduct.setAdapter(car_product_adapter);
        car_product_adapter.notifyDataSetChanged();
    }

    @Override
    public void getCarListReturn(ShopCarDataBean shopCarDataBean) {
        if (buyNumber <= 0) {
            Toast.makeText(NewShopInfoActivity.this, "请添加要购买商品", Toast.LENGTH_SHORT).show();
            return;
        }
        if (shopCarDataBean.getData().getCartList().size() > 0) {
            int goodsId = shopCarDataBean.getData().getCartList().get(0).getGoods_id();
            int productid = shopCarDataBean.getData().getCartList().get(0).getId();
            map = new HashMap<>();
            map.put("goodsId", String.valueOf(goodsId));
            map.put("number", String.valueOf(buyNumber));
            map.put("productId", String.valueOf(productid));
//            presenter.addGoodCar(map);

        }
    }


}