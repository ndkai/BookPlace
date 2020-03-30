package com.example.bookplace.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookplace.R;
import com.example.bookplace.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchFragment extends BaseFragment {
    private HomePresenter mHomePresenter;

    @BindView(R.id.edt_search)
    EditText mEditTextSearch;

    public SearchFragment(HomePresenter mHomePresenter) {
        this.mHomePresenter = mHomePresenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.fragment_search,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUnbinder(ButterKnife.bind(this, view));
        setupViews();
    }

    private void setupViews() {
        mEditTextSearch.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE){
                mHomePresenter.onSearchBookRequest(
                        mEditTextSearch.getText().toString()
                );
                getBaseActivity().backFragment();
                return true;
            }
            return false;
        });
        getBaseActivity().setAutoShowHideKeyboardFor(mEditTextSearch);
        mEditTextSearch.requestFocus();
    }

    @OnClick(R.id.btn_back)
    public void onBtnBackClicked(View view) {
        getBaseActivity().backFragment();
    }
}
