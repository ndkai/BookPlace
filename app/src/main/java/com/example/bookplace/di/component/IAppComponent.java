package com.example.bookplace.di.component;

import com.example.bookplace.data.IDataManager;
import com.example.bookplace.di.MyApp;
import com.example.bookplace.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface IAppComponent {
    void inject(MyApp myApp);

    IDataManager getIDataManager();

}
