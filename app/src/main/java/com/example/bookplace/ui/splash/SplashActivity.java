package com.example.bookplace.ui.splash;

import android.os.Bundle;

import com.example.bookplace.ui.base.BaseActivity;
import com.example.bookplace.ui.intro.IntroActivity;
import com.example.bookplace.ui.main.MainActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements ISplashActivity{

    @Inject
    SplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getIActivityComponent().inject(this);

        mSplashPresenter.onAttached(this);

        mSplashPresenter.onNavigateToOtherActivity();
    }

    @Override
    public void openMainActivity() {
        MainActivity.open(this);
    }

    @Override
    public void openIntroActivity() {
        IntroActivity.open(this);
    }
}
