package com.example.bookplace.di.component;

import com.example.bookplace.di.annotation.PerActivity;
import com.example.bookplace.di.module.ActivityModule;
import com.example.bookplace.ui.home.HomeFragment;
import com.example.bookplace.ui.intro.IntroActivity;
import com.example.bookplace.ui.main.MainActivity;
import com.example.bookplace.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(modules = ActivityModule.class, dependencies = IAppComponent.class)
public interface IActivityComponent {
    void inject(MainActivity mainActivity);

    void inject(HomeFragment homeFragment);

    void inject(SplashActivity splashActivity);

    void inject(IntroActivity introActivity);
}


