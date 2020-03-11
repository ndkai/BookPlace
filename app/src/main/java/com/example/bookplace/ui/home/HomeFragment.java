package com.example.bookplace.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookplace.R;
import com.example.bookplace.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment implements IHomeFragment {
    @BindView(R.id.view_flipper)
    ViewFlipper mViewFlipper;

    @Inject
    HomePresenter mHomePresenter;

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
        mViewFlipper.startFlipping();
    }

    private void addImgsToViewFlipper(List<Integer> flipperImgResIds) {
        for (Integer imgResId : flipperImgResIds) {
            ImageView img = new ImageView(getContext());
            img.setImageResource(imgResId);
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mViewFlipper.addView(img);
        }
    }
}
