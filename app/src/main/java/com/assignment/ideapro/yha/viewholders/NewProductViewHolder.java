package com.assignment.ideapro.yha.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.assignment.ideapro.yha.data.vos.NewProductVO;
import com.assignment.ideapro.yha.delegates.INewProductDelegate;

public class NewProductViewHolder extends RecyclerView.ViewHolder {

    private INewProductDelegate mDelegate;
    private NewProductVO mNewProduct;

    public NewProductViewHolder(View itemView, INewProductDelegate newProductDelegate) {
        super(itemView);
        this.mDelegate = newProductDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onTapImage(mNewProduct);
            }
        });
    }
}
