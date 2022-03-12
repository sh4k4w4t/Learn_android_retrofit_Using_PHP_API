package com.alivepython.mobilebankingappusingphpapi.main_Apps_mobileBanking.model;

public class DataController {

    public static DataController instance;

    public static DataController getInstance(){
        if (instance==null){
            instance=new DataController();
            return instance;
        }
        return instance;
    };

    UserModel currentUser;

    public UserModel getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserModel currentUser) {
        this.currentUser = currentUser;
    }
}
