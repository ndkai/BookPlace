package com.example.bookplace.data;

import com.example.bookplace.data.api.BookResponse;
import com.example.bookplace.data.api.IApi;
import com.example.bookplace.data.db.IDb;
import com.example.bookplace.data.pref.IPref;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;

/*
* Implementation of IDataManager which is the data port
* for all presenters accessing
* */
@Singleton
public class DataManager implements IDataManager {
    
    private IDb mIDb;
    private IPref mIPref;
    private IApi mIApi;
    
    @Inject
    public DataManager(IDb iDb, IPref iPref, IApi iApi) {
        this.mIDb = iDb;
        this.mIPref = iPref;
        this.mIApi = iApi;
    }

    @Override
    public boolean getShowIntroPref() {
        return mIPref.getShowIntroPref();
    }

    @Override
    public void setShowIntroPref(boolean showIntro) {
        mIPref.setShowIntroPref(showIntro);
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
