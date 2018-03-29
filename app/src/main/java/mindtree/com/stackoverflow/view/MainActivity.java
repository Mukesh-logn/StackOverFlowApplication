package mindtree.com.stackoverflow.view;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import mindtree.com.stackoverflow.R;
import mindtree.com.stackoverflow.adapter.UserAdapter;
import mindtree.com.stackoverflow.data.UserDetailContract;
import mindtree.com.stackoverflow.data.UserDetailDBHelper;
import mindtree.com.stackoverflow.presenter.IMainActivityPresenter;
import mindtree.com.stackoverflow.presenter.MainActivityPresenter;
import mindtree.com.stackoverflow.restclient.responsemodel.UserDetail;
import mindtree.com.stackoverflow.restclient.responsemodel.UserDetailResponse;

public class MainActivity extends AppCompatActivity implements IMainActivityView {
    private IMainActivityPresenter mPresenter;
    private RecyclerView recyclerView;
    private EditText searchEditText;
    private ArrayList<UserDetail> userDetailList = new ArrayList<>();
    private UserAdapter mAdapter;
    private int visibleThreshold = 25;
    private int lastVisibleItem, totalItemCount;
    private boolean isSearchEnable = false, isLoading = false;
    private static int countPage = 1;
    private ProgressBar progressBar;

    //database related field
    private UserDetailDBHelper productDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        searchEditText = (EditText) findViewById(R.id.search_text);
        mAdapter = new UserAdapter(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold) && !isSearchEnable) {
                    lastVisibleItem = totalItemCount;
                    progressBar.setVisibility(View.VISIBLE);
                    onLoadMore();
                    isLoading = true;
                }
            }
        });

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                isSearchEnable = true;
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")) {
                    isSearchEnable = false;
                }
                search(s.toString());
            }
        });
        productDBHelper = new UserDetailDBHelper(this);
    }

    private void search(String s) {
        ArrayList<UserDetail> temp = new ArrayList();
        for (UserDetail d : userDetailList) {

            if (d.getDisplay_name().toLowerCase().contains(s.toLowerCase())) {
                temp.add(d);
            }
        }
        mAdapter.updateAdapter(temp);
    }

    private void onLoadMore() {
        countPage++;
        mPresenter.getUserDetail(String.valueOf(countPage));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter = new MainActivityPresenter(this);
        mPresenter.getUserDetail("1");

    }

    @Override
    protected void onStop() {
        super.onStop();
        insertInDataBase(userDetailList);
    }

    @Override
    public void setUserDetail(UserDetailResponse userDetails) {
        if (userDetailList != null) {
            userDetailList.addAll(userDetails.getUserDetails());
            progressBar.setVisibility(View.GONE);
            isLoading = false;

        } else {
            userDetailList = userDetails.getUserDetails();
        }
        mAdapter.updateAdapter(userDetailList);

    }

    private void insertInDataBase(ArrayList<UserDetail> userDetailList) {
        SQLiteDatabase sqLiteDatabase = productDBHelper.getWritableDatabase();
        for (UserDetail ud : userDetailList) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(UserDetailContract.UserDetailEntity.COLUMN_USER_NAME, ud.getDisplay_name());
            contentValues.put(UserDetailContract.UserDetailEntity.COLUMN_USER_REPUTATION, ud.getReputation());
            contentValues.put(UserDetailContract.UserDetailEntity.COLUMN_USER_IMAGE, ud.getProfile_image());
            sqLiteDatabase.insert(UserDetailContract.UserDetailEntity.TABLE_NAME, null, contentValues);
        }


    }

    @Override
    public void failToLoad(String errorMessage) {
        progressBar.setVisibility(View.GONE);
        SQLiteDatabase sqLiteDatabase = productDBHelper.getReadableDatabase();
        Cursor c = sqLiteDatabase.query(UserDetailContract.UserDetailEntity.TABLE_NAME, null,
                null, null, null, null, null);
        if (c != null) {
            while (c.moveToNext()) {
                UserDetail userDetail = new UserDetail();
                userDetail.setDisplay_name(c.getString(c.getColumnIndex(UserDetailContract.UserDetailEntity.COLUMN_USER_NAME)));
                userDetail.setReputation(c.getString(c.getColumnIndex(UserDetailContract.UserDetailEntity.COLUMN_USER_REPUTATION)));
                userDetail.setProfile_image(c.getString(c.getColumnIndex(UserDetailContract.UserDetailEntity.COLUMN_USER_IMAGE)));
                userDetailList.add(userDetail);
            }
            mAdapter.updateAdapter(userDetailList);
        }
    }
}
