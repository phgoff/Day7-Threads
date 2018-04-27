package com.phirathat.day7.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 5835512090 on 4/27/2018.
 */


public class GitHubUser {

    @SerializedName("login")  // name indicated in JSON
    private String login;

    @SerializedName("name")
    private String name;

    @SerializedName("company")
    private String company;

    @SerializedName("blog")
    private String blog;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "name: " + name + "\ncompany: " + company + "\nblog: " + blog;
    }
}
