package com.swalloow.myretrofit.networks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Junyoung on 2016-07-09.
 */

public class BaseService {
    // Base Network Service
    protected static Object retrofit(Class<?> className) {
        String host = "https://api.github.com";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(host).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(className);
    }
}
