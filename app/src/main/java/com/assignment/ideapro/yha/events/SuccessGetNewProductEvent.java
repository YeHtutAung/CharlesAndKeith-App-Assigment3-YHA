package com.assignment.ideapro.yha.events;

import com.assignment.ideapro.yha.data.vos.NewProductVO;
import java.util.ArrayList;
import java.util.List;

public class SuccessGetNewProductEvent {
    List<NewProductVO> newProductList = null;

    public SuccessGetNewProductEvent(List<NewProductVO> newsList) {
        this.newProductList = newsList;
    }

    public List<NewProductVO> getNewProductList() {
        if (newProductList == null) {
            newProductList = new ArrayList<>();
        }
        return newProductList;
    }
}
