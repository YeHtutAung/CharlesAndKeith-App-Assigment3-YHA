package com.assignment.ideapro.yha.network.retrofit;

import com.assignment.ideapro.yha.events.ApiErrorEvent;
import com.assignment.ideapro.yha.events.SuccessGetNewProductEvent;
import com.assignment.ideapro.yha.network.NewProductDataAgent;
import com.assignment.ideapro.yha.network.responses.GetNewsResponse;
import com.assignment.ideapro.yha.utils.NewProductConstant;
import org.greenrobot.eventbus.EventBus;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements NewProductDataAgent {

    private static RetrofitDataAgentImpl sObjectInstance;

    private NewProductAPI newProductAPI;

    private RetrofitDataAgentImpl() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NewProductConstant.MM_NEW_PRODUCT_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        newProductAPI = retrofit.create(NewProductAPI.class);
    }

    public static RetrofitDataAgentImpl getInstance() {
        if (sObjectInstance == null) {
            sObjectInstance = new RetrofitDataAgentImpl();
        }
        return sObjectInstance;
    }


    @Override
    public void loadNewProductList(int page, String accessToken) {
        Call<GetNewsResponse> loadNewsCall = newProductAPI.loadNewList(accessToken, page);
        loadNewsCall.enqueue(new Callback<GetNewsResponse>() {
            @Override
            public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response) {
                // to get object from generic type
                GetNewsResponse getNewsResponse = response.body();
                if (getNewsResponse != null && getNewsResponse.isResponseOK()) {
                    // event broadcast
                    SuccessGetNewProductEvent event =  new SuccessGetNewProductEvent(getNewsResponse.getNewProduct());
                    EventBus.getDefault().post(event);
                } else {
                    if (getNewsResponse == null) {
                        ApiErrorEvent errorEvent = new ApiErrorEvent("Empty response in network call");
                        EventBus.getDefault().post(errorEvent);
                    } else {
                        ApiErrorEvent errorEvent = new ApiErrorEvent(getNewsResponse.getMessage());
                        EventBus.getDefault().post(errorEvent);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetNewsResponse> call, Throwable t) {
                ApiErrorEvent errorEvent = new ApiErrorEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }
}
