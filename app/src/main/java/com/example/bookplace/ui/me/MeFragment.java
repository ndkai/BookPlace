package com.example.bookplace.ui.me;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookplace.R;
import com.example.bookplace.ui.base.BaseFragment;

import butterknife.ButterKnife;
/*
* Setting personal profile, login, logout ...
* */
public class MeFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_me, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setUnbinder(ButterKnife.bind(this, view));
        setupViews();
        super.onViewCreated(view, savedInstanceState);
    }

    private void setupViews() {

    }
}
