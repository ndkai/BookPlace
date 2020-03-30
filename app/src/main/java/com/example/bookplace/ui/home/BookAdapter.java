package com.example.bookplace.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookplace.R;
import com.example.bookplace.data.api.BookResponse;
import com.example.bookplace.ui.base.BaseViewHolder;
import com.example.bookplace.utils.MyUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ProductViewHolder> {

    private List<BookResponse> mBookResponses;

    private HomePresenter mHomePresenter;

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ProductViewHolder(
                inflater.inflate(R.layout.item_book_product, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        // when a bookAdapter is set to a recycler view
        // mBookResponses have not still set
        // util presenter call iView.showBooks(data)
        // so check mBookResponses != null
        return mBookResponses != null ?
                mBookResponses.size() : 0;
    }

    public void setmBookResponses(List<BookResponse> mBookResponses) {
        this.mBookResponses = mBookResponses;
        notifyDataSetChanged();
    }

    public void setmHomePresenter(HomePresenter mHomePresenter) {
        this.mHomePresenter = mHomePresenter;
    }

    class ProductViewHolder extends BaseViewHolder {
        @BindView(R.id.img_product)
        ImageView imgProduct;

        @BindView(R.id.tv_title)
        TextView tvTitle;

        @BindView(R.id.tv_autor)
        TextView tvAuthor;

        @BindView(R.id.tv_price)
        TextView tvPrice;

        @BindView(R.id.star_bar)
        AppCompatRatingBar starBar;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind( this, itemView);
        }

        @Override
        public void bindView(int position) {
            BookResponse bookResponse = mBookResponses.get(position);

            tvTitle.setText(
                    MyUtil.cutTitle(bookResponse.getTitle())
            );

            tvPrice.setText(
                    MyUtil.formatToPriceString(bookResponse.getPrice())
            );

            if (! bookResponse.getAuthor().isEmpty())
                tvAuthor.setText(
                        bookResponse.getAuthor()
                );
            else tvAuthor.setVisibility(View.GONE);

            starBar.setProgress(bookResponse.getStarNum());

            Glide.with(itemView)
                    .load(bookResponse.getImgLink())
                    .centerCrop()
                    .into(imgProduct);
        }
    }
}
