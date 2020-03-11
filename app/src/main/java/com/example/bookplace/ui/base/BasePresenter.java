package com.example.bookplace.ui.base;

import com.example.bookplace.data.IDataManager;

import javax.inject.Inject;

/*
* Each Presenter must to extend this class, MainPresenter for example
* The derived class can use available components from BasePresenter
* like IDataManager, the interface to view ...
* */

public class BasePresenter<T extends IBaseView>{

    protected T mIView;

    private IDataManager mIDataManager;

    @Inject
    public BasePresenter(IDataManager iDataManager) {
        this.mIDataManager = iDataManager;
    }

    public void onAttached(T iBaseView) {
        this.mIView = iBaseView;
    }

    public void onDetached() {
        if (mIView != null) mIView = null;
    }

    public IDataManager getIDataManager() {
        return mIDataManager;
    }
}
