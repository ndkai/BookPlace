package com.example.bookplace.ui.home;

import com.example.bookplace.ui.base.IBaseView;

import java.util.List;

public interface IHomeFragment extends IBaseView {
    void setupViewFlipper(List<Integer> flipperImgResIds);
}
