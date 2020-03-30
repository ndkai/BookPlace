package com.example.bookplace.ui.intro;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class Indicator extends LinearLayout {
    private ViewPager mViewPager;
    private TextView[] mIndicatorTextViews;
    private int mUnselectedIndicatorColor;
    private int mSelectedIndicatorColor;
    private int mIndicatorSize;
    private int mPrevPos = -1;

    public Indicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /*
    * set view paper for indicator
    * @warning: call this after all settings for Indicator,
    *   otherwise the settings won't be applied
    * */
    public void setViewPager(ViewPager mViewPager) {
        this.mViewPager = mViewPager;
        onViewPagerSet();
    }

    public ViewPager getViewPager() {
        return mViewPager;
    }

    private void onViewPagerSet() {
        initIndicators();
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                setIndicator(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initIndicators() {
        mIndicatorTextViews = new TextView[getIndicatorsNum()];
        for (int i=0; i<getIndicatorsNum(); i++){
            mIndicatorTextViews[i] = new TextView(getContext());
            mIndicatorTextViews[i].setText("*");
            mIndicatorTextViews[i].setTextColor(mUnselectedIndicatorColor);
            mIndicatorTextViews[i].setTextSize(mIndicatorSize);
            addView(mIndicatorTextViews[i]);
        }
    }

    private int getIndicatorsNum() {
        return mViewPager.getAdapter().getCount();
    }

    private void setIndicator(int position) {
        if (mPrevPos != -1)
            mIndicatorTextViews[mPrevPos].setTextColor(mUnselectedIndicatorColor);
        mIndicatorTextViews[position].setTextColor(mSelectedIndicatorColor);
        mPrevPos = position;
    }

    public int getUnselectedIndicatorColor() {
        return mUnselectedIndicatorColor;
    }

    public void setUnselectedIndicatorColor(int mUnselectedIndicatorColor) {
        this.mUnselectedIndicatorColor = mUnselectedIndicatorColor;
    }

    public int getSelectedIndicatorColor() {
        return mSelectedIndicatorColor;
    }

    public void setSelectedIndicatorColor(int mSelectedIndicatorColor) {
        this.mSelectedIndicatorColor = mSelectedIndicatorColor;
    }

    public int getIndicatorSize() {
        return mIndicatorSize;
    }

    public void setIndicatorSize(int mIndicatorSize) {
        this.mIndicatorSize = mIndicatorSize;
    }
}
