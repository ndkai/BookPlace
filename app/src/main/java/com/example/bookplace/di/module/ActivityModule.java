package com.example.bookplace.di.module;

import com.example.bookplace.data.IDataManager;
import com.example.bookplace.ui.base.BaseActivity;
import com.example.bookplace.ui.home.HomePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    BaseActivity mBaseActivity;

    public ActivityModule(BaseActivity baseActivity) {
        this.mBaseActivity = baseActivity;
    }

    @Provides
    HomePresenter provideHomePresenter(IDataManager iDataManager){
        return new HomePresenter(iDataManager);
    }
}
