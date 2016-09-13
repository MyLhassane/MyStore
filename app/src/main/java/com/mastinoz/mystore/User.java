package com.mastinoz.mystore;

import io.realm.RealmObject;

/**
 * Created by hassan on 8/9/16.
 */
public class User extends RealmObject {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
