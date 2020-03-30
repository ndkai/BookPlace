package com.example.bookplace.data.api;

import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api implements IApi{
    private static final String BASE_URL = "http://iloveprogramming.dx.am/book_place/api/";
    private IApi mIApi;
    private Retrofit mRetrofit;

    @Inject
    public Api() {
        mRetrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        mIApi = mRetrofit.create(IApi.class);
    }

    @Override
    public Call<List<BookResponse>> getBooksApiCall() {
        return mIApi.getBooksApiCall();
    }

    @Override
    public Call<List<BookResponse>> getBookSearchApiCall(String q) {
        return mIApi.getBookSearchApiCall(q);
    }
}
