package mindtree.com.stackoverflow.view;

import mindtree.com.stackoverflow.restclient.responsemodel.UserDetailResponse;

/**
 * Created by M1030452 on 3/28/2018.
 */

public interface IMainActivityView {
    void setUserDetail(UserDetailResponse movieRecord);
    void failToLoad(String errorMessage);
}
