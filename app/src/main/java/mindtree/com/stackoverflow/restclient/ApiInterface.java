package mindtree.com.stackoverflow.restclient;

import mindtree.com.stackoverflow.restclient.responsemodel.UserDetailResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    /* POST GET PUT DELETE*/

    @GET("users")
    Call<UserDetailResponse> getUserDetails(@Query("site") String stackoverflow, @Query("page") String pageNumber);
}
