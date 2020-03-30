package com.example.bookplace.ui.base;

/*
* The abstraction for all IView like IMainActivity, later
* */
public interface IBaseView {

    void showToast(String msg);

    void showProgressDialog();

    void hideProgressDialog();
}
