package com.example.bookplace.ui.intro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.bookplace.R;
import com.example.bookplace.ui.main.MainActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class IntroPagerAdapter extends PagerAdapter {
    private static final List<Integer> INTRO_IMG_LIST = Arrays.asList(
            R.drawable.intro_call_and_message_with_people,
            R.drawable.intro_best_price,
            R.drawable.intro_give_information_about_book,
            R.drawable.intro_more_resource,
            R.drawable.intro_comment_rating_and_epload_euestion
    );

    @Inject
    public IntroPagerAdapter() {
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater
                .from(container.getContext())
                .inflate(R.layout.item_intro, container, false);

        bindView(view, position);
        container.addView(view);
        return view;
    }

    private void bindView(View view, int position) {
        ImageView introIm = view.findViewById(R.id.img_intro);

        // use Glide to make the view pager loading image faster and smoother
        Glide.with(view)
                .load(INTRO_IMG_LIST.get(position))
                .fitCenter()
                .into(introIm);
        introIm.setImageResource(INTRO_IMG_LIST.get(position));
        introIm.setScaleType(ImageView.ScaleType.FIT_XY);

        if (position == INTRO_IMG_LIST.size()-1) {
            Button btnGo = view.findViewById(R.id.btn_go);
            btnGo.setVisibility(View.VISIBLE);
            btnGo.setOnClickListener(v -> MainActivity.open(v.getContext()));
        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return INTRO_IMG_LIST.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
