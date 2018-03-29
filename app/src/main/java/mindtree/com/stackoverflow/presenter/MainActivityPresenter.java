package mindtree.com.stackoverflow.presenter;

import mindtree.com.stackoverflow.model.IMainActivityModel;
import mindtree.com.stackoverflow.model.MainActivityModel;
import mindtree.com.stackoverflow.restclient.responsemodel.UserDetailResponse;
import mindtree.com.stackoverflow.view.IMainActivityView;

/**
 * Created by M1030452 on 3/28/2018.
 */

public class MainActivityPresenter implements IMainActivityPresenter, IMainActivityModel.OnServiceFinishedListener {
    private IMainActivityView mainActivityView;
    private IMainActivityModel mainActivityModel;

    public MainActivityPresenter(IMainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
        mainActivityModel = new MainActivityModel();
    }

    @Override
    public void getUserDetail(String pageNumber) {
        mainActivityModel.getUserDetail(pageNumber, this);
    }

    @Override
    public void onSuccess(UserDetailResponse userDetailResponse) {
        mainActivityView.setUserDetail(userDetailResponse);
    }

    @Override
    public void onFailure(String error) {
        mainActivityView.failToLoad(error);
    }
}
