package com.example.bigxun_day01.api;

import com.example.bigxun_day01.model.brand.InfoBrandBean;
import com.example.bigxun_day01.model.home.bean.HomeBean;
import com.example.bigxun_day01.model.lookactivitybean.LookTabBean;
import com.example.bigxun_day01.model.lookactivitybean.LookInfoFragmentBean;
import com.example.bigxun_day01.model.brand.BrandListBean;
import com.example.bigxun_day01.model.newgoods.NewGoodAllBean;
import com.example.bigxun_day01.model.newgoods.NewGoodFristBean;
import com.example.bigxun_day01.model.newgoods.NewGoodOlderBean;
import com.example.bigxun_day01.model.newshopinfo.ShopInfoBean;
import com.example.bigxun_day01.model.newshopinfo.ShopLookAllBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ShopApi {
    String BASE_URL = "https://cdplay.cn/";

    //    https://cdplay.cn/api/goods/list/id=1005000&page=1&size=100
    @GET("api/index")
    Flowable<HomeBean> getHome();

    //api/catalog/index/pages/category/category
    //商场 详情页 ?id=1-2-3-4... 分类
    @GET("api/catalog/index/pages/category/category")
    Flowable<LookTabBean> getTabData(@Query("id") int id);

    //https://cdplay.cn/api/goods/list?categoryId=1005000
    //商场 详情页 ?id=1005000 分类数据
    @GET("api/goods/list")
    Flowable<LookInfoFragmentBean> getListData(@Query("categoryId") int id);
//            Flowable<SPListDetailsBean> getListData(@Query("categoryId") int cid)

    //    https://cdplay.cn/api/brand/list?brandId=1001000
    @GET("api/brand/list")
    Flowable<BrandListBean> getBrand(@Query("page") int page);

    @GET("brand/detail")
    Flowable<InfoBrandBean> getInfoBrand(@Query("id") int id);

    @GET("api/goods/list")
    Flowable<LookInfoFragmentBean> getInfoList(@Query("brandId") int brandId);

    //    新品首发
    //    https://cdplay.cn/api/goods/hot -- top-background
    @GET("goods/hot")
    Flowable<NewGoodFristBean> getNewGoodFirstBean();

    //    价格升降序
    //    https://cdplay.cn/api/goods/list?1181000isNew=1&page=1&size =1000&order=asc&sort=default&categoryId=0
    @GET("goods/list")
    Flowable<NewGoodOlderBean> getNewGoodOlderBean(@QueryMap Map<String, String> map);

    //    总和+分类
    //    https://cdplay.cn/api/goods/list?isNew=1&page=1&size=1000
    @GET("goods/list")
    Flowable<NewGoodAllBean> getNewGoodAllBean(@QueryMap Map<String, String> map);
//https://cdplay.cn/api/goods/detail?id=1155000
    //新商品点击跳转穿id
    @GET(" api/goods/detail")
    Flowable<ShopInfoBean> getShopInfo(@Query("id")int id);
    @GET("api/goods/related")
    Flowable<ShopLookAllBean> getLookAll(@Query("id")int id);

}
