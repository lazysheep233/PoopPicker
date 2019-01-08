package com.plteautech.pooppicker.fragment;

public class TipBean {

    private String userImg;
    private String name;
    private String time;
    private String img1;
    private String img2;
    private String img3;
    private String text;

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getImg1() {
        return img1;
    }

    public String getImg2() {
        return img2;
    }

    public String getImg3() {
        return img3;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

