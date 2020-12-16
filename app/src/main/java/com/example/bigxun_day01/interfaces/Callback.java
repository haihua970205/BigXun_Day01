package com.example.bigxun_day01.interfaces;

public interface Callback<T> {

    void success(T data);

    void fail(String err);

}
