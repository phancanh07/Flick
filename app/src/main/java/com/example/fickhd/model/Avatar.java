package com.example.fickhd.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Avatar {

    private String nameAvatar;
    private String urlAvatar;
    public Avatar() {
    }

    public Avatar(String nameAvatar, String urlAvatar) {
        this.nameAvatar = nameAvatar;
        this.urlAvatar = urlAvatar;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public String getNameAvatar() {
        return nameAvatar;
    }

    public void setNameAvatar(String nameAvatar) {
        this.nameAvatar = nameAvatar;
    }
}