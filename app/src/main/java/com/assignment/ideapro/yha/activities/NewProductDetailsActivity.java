package com.assignment.ideapro.yha.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.assignment.ideapro.yha.R;
import com.assignment.ideapro.yha.adapters.NewProductAdapter;
import com.assignment.ideapro.yha.adapters.NewProductDetailsAdapter;
import com.assignment.ideapro.yha.data.models.NewProductModel;
import com.assignment.ideapro.yha.data.vos.NewProductVO;
import com.assignment.ideapro.yha.delegates.INewProductDelegate;
import com.assignment.ideapro.yha.delegates.INewProductDetailsDelegate;
import com.assignment.ideapro.yha.utils.NewProductConstant;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewProductDetailsActivity extends BaseActivity implements INewProductDetailsDelegate {

    private NewProductDetailsAdapter newProductDetailsAdapter;

    @BindView(R.id.tv_caption)
    TextView tvCaption;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product_details);

        ButterKnife.bind(this, this);

        RecyclerView rvNewProduct = findViewById(R.id.rv_new_product_details);
        newProductDetailsAdapter = new NewProductDetailsAdapter(this);
        rvNewProduct.setAdapter(newProductDetailsAdapter);
        rvNewProduct.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        int newProductId = getIntent().getIntExtra(NewProductConstant.KEY_NEW_PRODUCT, 0);
        NewProductVO newProductVO = NewProductModel.getIObjectInstance().getTalkById(newProductId);
        newProductDetailsAdapter.setNewProductList(newProductVO);
        tvCaption.setText(newProductVO.getProductTitle());
    }

    @Override
    public void onTapImage(NewProductVO talk) {

    }

    @Override
    public void onTapInfo() {

    }
}
