package com.example.mohamed.testlink;

/**
 * Created by dino on 23/11/14.
 */
public class User {

    String NAME = "name";
    String Address = "";
    String GroupId = "GroupID";

    String ADDRESS = "address";

    String BLOOD_TYPE = "Blood";

    String phone = "phone";

    String ADDITIONAL = "additional";

    String HealthCondition = "HealthCondition";

    String Email = "email";

    String USER_DONATION = "UserDonation";

    String birthdate = "birthDate";

    String Date = "";
    String Post;
    public String getUsername() {
        return NAME;
    }

    public void setUsername(String name) {
        this.NAME = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setUserEmail(String Email) {
        this.Email = Email;
    }

    public String getUserAddress() {
        return this.Address;
    }

    public void setUserAddress(String address) {
        this.Address = address;
    }

    public String getUserBirthDate() {
        return birthdate;
    }

    public void setUserBirthday(String Birthday) {
        this.birthdate = Birthday;
    }

    public void setUserBlood(String Blood) {
        this.BLOOD_TYPE = Blood;
    }

    public String getUserBloood() {
        return BLOOD_TYPE;
    }


    public String getUserHealthCondition() {
        return HealthCondition;
    }

    public void setUserHealthCondition(String HealthCondition) {
        this.HealthCondition = HealthCondition;
    }

    public String getUserPhone() {
        return phone;
    }

    public void setUserPhone(String phone) {
        this.phone = phone;
    }


    public String getUserGroupId() {
        return GroupId;
    }

    public void setUserGroupID(String phone) {
        this.GroupId = phone;
    }

    public void setUserDate(String Date) {
        this.Date = Date;
    }

    public String getUserDate() {
        return this.Date;
    }



    public void setUserPost(String Post) {
        this.Post = Post;
    }

    public String getUserPost() {
        return this.Post;
    }
}
