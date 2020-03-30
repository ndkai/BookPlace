package com.example.bookplace.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookplace.R;
import com.example.bookplace.data.api.BookResponse;
import com.example.bookplace.ui.base.BaseFragment;
import com.example.bookplace.ui.base.BasePaginationScrollListener;
import com.example.bookplace.ui.others.SpacingDecorator;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment implements IHomeFragment {
    @BindView(R.id.view_flipper)
    ViewFlipper mViewFlipper;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerViewBooks;

    @Inject
    HomePresenter mHomePresenter;

    @Inject
    BookAdapter mBookAdapter;

    @Inject
    GridLayoutManager mGridLayoutManager;

    @Inject
    SpacingDecorator mSpacingDecorator;

    @Inject
    BasePaginationScrollListener mBasePaginationScrollListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getBaseActivity().getIActivityComponent().inject(this);
        mHomePresenter.onAttached(this);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setUnbinder(ButterKnife.bind(this, view));
        setupViews();
        super.onViewCreated(view, savedInstanceState);
    }

    private void setupViews() {
        mHomePresenter.onSetupViewFlipper();
        setupRecyclerViewBooks();
    }

    @Override
    public void setupViewFlipper(List<Integer> flipperImgResIds) {
        addImgsToViewFlipper(flipperImgResIds);
        mViewFlipper.setFlipInterval(3200);
        mViewFlipper.setInAnimation(
                AnimationUtils.loadAnimation(getContext(), R.anim.flip_in)
        );
        mViewFlipper.setOutAnimation(
                AnimationUtils.loadAnimation(getContext(), R.anim.flip_out)
        );
        mViewFlipper.setAutoStart(true);
        mViewFlipper.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            Log.d("AAA", String.format(
                    "setupViewFlipper: %d $d $d $d ",
                    scrollX, scrollY, oldScrollX, oldScrollY
            ));
        });

        mViewFlipper.startFlipping();
    }

    @Override
    public void showBooks(List<BookResponse> body) {
        mBookAdapter.setmBookResponses(body);
        mRecyclerViewBooks.scrollToPosition(0);
    }

    public void setupRecyclerViewBooks() {
        // inject presenter for callback latter, like onClick ...
        mBookAdapter.setmHomePresenter(mHomePresenter);
        mRecyclerViewBooks.setAdapter(mBookAdapter);
        mRecyclerViewBooks.addItemDecoration(mSpacingDecorator);
        mRecyclerViewBooks.setLayoutManager(mGridLayoutManager);

        mHomePresenter.onSetupRecyclerViewBooksComplete();

//        mBasePaginationScrollListener.setmLayoutManager(mGridLayoutManager);
//        mRecyclerViewBooks.setOnScrollListener(mBasePaginationScrollListener);
    }

    private void addImgsToViewFlipper(List<Integer> flipperImgResIds) {
        for (Integer imgResId : flipperImgResIds) {
            ImageView img = new ImageView(getContext());
            Glide.with(getContext())
                    .load(imgResId)
                    .centerCrop()
                    .into(img);
            mViewFlipper.addView(img);
        }
    }

    @OnClick(R.id.search_bar)
    public void onSearchBarClicked(View view){
        getBaseActivity().addFragment(
                R.id.container,
                new SearchFragment(mHomePresenter)
        );
    }

    @Override
    public void onDestroyView() {
        mHomePresenter.onDetached();
        super.onDestroyView();
    }

}
