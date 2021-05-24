package com.cn.cx.util.bean;
public class GoodBook {
    private  int id;
    private String title;
    private String  user_id;
    private  String user_content;
    private  String  time;
    private String image;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_content(String user_content) {
        this.user_content = user_content;
    }
    public String getUser_content() {
        return user_content;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}
