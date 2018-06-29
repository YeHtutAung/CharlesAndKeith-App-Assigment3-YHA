package com.assignment.ideapro.yha.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.assignment.ideapro.yha.R;
import com.assignment.ideapro.yha.data.vos.NewProductVO;
import com.assignment.ideapro.yha.delegates.INewProductDetailsDelegate;
import com.bumptech.glide.Glide;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NewProductDetailsViewHodler extends RecyclerView.ViewHolder {

    private INewProductDetailsDelegate mDelegate;
    private NewProductVO mNewProduct;

    @BindView(R.id.iv_details_publication)
    ImageView ivDetailsPublication;

    @BindView(R.id.tv_details_caption)
    TextView tvDetailsCaption;

    public NewProductDetailsViewHodler(View itemView , INewProductDetailsDelegate iNewProductDetailsDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.mDelegate = iNewProductDetailsDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onTapImage(mNewProduct);
            }
        });
    }

    public void setNewProductDetails(NewProductVO newProduct) {
        this.mNewProduct = newProduct;
        if (newProduct != null) {
            Glide.with(itemView.getContext())
                    .load(newProduct.getProductImage())
                    .into(ivDetailsPublication);
            tvDetailsCaption.setText(newProduct.getProductTitle());
        }
    }
}
