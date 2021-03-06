package com.assignment.ideapro.yha.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignment.ideapro.yha.R;
import com.assignment.ideapro.yha.data.vos.NewProductVO;
import com.assignment.ideapro.yha.delegates.INewProductDelegate;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewProductViewHolder extends RecyclerView.ViewHolder {

    private INewProductDelegate mDelegate;
    private NewProductVO mNewProduct;

    @BindView(R.id.iv_publication)
    ImageView ivPublication;

    @BindView(R.id.tv_caption)
    TextView tvCaption;

    public NewProductViewHolder(View itemView, INewProductDelegate newProductDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.mDelegate = newProductDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onTapImage(mNewProduct);
            }
        });
    }

    public void setNewProduct(NewProductVO newProduct) {
        this.mNewProduct = newProduct;
        if (newProduct != null) {
            Glide.with(itemView.getContext())
                    .load(newProduct.getProductImage())
                    .into(ivPublication);
            tvCaption.setText(newProduct.getProductTitle());
        }
    }
}
