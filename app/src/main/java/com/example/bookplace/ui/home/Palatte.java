//package com.example.bookplace.ui.home;
//
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ImageView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.palette.graphics.Palette;
//
//import com.google.android.material.appbar.AppBarLayout;
//import com.google.android.material.appbar.CollapsingToolbarLayout;
//
//public class Palatte extends AppCompatActivity {
//    private CollapsingToolbarLayout mCollToolLayout;
//    private AppBarLayout mAppBarLayout;
//    private ImageView mHeaderImg;
//    private int mImgHeaderIndex = 1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.parallax_header_activity);
//
//        findViews();
//        setupViews();
//    }
//
//    private void findViews() {
//        mCollToolLayout = findViewById(R.id.collToolLayout);
//        mHeaderImg = findViewById(R.id.img_heaader);
//        mAppBarLayout = findViewById(R.id.app_bar_layout);
//    }
//
//    private void setupViews() {
//        setupToolbar();
//        makeToolbarAndStatusBackgroundSameToHeader();
//        setAutoChangeHeaderImg();
//    }
//
//    private void setAutoChangeHeaderImg() {
//        mAppBarLayout.addOnOffsetChangedListener(
//                new AppBarLayout.OnOffsetChangedListener() {
//                    private int prevI = -1;
//                    @Override
//                    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
//                        if (Math.abs(i) - appBarLayout.getTotalScrollRange() == 0
//                            && i != prevI){
//                            setHeaderImg();
//                            makeToolbarAndStatusBackgroundSameToHeader();
//                            nextHeaderImgIndex();
//                        }
//                        prevI = i;
//                    }
//                }
//        );
//    }
//
//    private void setHeaderImg() {
//        mHeaderImg.setImageResource(getHeaderImgResId());
//    }
//
//    private void nextHeaderImgIndex() {
//        if (mImgHeaderIndex == 2) mImgHeaderIndex = 0;
//        else mImgHeaderIndex++;
//    }
//
//    private int getHeaderImgResId() {
//        switch (mImgHeaderIndex) {
//            case 0: return R.drawable.background1;
//            case 1: return R.drawable.background2;
//            default: return R.drawable.background3;
//        }
//    }
//
//    private void setupToolbar() {
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//    }
//
//    private void makeToolbarAndStatusBackgroundSameToHeader() {
//        try{
//            setScrimContents();
//        } catch (Exception e) {
//            setDefaultScrimContents();
//            Log.d("AAA", "Er " + e.getMessage() + "");
//        }
//    }
//
//    private void setScrimContents() {
//        Bitmap header = BitmapFactory
//                .decodeResource(getResources(), getHeaderImgResId());
//        Palette.from(header).generate(
//                new Palette.PaletteAsyncListener() {
//                    @Override
//                    public void onGenerated(@Nullable Palette palette) {
//                        if (palette != null) {
//                            // the warning is ok
//                            // follow the suggestion will work incorrectly
//                            int vibrantColor = palette
//                                    .getVibrantColor(R.color.strimContentColor);
//                            int vibrantDarkColor = palette
//                                    .getDarkVibrantColor(R.color.colorPrimary);
//
//                            mCollToolLayout.setContentScrimColor(vibrantColor);
//                            mCollToolLayout.setStatusBarScrimColor(vibrantDarkColor);
//                        }
//                        else setDefaultScrimContents();
//                    }
//                }
//        );
//    }
//
//    private void setDefaultScrimContents() {
//        mCollToolLayout.setContentScrimColor(
//                getColor(R.color.strimContentColor));
//        mCollToolLayout.setStatusBarScrimColor(
//                getColor(R.color.colorPrimary));
//    }
//
//}
