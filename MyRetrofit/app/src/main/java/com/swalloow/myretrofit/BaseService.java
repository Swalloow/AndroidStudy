package com.swalloow.myretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Junyoung on 2016-07-09.
 */

public class BaseService {
    protected static Object retrofit(Class<?> className) {
        String host = "http://test.susemi99.kr/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(host).addConverterFactory(GsonConverterFactory.create()).build();
        //    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
        //    return new Retrofit.Builder().baseUrl(host).addConverterFactory(GsonConverterFactory.create(gson)).build();
        //    return new Retrofit.Builder().baseUrl(host).addConverterFactory(GsonConverterFactory.create()).client(client()).build();
        //    return new Retrofit.Builder().baseUrl(host).addConverterFactory(GsonConverterFactory.create(gson)).client(client()).build();
        return retrofit(className);
    }

    //  private static OkHttpClient client()
    //  {
    //    return new OkHttpClient.Builder().addInterceptor(new Interceptor()
    //    {
    //      @Override
    //      public Response intercept(Chain chain) throws IOException
    //      {
    //        Request original = chain.request();
    //        Request.Builder requestBuilder = original.newBuilder().method(original.method(), original.body());
    //
    //        String token = "sample-token";
    //        if (!TextUtils.isEmpty(token))
    //          requestBuilder.header("Authorization", token);
    //
    //        String locale = Locale.getDefault().getLanguage();
    //        requestBuilder.header("X-Locale", locale);
    //
    //        Request request = requestBuilder.build();
    //        return chain.proceed(request);
    //      }
    //    }).build();
    //  }
}
