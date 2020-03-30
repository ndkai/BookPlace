package com.example.bookplace.data.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApi {
    @GET("books.php")
    Call<List<BookResponse>> getBooksApiCall();

    @GET("books.php")
    Call<List<BookResponse>> getBookSearchApiCall(@Query("q") String q);
}
