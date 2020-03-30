package com.example.bookplace.ui.intro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import com.example.bookplace.R;
import com.example.bookplace.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntroActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @BindView(R.id.indicator)
    Indicator mIndicator;

    @Inject
    IntroPagerAdapter mIntroPagerAdapter;

    public static void open(Context context) {
        Intent intent = new Intent(context, IntroActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getIActivityComponent().inject(this);
        ButterKnife.bind(this);

        setupViews();
    }

    private void setupViews() {
        mViewPager.setAdapter(mIntroPagerAdapter);
        mViewPager.setOffscreenPageLimit(5);
        mIndicator.setIndicatorSize(25);
        mIndicator.setSelectedIndicatorColor(getColor(R.color.colorPrimaryDark));
        mIndicator.setUnselectedIndicatorColor(getColor(R.color.colorPrimaryLight));
        mIndicator.setViewPager(mViewPager);
    }

}
