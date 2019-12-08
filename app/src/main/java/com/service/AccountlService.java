package com.service;


import com.entities.Account;
import com.entities.Motel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface AccountlService {
    @GET("account/checkaccount/{username}/{password}")
    Call<List<Account>> checkaccount(@Path("username") String username,@Path("password") String password);


   /* @POST("invoice/create")
    Call<Invoice> create(@Body Invoice invoice);

    @GET("invoice/findInvoiceByStatus/{status}")
    Call<List<Invoice>> search(@Path("status") String keyword);

    @GET("invoice/findInvoiceByYear/{month}/{year}")
    Call<List<Invoice>> searchYear(@Path("month") int month, @Path("year") int year);
    @GET("invoice/findNewInvoice/{limit}")
    Call<List<Invoice>> findNewInvoice(@Path("limit") int limit);*/
}
