package com.service;

import com.entities.Banner;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BannerService {

    @GET("motel/findall")
    Call<List<Banner>> findAll();
}
