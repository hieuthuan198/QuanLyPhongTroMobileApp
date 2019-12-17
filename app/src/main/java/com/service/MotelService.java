package com.service;


import com.entities.Motel;
import com.entities.Motel1;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface MotelService {
    @GET("motel/findall")
    Call<List<Motel>> findAllMotel1();

    @GET("motel/get/{name}")
    Call<byte[]> getImage(@Path("name") String name);

    @GET("motel/findbyusername/{username}")
    Call<List<Motel>> findByUsername(@Path("username")String username);

    @PUT("motel/update")
    Call<Motel> update(@Body Motel motel);
   /* @POST("invoice/create")
    Call<Invoice> create(@Body Invoice invoice);

    @GET("invoice/findInvoiceByStatus/{status}")
    Call<List<Invoice>> search(@Path("status") String keyword);

    @GET("invoice/findInvoiceByYear/{month}/{year}")
    Call<List<Invoice>> searchYear(@Path("month") int month, @Path("year") int year);
    @GET("invoice/findNewInvoice/{limit}")
    Call<List<Invoice>> findNewInvoice(@Path("limit") int limit);*/
}
