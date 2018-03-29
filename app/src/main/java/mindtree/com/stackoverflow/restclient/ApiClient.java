package mindtree.com.stackoverflow.restclient;

import java.io.IOException;

import mindtree.com.stackoverflow.util.AppConstant;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;
    private static ApiInterface mClient;

    public interface OnDataReceived<T> {
        void onDataSuccess(T object);

        void onDataFailure(String error);
    }

    public static ApiInterface getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mClient = retrofit.create(ApiInterface.class);
    }

    public <T extends RetroBaseResponse> void onResponse(retrofit2.Response<T> response,
                                                         OnDataReceived callBack) {
        String errMessage = "Unknown error";
        T result = null;
        if (response.isSuccessful()) {
            if (response.body() != null) {
                result = response.body();
            } else {
                errMessage = "Parser error";
            }
        } else {
            try {
                errMessage = response.errorBody().string();
            } catch (IOException e) {
                e.printStackTrace();
                errMessage = e.getMessage();
            }
        }

        if (result == null) {
            callBack.onDataFailure(errMessage);
        } else {
            callBack.onDataSuccess(result);

        }

    }
}
