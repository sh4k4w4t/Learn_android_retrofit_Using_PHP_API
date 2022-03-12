package com.alivepython.mobilebankingappusingphpapi.main_Apps_mobileBanking.model;

public class UserModel {
    String userName;
    String userPhone;
    String userPin;
    int userBalance;
    String userId;
    String userResponse;

    public UserModel() {
    }

    public UserModel(String userName, String userPhone, String userPin, int userBalance, String userId, String userResponse) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.userPin = userPin;
        this.userBalance = userBalance;
        this.userId = userId;
        this.userResponse = userResponse;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPin() {
        return userPin;
    }

    public void setUserPin(String userPin) {
        this.userPin = userPin;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(String userResponse) {
        this.userResponse = userResponse;
    }
}
