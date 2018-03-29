package mindtree.com.stackoverflow.restclient.responsemodel;

import java.io.Serializable;

/**
 * Created by M1030452 on 3/28/2018.
 */

public class UserDetail implements Serializable{
    private String last_access_date;

    private String account_id;

    private String location;

    private String accept_rate;

    private String user_type;

    private String profile_image;

    private String link;

    private String reputation_change_week;

    private String reputation_change_day;

    private String creation_date;

    private BadgeCount badge_counts;

    private String display_name;

    private String is_employee;

    private String last_modified_date;

    private String age;

    private String reputation;

    private String reputation_change_year;

    private String website_url;

    private String user_id;

    private String reputation_change_month;

    private String reputation_change_quarter;

    public String getLast_access_date() {
        return last_access_date;
    }

    public void setLast_access_date(String last_access_date) {
        this.last_access_date = last_access_date;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAccept_rate() {
        return accept_rate;
    }

    public void setAccept_rate(String accept_rate) {
        this.accept_rate = accept_rate;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getReputation_change_week() {
        return reputation_change_week;
    }

    public void setReputation_change_week(String reputation_change_week) {
        this.reputation_change_week = reputation_change_week;
    }

    public String getReputation_change_day() {
        return reputation_change_day;
    }

    public void setReputation_change_day(String reputation_change_day) {
        this.reputation_change_day = reputation_change_day;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public BadgeCount getBadge_counts() {
        return badge_counts;
    }

    public void setBadge_counts(BadgeCount badge_counts) {
        this.badge_counts = badge_counts;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getIs_employee() {
        return is_employee;
    }

    public void setIs_employee(String is_employee) {
        this.is_employee = is_employee;
    }

    public String getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(String last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public String getReputation_change_year() {
        return reputation_change_year;
    }

    public void setReputation_change_year(String reputation_change_year) {
        this.reputation_change_year = reputation_change_year;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getReputation_change_month() {
        return reputation_change_month;
    }

    public void setReputation_change_month(String reputation_change_month) {
        this.reputation_change_month = reputation_change_month;
    }

    public String getReputation_change_quarter() {
        return reputation_change_quarter;
    }

    public void setReputation_change_quarter(String reputation_change_quarter) {
        this.reputation_change_quarter = reputation_change_quarter;
    }

    @Override
    public String toString() {
        return "ClassPojo [last_access_date = " + last_access_date + ", account_id = " + account_id + ", location = " + location + ", accept_rate = " + accept_rate + ", user_type = " + user_type + ", profile_image = " + profile_image + ", link = " + link + ", reputation_change_week = " + reputation_change_week + ", reputation_change_day = " + reputation_change_day + ", creation_date = " + creation_date + ", badge_counts = " + badge_counts + ", display_name = " + display_name + ", is_employee = " + is_employee + ", last_modified_date = " + last_modified_date + ", age = " + age + ", reputation = " + reputation + ", reputation_change_year = " + reputation_change_year + ", website_url = " + website_url + ", user_id = " + user_id + ", reputation_change_month = " + reputation_change_month + ", reputation_change_quarter = " + reputation_change_quarter + "]";
    }
}

