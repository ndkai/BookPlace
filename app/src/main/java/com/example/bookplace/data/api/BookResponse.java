package com.example.bookplace.data.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookResponse {

    @Expose
    private String title;

    @Expose
    private String author;

    @Expose
    private float price;

    @Expose
    @SerializedName("star_num")
    private int starNum;

    @Expose
    @SerializedName("book_type_id")
    private int bookTypeId;

    @Expose
    @SerializedName("img_link")
    private String imgLink;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public float getPrice() {
        return price;
    }

    public int getStarNum() {
        return starNum;
    }

    public int getBookTypeId() {
        return bookTypeId;
    }

    public String getImgLink() {
        return imgLink;
    }
}
