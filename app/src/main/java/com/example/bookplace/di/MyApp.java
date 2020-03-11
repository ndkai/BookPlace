package com.example.bookplace.di;

import android.app.Application;

import com.example.bookplace.data.IDataManager;
import com.example.bookplace.di.component.DaggerIAppComponent;
import com.example.bookplace.di.component.IAppComponent;
import com.example.bookplace.di.module.AppModule;

import javax.inject.Inject;

/*
* hold global components in all lifetime of app
* */
public class MyApp extends Application {
    @Inject
    IDataManager mIDataManager;

    IAppComponent mIAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mIAppComponent = DaggerIAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        mIAppComponent.inject(this);
    }

    public IAppComponent getIAppComponent() {
        return mIAppComponent;
    }
}
