package com.assignment.ideapro.yha.data.models;

import com.assignment.ideapro.yha.data.vos.NewProductVO;
import com.assignment.ideapro.yha.events.SuccessGetNewProductEvent;
import com.assignment.ideapro.yha.network.NewProductDataAgent;
import com.assignment.ideapro.yha.network.retrofit.RetrofitDataAgentImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

public class NewProductModel {

    private static NewProductModel objectInstance;
    private NewProductDataAgent mDataAgent;
    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private Map<Integer, NewProductVO> mTalksMap;

    public NewProductModel() {
        mTalksMap = new HashMap<>();
        mDataAgent = RetrofitDataAgentImpl.getInstance();
        EventBus.getDefault().register(this);
    }

    public void loadNewProductList() {
        mDataAgent.loadNewProductList(1, DUMMY_ACCESS_TOKEN);
    }

    public static NewProductModel getIObjectInstance() {

        if (objectInstance == null) {
            objectInstance = new NewProductModel();
        }
        return objectInstance;
    }

    public NewProductVO getTalkById(int newsId) {
        return mTalksMap.get(newsId);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessGetTalks(SuccessGetNewProductEvent event) {
        for(NewProductVO newProduct : event.getNewProductList()) {
            mTalksMap.put(newProduct.getProductId(), newProduct);
        }
    }
}
