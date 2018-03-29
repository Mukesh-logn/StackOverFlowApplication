package mindtree.com.stackoverflow.model;

import mindtree.com.stackoverflow.restclient.responsemodel.UserDetailResponse;

/**
 * Created by M1030452 on 3/28/2018.
 */

public interface IMainActivityModel {
    interface OnServiceFinishedListener {
        void onSuccess(UserDetailResponse userDetailResponse);

        void onFailure(String error);
    }

    void getUserDetail(String pageNumber, OnServiceFinishedListener listener);
}
