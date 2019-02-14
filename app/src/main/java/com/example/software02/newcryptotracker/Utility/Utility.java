package com.example.software02.newcryptotracker.Utility;

import com.example.software02.newcryptotracker.Model.CryptoNews;
import com.example.software02.newcryptotracker.Model.RootPrices;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Utility {

    private static Retrofit retrofit = null;
    private static Retrofit retrofitForCurrency = null;
    private static  cryptoService service = null;
    private static  cryptoPricesService cryptoPricesService = null;

    public static cryptoService getRetrofit(String baseUrl){
        if(service == null){
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
            service =retrofit.create(cryptoService.class);
            return service;
        }
        else
            return  service;
    }
    public static cryptoPricesService getRetrofitForCurrency(String baseUrl){
        if(cryptoPricesService == null){
            OkHttpClient.Builder  okBuilder = new OkHttpClient.Builder();
            okBuilder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request().newBuilder().
                            addHeader( "X-CMC_PRO_API_KEY", "68a91fb8-6883-4e93-8e0c-a80afde391bd").build();
                    return chain.proceed(request);
                }
            });
            retrofitForCurrency = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).
                    baseUrl(baseUrl).client(okBuilder.build()).build();
            cryptoPricesService = retrofitForCurrency.create(cryptoPricesService.class);
        return cryptoPricesService;
        }
        else
            return cryptoPricesService;

    }

    public interface cryptoService {
        @GET("/v2/top-headlines?sources=crypto-coins-news&apiKey=dd916d3e6c5e49ec88cd9ba481ae8e3e")
        Call<CryptoNews> listCryptos();
    }

    public interface cryptoPricesService{
        @GET("/v1/cryptocurrency/listings/latest")
        Call<RootPrices> listCryptoPrices();
    }
}
