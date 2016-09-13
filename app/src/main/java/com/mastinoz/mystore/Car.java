package com.mastinoz.mystore;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by hassan on 8/6/16.
 */
public class Car extends RealmObject{

    @PrimaryKey
    private String     id;
    private String  name;
    private String  model;
    private boolean status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
