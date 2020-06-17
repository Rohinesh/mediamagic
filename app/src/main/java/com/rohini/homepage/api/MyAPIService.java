package com.rohini.homepage.api;

import com.rohini.homepage.bean.Bookbean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPIService {
    @GET("list")
    Call<List<Bookbean>> getBookList();
}
