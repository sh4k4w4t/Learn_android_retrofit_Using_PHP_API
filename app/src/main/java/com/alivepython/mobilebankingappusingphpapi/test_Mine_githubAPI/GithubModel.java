package com.alivepython.mobilebankingappusingphpapi.test_Mine_githubAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GithubModel {
    @SerializedName("login")
    private String login;

    @SerializedName("id")
    private String id;

    @SerializedName("node_id")
    private String node_id;

    @SerializedName("avatar_url")
    private String avatar_url;

    public GithubModel() {
    }

    public GithubModel(String login, String id, String node_id, String avatar_url) {
        this.login = login;
        this.id = id;
        this.node_id = node_id;
        this.avatar_url = avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}

