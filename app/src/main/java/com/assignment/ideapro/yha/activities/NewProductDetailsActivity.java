package com.assignment.ideapro.yha.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.assignment.ideapro.yha.R;
import com.assignment.ideapro.yha.adapters.NewProductAdapter;
import com.assignment.ideapro.yha.data.vos.NewProductVO;
import com.assignment.ideapro.yha.delegates.INewProductDelegate;

public class NewProductDetailsActivity extends BaseActivity implements INewProductDelegate {

    private NewProductAdapter mNewProductAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product_details);

        RecyclerView rvNewProduct = findViewById(R.id.rv_new_product_details);
        mNewProductAdapter = new NewProductAdapter(this);
        rvNewProduct.setAdapter(mNewProductAdapter);
        rvNewProduct.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onTapImage(NewProductVO talk) {

    }
}
