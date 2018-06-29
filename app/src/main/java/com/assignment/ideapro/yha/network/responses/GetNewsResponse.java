package com.assignment.ideapro.yha.network.responses;

import com.assignment.ideapro.yha.data.vos.NewProductVO;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetNewsResponse {
    @SerializedName("code")
    private int code = 0;
    @SerializedName("message")
    private String message = null;
    @SerializedName("apiVersion")
    private String apiVersion = null;
    @SerializedName("page")
    private String page = null;
    @SerializedName("newProducts")
    List<NewProductVO> newProduct = null;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<NewProductVO> getNewProduct() {
        if (newProduct == null) {
            newProduct = new ArrayList<>();
        }
        return newProduct;
    }

    public boolean isResponseOK() {
        return (code == 200 && newProduct != null);
    }
}
