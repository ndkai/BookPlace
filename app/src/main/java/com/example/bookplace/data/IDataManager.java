package com.example.bookplace.data;

import com.example.bookplace.data.api.IApi;
import com.example.bookplace.data.db.IDb;
import com.example.bookplace.data.pref.IPref;

/*
* The data port for all of the presenters accessing through
* */
public interface IDataManager extends IApi, IDb, IPref {

}
