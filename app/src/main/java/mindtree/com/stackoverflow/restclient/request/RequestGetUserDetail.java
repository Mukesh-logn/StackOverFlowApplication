package mindtree.com.stackoverflow.restclient.request;

import android.util.Log;

import com.google.gson.Gson;

import mindtree.com.stackoverflow.restclient.ApiClient;
import mindtree.com.stackoverflow.restclient.ApiInterface;
import mindtree.com.stackoverflow.restclient.responsemodel.UserDetailResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestGetUserDetail<T> {

    private final ApiClient.OnDataReceived mCallBack;
    ApiInterface mClient;
    ApiClient mService;
    String pageNumber;

    public RequestGetUserDetail(String pageNumber, ApiClient.OnDataReceived<T>
            callback) {
        this.mClient = ApiClient.getClient();
        this.mService = new ApiClient();
        mCallBack = callback;
        this.pageNumber = pageNumber;
    }


    public void callService() {
        Call<UserDetailResponse> call =
                mClient.getUserDetails("stackoverflow", pageNumber);

        call.enqueue(new Callback<UserDetailResponse>() {
            @Override
            public void onResponse(Call<UserDetailResponse> call,
                                   Response<UserDetailResponse> response) {

                mService.onResponse(response, mCallBack);
            }

            @Override
            public void onFailure(Call<UserDetailResponse> call, Throwable t) {
                mCallBack.onDataFailure(t.getMessage());
            }
        });
    }
}
