package com.example.bookplace.di.module;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bookplace.data.IDataManager;
import com.example.bookplace.di.annotation.ActivityContext;
import com.example.bookplace.ui.base.BaseActivity;
import com.example.bookplace.ui.base.BasePaginationScrollListener;
import com.example.bookplace.ui.home.BookAdapter;
import com.example.bookplace.ui.home.HomePresenter;
import com.example.bookplace.ui.others.SpacingDecorator;
import com.example.bookplace.ui.splash.SplashPresenter;

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
    
    @Provides
    SplashPresenter provideSplashPresenter(IDataManager iDataManager){
        return new SplashPresenter(iDataManager);
    }
    
    @Provides
    @ActivityContext
    Context provideContext(){
        return mBaseActivity;
    }

    @Provides
    BookAdapter provideBookAdapter(){
        return new BookAdapter();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(){
        return new LinearLayoutManager(mBaseActivity);
    }

    @Provides
    GridLayoutManager provideGridLayoutManager(){
        return new GridLayoutManager(mBaseActivity, 2);
    }

    @Provides
    SpacingDecorator provideSpacingDecorator(){
        return new SpacingDecorator(2, 5, 5, false);
    }

    @Provides
    BasePaginationScrollListener provideBasePaginationScrollListener(){
        return new BasePaginationScrollListener();
    }

}
