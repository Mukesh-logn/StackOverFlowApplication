package mindtree.com.stackoverflow.model;

import mindtree.com.stackoverflow.restclient.ApiClient;
import mindtree.com.stackoverflow.restclient.request.RequestGetUserDetail;
import mindtree.com.stackoverflow.restclient.responsemodel.UserDetailResponse;

/**
 * Created by M1030452 on 3/28/2018.
 */

public class MainActivityModel implements IMainActivityModel {
    @Override
    public void getUserDetail(String pageNumber, final OnServiceFinishedListener listener) {
        new RequestGetUserDetail<>(pageNumber, new ApiClient.OnDataReceived<UserDetailResponse>() {
            @Override
            public void onDataSuccess(UserDetailResponse userDetailResponse) {
                listener.onSuccess(userDetailResponse);
            }

            @Override
            public void onDataFailure(String error) {
                listener.onFailure(error);
            }
        }).callService();
    }
}
