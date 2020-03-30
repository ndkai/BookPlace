package com.example.bookplace.di.module;


import android.content.Context;

import com.example.bookplace.data.DataManager;
import com.example.bookplace.data.IDataManager;
import com.example.bookplace.data.api.Api;
import com.example.bookplace.data.api.IApi;
import com.example.bookplace.data.db.Db;
import com.example.bookplace.data.db.IDb;
import com.example.bookplace.data.pref.IPref;
import com.example.bookplace.data.pref.Pref;
import com.example.bookplace.di.MyApp;
import com.example.bookplace.di.annotation.AppContext;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private MyApp mMyApp;

    public AppModule(MyApp myApp) {
        this.mMyApp = myApp;
    }

    @Provides
    IDataManager provideIDataManager(DataManager dataManager){
        return dataManager;
    }

    @Provides
    IApi provideIApi(Api api) {return api;}

    @Provides
    IDb provideIDb(Db db) {return db;}

    @Provides
    IPref provideIPref(Pref pref) {return pref;}

    @Provides
    @AppContext
    Context provideAppContext() {return mMyApp;}

}
