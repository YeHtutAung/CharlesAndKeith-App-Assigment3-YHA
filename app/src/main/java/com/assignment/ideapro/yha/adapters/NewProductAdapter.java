package com.assignment.ideapro.yha.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.assignment.ideapro.yha.R;
import com.assignment.ideapro.yha.delegates.INewProductDelegate;
import com.assignment.ideapro.yha.viewholders.NewProductViewHolder;

public class NewProductAdapter extends RecyclerView.Adapter<NewProductViewHolder> {

    private INewProductDelegate mDelegate;

    public NewProductAdapter(INewProductDelegate mDelegate) {
        this.mDelegate = mDelegate;
    }

    @NonNull
    @Override
    public NewProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_new_product, parent, false);

        return new NewProductViewHolder(view, mDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull NewProductViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
