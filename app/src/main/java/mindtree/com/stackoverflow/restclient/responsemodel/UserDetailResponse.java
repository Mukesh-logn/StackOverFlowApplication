package mindtree.com.stackoverflow.restclient.responsemodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

import mindtree.com.stackoverflow.restclient.RetroBaseResponse;

/**
 * Created by M1030452 on 3/28/2018.
 */

public class UserDetailResponse extends RetroBaseResponse implements Serializable {
    private String quota_max;
    @SerializedName("items")
    private ArrayList<UserDetail> userDetails;

    private String has_more;

    private String quota_remaining;

    public String getQuota_max() {
        return quota_max;
    }

    public void setQuota_max(String quota_max) {
        this.quota_max = quota_max;
    }

    public ArrayList<UserDetail> getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(ArrayList<UserDetail> userDetails) {
        this.userDetails = userDetails;
    }

    public String getHas_more() {
        return has_more;
    }

    public void setHas_more(String has_more) {
        this.has_more = has_more;
    }

    public String getQuota_remaining() {
        return quota_remaining;
    }

    public void setQuota_remaining(String quota_remaining) {
        this.quota_remaining = quota_remaining;
    }

    @Override
    public String toString() {
        return "ClassPojo [quota_max = " + quota_max + ", userDetails = " + userDetails + ", has_more = " + has_more + ", quota_remaining = " + quota_remaining + "]";
    }
}
