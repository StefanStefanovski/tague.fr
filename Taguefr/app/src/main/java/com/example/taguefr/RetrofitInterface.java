package com.example.taguefr;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface  {

    @POST("/item")
    Call<ItemInfo> executeGetItem(@Body HashMap<String, String> map);
}
