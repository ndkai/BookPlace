package com.example.bookplace.data;

import com.example.bookplace.data.api.IApi;
import com.example.bookplace.data.db.IDb;
import com.example.bookplace.data.pref.IPref;

import javax.inject.Inject;
import javax.inject.Singleton;
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
}
