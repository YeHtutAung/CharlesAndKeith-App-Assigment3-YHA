package com.assignment.ideapro.yha.network.retrofit;


import com.assignment.ideapro.yha.network.responses.GetNewsResponse;
import com.assignment.ideapro.yha.utils.NewProductConstant;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NewProductAPI {
    @FormUrlEncoded
    @POST(NewProductConstant.API_GET_NEWS_PRODUCT_LIST)
    Call<GetNewsResponse> loadNewList(
            @Field(NewProductConstant.PARAM_ACCESS_TOKEN) String accessToken,
            @Field(NewProductConstant.PARAM_PAGE) int page);
}
