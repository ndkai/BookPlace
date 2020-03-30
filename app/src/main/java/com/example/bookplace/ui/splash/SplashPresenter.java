package com.example.bookplace.ui.splash;

import com.example.bookplace.data.IDataManager;
import com.example.bookplace.ui.base.BasePresenter;

public class SplashPresenter<T extends ISplashActivity> extends BasePresenter<T> {
    public SplashPresenter(IDataManager iDataManager) {
        super(iDataManager);
    }

    public void onNavigateToOtherActivity() {
//        if (getIDataManager().getShowIntroPref())
//             mIView.openIntroActivity();
//        else
            mIView.openMainActivity();
    }
}
