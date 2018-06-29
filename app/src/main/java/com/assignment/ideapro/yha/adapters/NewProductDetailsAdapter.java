package com.assignment.ideapro.yha.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.assignment.ideapro.yha.R;
import com.assignment.ideapro.yha.data.vos.NewProductVO;
import com.assignment.ideapro.yha.delegates.INewProductDetailsDelegate;
import com.assignment.ideapro.yha.viewholders.NewProductDetailsViewHodler;

public class NewProductDetailsAdapter extends RecyclerView.Adapter<NewProductDetailsViewHodler> {

    private INewProductDetailsDelegate mDelegate;
    private NewProductVO newProductVO;

    public NewProductDetailsAdapter(INewProductDetailsDelegate mDelegate) {
        this.mDelegate = mDelegate;
        this.newProductVO = new NewProductVO();
    }

    @NonNull
    @Override
    public NewProductDetailsViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_new_product_details, parent, false);

        return new NewProductDetailsViewHodler(view, mDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull NewProductDetailsViewHodler holder, int position) {
        holder.setNewProductDetails(newProductVO);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public void setNewProductList(NewProductVO newProductVO) {
        this.newProductVO = newProductVO;
        notifyDataSetChanged();
    }
}
