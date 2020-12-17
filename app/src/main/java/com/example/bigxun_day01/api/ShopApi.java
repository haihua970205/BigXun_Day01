package com.example.bigxun_day01.api;

import com.example.bigxun_day01.model.home.bean.HomeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ShopApi {
    String BASE_URL = "https://cdplay.cn/";

    @GET("api/index")
    Flowable<HomeBean> getHome();
}
