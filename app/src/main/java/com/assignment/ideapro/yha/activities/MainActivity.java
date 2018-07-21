package com.assignment.ideapro.yha.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.assignment.ideapro.yha.R;
import com.assignment.ideapro.yha.adapters.NewProductAdapter;
import com.assignment.ideapro.yha.data.models.NewProductModel;
import com.assignment.ideapro.yha.data.vos.NewProductVO;
import com.assignment.ideapro.yha.delegates.INewProductDelegate;
import com.assignment.ideapro.yha.events.SuccessGetNewProductEvent;
import com.assignment.ideapro.yha.utils.NewProductConstant;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements INewProductDelegate{

    private NewProductAdapter mNewProductAdapter;

    @BindView(R.id.tv_item_count)
    TextView tvItemCount;

    @BindView(R.id.iv_single_square)
    ImageView ivSingleView;

    @BindView(R.id.iv_double_square)
    ImageView ivDoubleView;

    @BindView(R.id.v_single_square)
    View vSingleViewSquare;
    @BindView(R.id.v_double_square)
    View vDoubleViewSquare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this, this);

        RecyclerView rvNewProduct = findViewById(R.id.rv_new_product);
        mNewProductAdapter = new NewProductAdapter(this);

        rvNewProduct.setAdapter(mNewProductAdapter);
        rvNewProduct.setLayoutManager(new GridLayoutManager(this, 2));

        ivSingleView.setOnClickListener(v -> {
            rvNewProduct.setLayoutManager(new GridLayoutManager(v.getContext(), 1));
            vSingleViewSquare.setVisibility(View.VISIBLE);
            vDoubleViewSquare.setVisibility(View.GONE);
        });

        ivDoubleView.setOnClickListener(v -> {
            rvNewProduct.setLayoutManager(new GridLayoutManager(v.getContext(), 2));
            vDoubleViewSquare.setVisibility(View.VISIBLE);
            vSingleViewSquare.setVisibility(View.GONE);
        });

        NewProductModel.getIObjectInstance().loadNewProductList();
    }

    @Override
    public void onTapImage(NewProductVO newProductVO) {
        Intent intent = new Intent(getApplicationContext(), NewProductDetailsActivity.class);
        intent.putExtra(NewProductConstant.KEY_NEW_PRODUCT, newProductVO.getProductId());
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetTalks(SuccessGetNewProductEvent event) {
        Log.d("onSuccessGetTalks", "onSuccessGetTalks : " + event.getNewProductList());
        mNewProductAdapter.setNewProductList(event.getNewProductList());
        tvItemCount.setText(mNewProductAdapter.getItemCount() + " ITEMS");
    }
}
