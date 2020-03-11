package com.example.bookplace.ui.home;

import com.example.bookplace.data.IDataManager;
import com.example.bookplace.ui.base.BasePresenter;
import com.example.bookplace.utils.Constants;

public class HomePresenter<T extends IHomeFragment> extends BasePresenter<T> {
    public HomePresenter(IDataManager iDataManager) {
        super(iDataManager);
    }


    public void onSetupViewFlipper() {
        mIView.setupViewFlipper(Constants.FLIPPER_IMG_RES_ID);
    }
}
