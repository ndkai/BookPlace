package com.example.bookplace.ui.home;

import android.util.Log;

import com.example.bookplace.data.IDataManager;
import com.example.bookplace.data.api.BookResponse;
import com.example.bookplace.ui.base.BasePresenter;
import com.example.bookplace.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter<T extends IHomeFragment> extends BasePresenter<T> {
    public HomePresenter(IDataManager iDataManager) {
        super(iDataManager);
    }


    public void onSetupViewFlipper() {
        mIView.setupViewFlipper(Constants.FLIPPER_IMG_RES_ID);
    }

    private Callback<List<BookResponse>> mShowBooksCallBack =
            new Callback<List<BookResponse>>() {
        @Override
        public void onResponse(Call<List<BookResponse>> call, Response<List<BookResponse>> response) {
            mIView.showBooks(response.body());
        }

        @Override
        public void onFailure(Call<List<BookResponse>> call, Throwable t) {
            Log.d("AAA", "onFailure: " + t.getMessage());
        }
    };

    public void onSetupRecyclerViewBooksComplete() {
        getIDataManager()
                .getBooksApiCall()
                .enqueue(mShowBooksCallBack);
    }

    public void onSearchBookRequest(String q) {
        getIDataManager()
                .getBookSearchApiCall(q)
                .enqueue(mShowBooksCallBack);
    }
}
