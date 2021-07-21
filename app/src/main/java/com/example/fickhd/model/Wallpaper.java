package com.example.fickhd.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Wallpaper {

    @SerializedName("avatar")
    @Expose
    private List<Avatar> avatar = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("tenanh")
    @Expose
    private String tenanh;
    @SerializedName("__v")
    @Expose
    private String v;

    public List<Avatar> getAvatar() {
        return avatar;
    }

    public void setAvatar(List<Avatar> avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenanh() {
        return tenanh;
    }

    public void setTenanh(String tenanh) {
        this.tenanh = tenanh;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

}