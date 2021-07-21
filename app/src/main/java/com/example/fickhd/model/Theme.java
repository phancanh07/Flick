package com.example.fickhd.model;

public class Theme {
    private String avatarCard;
    private String theme_id;

    public Theme() {
    }

    public Theme(String avatarCard, String theme_id) {
        this.avatarCard = avatarCard;
        this.theme_id = theme_id;
    }

    public String getAvatarCard() {
        return avatarCard;
    }

    public void setAvatarCard(String avatarCard) {
        this.avatarCard = avatarCard;
    }

    public String getTheme_id() {
        return theme_id;
    }

    public void setTheme_id(String theme_id) {
        this.theme_id = theme_id;
    }
}
