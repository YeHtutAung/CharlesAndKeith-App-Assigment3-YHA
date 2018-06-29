package com.assignment.ideapro.yha.data.vos;

import com.google.gson.annotations.SerializedName;

public class NewProductVO {

    @SerializedName("product-id")
    private int productId = 0;
    @SerializedName("product-image")
    private String productImage = null;
    @SerializedName("product-title")
    private String productTitle = null;

    public int getProductId() {
        return productId;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }
}
