package com.example.bookplace.ui.base;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import butterknife.Unbinder;


public class BaseFragment extends Fragment implements IBaseView{
    private BaseActivity mBaseActivity;
    private Unbinder mUnbinder;

    public BaseFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity)
            mBaseActivity = (BaseActivity) context;
    }

    @Override
    public void onDestroyView() {
        if (mUnbinder != null) mUnbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        if (mBaseActivity != null) mBaseActivity = null;
        super.onDetach();
    }

    @Override
    public void showToast(String msg) {
        mBaseActivity.showToast(msg);
    }

    public void setUnbinder(Unbinder mUnbinder) {
        this.mUnbinder = mUnbinder;
    }

    public BaseActivity getBaseActivity() {
        return mBaseActivity;
    }
}
